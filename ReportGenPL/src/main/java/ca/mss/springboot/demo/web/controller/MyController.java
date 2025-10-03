package ca.mss.springboot.demo.web.controller;

import ca.mss.springboot.demo.service.MyService;
import ca.mss.springboot.demo.job.ExecutorReport;
import ca.mss.springboot.demo.job.JobExecutor;
import ca.mss.springboot.demo.job.ReportDelimeter;
import ca.mss.springboot.demo.job.ReportLogLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequestMapping("demo")
@RestController
public class MyController {

    private final MyService myService;
    private final JobExecutor jobExecutor;

    @Autowired
    public MyController(final MyService myService, JobExecutor jobExecutor) {
        this.myService = myService;
        this.jobExecutor = jobExecutor;
    }

    /**
     * @param startDate/endDate date or last month by default
     * @param logLevel reporting log level Debug, Info, Error
     * @return generated reports in CSV format
     */

    @GetMapping(path = "/report/start", produces = "application/json")
    public ResponseEntity<String> reportMizeRecon(@RequestParam(required = false) String startDate,
                                                  @RequestParam(required = false) String endDate,
                                                  @RequestParam(required = false, defaultValue = "Info") ReportLogLevel logLevel,
                                                  @RequestParam(required = false, defaultValue = "Comma") ReportDelimeter reportDelimeter,
                                                  @RequestParam(required = false) String reportName) {
        try {
            String startDate2 = myService.pickStartDateOfTheMonth(startDate, endDate);
            String endDate2 = myService.pickEndDateOfTheMonth(startDate, endDate, startDate2);
            Set<String> offersNull = new HashSet<>(10000);
            Set<String> offersNotNull = new HashSet<>(10000);
            Set<String> offersNotY = new HashSet<>(10000);
            ExecutorReport[] reports1 = new ExecutorReport[]{
                    reportName == null || "reportA".equals(reportName) ? jobExecutor.async("reportA", (ExecutorReport report) -> myService.reportA(report, startDate2, endDate2, logLevel, reportDelimeter, offersNull), logLevel) : null
                    ,reportName == null || "reportB".equals(reportName) ? jobExecutor.async("reportB", (ExecutorReport report) -> myService.reportB(report, startDate2, endDate2, logLevel, reportDelimeter, offersNotNull), logLevel) : null
                    ,reportName == null || "reportC".equals(reportName) ? jobExecutor.async("reportC", (ExecutorReport report) -> myService.reportC(report, startDate2, endDate2, logLevel, reportDelimeter, offersNotY), logLevel) : null
                    ,reportName == null || "reportD".equals(reportName) ? jobExecutor.async("reportD", (ExecutorReport report) -> myService.reportD(report, startDate2, endDate2, logLevel, reportDelimeter), logLevel) : null
            };
            // Wait until sets are populated ...
            while( jobExecutor.isProgress(reports1) ){
                try { TimeUnit.SECONDS.sleep(1L); } catch (Exception e) {}
            }
            // ... then generates rest of reports
            ExecutorReport[] reports2 = new ExecutorReport[]{
                    reportName == null || "reportD".equals(reportName) ? jobExecutor.async("reportD", (ExecutorReport report) -> myService.reportE(report, startDate2, endDate2, logLevel, reportDelimeter,
                            new Set[]{offersNull, offersNotNull,offersNotY},
                            new String[]{"NULL", "NOT_NULL", "NOT_Y"}), logLevel) : null
            };
            return jobExecutor.isStarted(reports1, reports2) ?
                    ResponseEntity.status(HttpStatus.ACCEPTED).body(jobExecutor.getJsonReport(reports1, reports2)) :
                    ResponseEntity.status(HttpStatus.OK).body(jobExecutor.getJsonReport(reports1, reports2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("{\"error\": \"Wrong date format: %s\"}", e.getMessage()));
        }
    }

    @GetMapping(path = "/report/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> dbPopulateHollow(@RequestParam(required = false) String jobName) {
        return ResponseEntity.status(HttpStatus.OK).body(jobExecutor.getJsonReport(jobName));
    }
}
