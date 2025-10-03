package ca.mss.springboot.demo.job;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.function.Predicate;

public class ReportGenerator {

    final public String filePath;
    final private FileWriter fw;

    CSVPrinter csvPrinter;
    String[] headers;
    String[] fields;

    public ReportGenerator(String filePath) throws IOException {
        this.filePath = filePath;
        this.fw = new FileWriter(filePath);
        fw.append("");
        fw.flush();
    }

    public void generate(ResultSet rs, ReportDelimeter reportDelimeter, Predicate<String[]> where) throws IOException, SQLException {
        if (headers == null) {
            ResultSetMetaData metaData = rs.getMetaData();
            headers = new String[metaData.getColumnCount()];
            fields = new String[metaData.getColumnCount()];
            for (int i = 0, max = metaData.getColumnCount(); i < max; ++i) {
                headers[i] = metaData.getColumnName(i + 1);
            }
            //System.out.println(Arrays.stream(header).collect(Collectors.joining(",")));
            csvPrinter = (reportDelimeter==ReportDelimeter.Tab) ?
                    new CSVPrinter(fw, CSVFormat.TDF.withHeader(headers)):
                    new CSVPrinter(fw, CSVFormat.EXCEL.withHeader(headers));
        }
        for (int i = 0, max = headers.length; i < max; ++i) {
            fields[i] = rs.getString(i + 1);
        }
        //System.out.println(Arrays.stream(fields).collect(Collectors.joining(",")));
        if( where.test(fields) ) {
            csvPrinter.printRecord(fields);
        }
    }

    public void flush() throws IOException {
        csvPrinter.flush();
    }
}
