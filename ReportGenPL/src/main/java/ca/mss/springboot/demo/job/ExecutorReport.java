package ca.mss.springboot.demo.job;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ExecutorReport {

    public static final String MSG_STARTED = "Job is started '%s'";
    public static final String MSG_UNKNOWN = "Job is in unknown state '%s'";
    public static final String MSG_OK = "Job is successfully done '%s'";
    public static final String MSG_ERROR = "Job is failed '%s'";
    public static final String MSG_IN_PROGRESS = "Job is in progress '%s'. Please wait...";

    private List<String> list = new LinkedList<>();
    private boolean isStarted = false;
    private boolean isProgress = true;
    private boolean isOk = false;
    private boolean isError = false;
    private String errorMessage;
    private String jobName;
    private ReportLogLevel logLevel;

    public ExecutorReport(){
       this(null);
    }

    public ExecutorReport(ReportLogLevel logLevel){
        this.logLevel = logLevel;
    }

    public String debug(String format, Object... args) {
        String msg = String.format(format, args);
        if( logLevel == ReportLogLevel.Debug ) {
            addMessage(msg);
        }
        return msg;
    }

    public String info(String format, Object... args) {
        String msg = String.format(format, args);
        if( logLevel == ReportLogLevel.Debug || logLevel == ReportLogLevel.Info ) {
            addMessage(msg);
        }
        return msg;
    }

    public String error(String format, Object... args) {
        String msg = String.format(format, args);
        addMessage(msg);
        return msg;
    }

    private void addMessage(String msg){
        if( logLevel != null ) {
            list.add(msg);
        }
    }

    public String getJson(){
        return "{ \"status\":\""+String.format(isOk? MSG_OK: isError? MSG_ERROR: isProgress? MSG_IN_PROGRESS: isStarted? MSG_STARTED: MSG_UNKNOWN , jobName)+"\",\"log"+(logLevel==null?"":logLevel)+"\":["+list.stream()
                .map(msg -> "\""+msg.replaceAll("\"", "'")+"\"")
                .collect(Collectors.joining(","))+"]}";
    }

    public ExecutorReport started(String jobName) {
        this.isStarted = true;
        this.isProgress = true;
        this.jobName = jobName;
        return this;
    }
    public ExecutorReport ok() {
        this.isOk = true;
        this.isProgress = false;
        return this;
    }

    public ExecutorReport error(String errorMessage) {
        this.errorMessage = errorMessage;
        this.isError = true;
        this.isProgress = false;
        return this;
    }

    public ExecutorReport inProgress(String jobName) {
        this.isProgress = true;
        this.jobName = jobName;
        return this;
    }

    public boolean isProgress() {
        return isProgress;
    }

    public boolean isStarted() {
        return isStarted;
    }
}
