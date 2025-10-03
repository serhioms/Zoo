package ca.mss.springboot.demo.job;

import com.priceline.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JobExecutor {

    private Map<String, Thread> threadMap = new ConcurrentHashMap<>(16);
    private Map<String, ExecutorReport> reportMap = new ConcurrentHashMap<>(16);

    public ExecutorReport async(String name, Consumer<ExecutorReport> job, ReportLogLevel logLevel){
        if(Objects.isNull(threadMap.get(name)) || !threadMap.get(name).isAlive()) {
            ExecutorReport report = new ExecutorReport(logLevel);
            reportMap.put(name, report);
            threadMap.put(name, new Thread(() -> accept(name, job, report)));
            threadMap.get(name).start();
            return report.started(name);
        }
        return reportMap.get(name).inProgress(name);
    }

    public ExecutorReport sync(String name, Consumer<ExecutorReport> job, ReportLogLevel logLevel){
        if(Objects.isNull(threadMap.get(name)) || !threadMap.get(name).isAlive()) {
            ExecutorReport report = new ExecutorReport(logLevel);
            reportMap.put(name, report);
            try {
                threadMap.put(name, Thread.currentThread());
                accept(name, job, report);
            } finally {
                threadMap.remove(name);
            }
            return report.started(name);
        }
        return reportMap.get(name).inProgress(name);
    }

    public void accept(String name, Consumer<ExecutorReport> job, ExecutorReport report) {
        try {
            call(name, ()->{job.accept(report); return true;}, report);
            report.ok();
        } catch (Exception e){
            report.error(e.getMessage());
            log.error(e.getMessage(), e);
        }
    }

    public <T> T call(String name, Callable<T> job, ExecutorReport report) {
        T result = null;
        try {
            log.info(report.info("%s starts at %s", name, LocalTime.now()));
            result = job.call();
            report.ok();
            log.info(report.info("%s ends at %s", name, LocalTime.now()));
        } catch (Exception e){
            report.error(e.getMessage());
            throw new RuntimeException(report.error("%s failed at %s: %s - %s", name, LocalTime.now(), e.getClass().getSimpleName(), e.getMessage()), e);
        }
        return result;
    }

    public String getJsonReport(String jobName) {
        if (reportMap.isEmpty()){
            return "{\"error\":\"There is no report yet\"}";
        } else if(StringUtils.isNullOrEmpty(jobName) ){
            return getJsonReport(reportMap.keySet().stream().collect(Collectors.joining(",")));
        } else {
            String[] jobs = jobName.split(",");
            if( jobs.length == 1) {
                return reportMap.containsKey(jobName) ? reportMap.get(jobName).getJson() : "{\"error\":\"There is no report for job " + jobName + "\"}";
            } else {
                String result = "";
                for(String job: jobs){
                    result += (result.isEmpty()?"":",")+(reportMap.containsKey(job) ? reportMap.get(job).getJson() : "{\"error\":\"There is no report for job " + job + "\"}");
                }
                return "{["+result+"]}";
            }
        }
    }


    public String getJsonReport(ExecutorReport[]... reports) {
        return "{["+Arrays.stream(reports).flatMap(a ->Arrays.stream(a)).filter(Objects::nonNull).map(report->report.getJson()).collect(Collectors.joining(","))+"]}";
    }

    public boolean isProgress(ExecutorReport[]... reports) {
        for(ExecutorReport[] reports2: reports){
            for(ExecutorReport report: reports2){
                if( report != null && report.isProgress() ){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStarted(ExecutorReport[]... reports) {
        for(ExecutorReport[] reports2: reports){
            for(ExecutorReport report: reports2){
                if( report != null && !report.isStarted() ){
                    return false;
                }
            }
        }
        return true;
    }
}
