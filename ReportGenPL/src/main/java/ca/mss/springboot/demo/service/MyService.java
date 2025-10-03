package ca.mss.springboot.demo.service;

import ca.mss.springboot.demo.job.ExecutorReport;
import ca.mss.springboot.demo.job.ReportDelimeter;
import ca.mss.springboot.demo.job.ReportGenerator;
import ca.mss.springboot.demo.job.ReportLogLevel;
import com.priceline.finance.reconcommon.dto.ARLineDetail;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.Types;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MyService {

	private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String MIZE_REPORT_PATH = "/Users/smoskovskiy/apps/home/eng/report";
	public static final int OFFER_NUMBER_IDX = 0;

	@Autowired
	PropertiesFactoryBean mizeQuery;

	@Autowired
	@Qualifier("acctJdbcTemplate")
	JdbcTemplate acctJdbcTemplate;

	@Autowired
	@Qualifier("cmsJdbcTemplate")
	JdbcTemplate cmsJdbcTemplate;

	public void reportA(ExecutorReport report, String startDate, String endDate, ReportLogLevel logLevel, ReportDelimeter reportDelimeter, Set<String> offersNull) {
		try {
			log.info("Accepted Mize.reportA for period from {} to {}", startDate, endDate);
			ReportGenerator ReportGenerator = new ReportGenerator(MIZE_REPORT_PATH+"/"+ startDate+" to "+endDate+"-rebook_cancel_NULL.csv");
			String sql = mizeQuery.getObject().getProperty("mize.query.A");
			Object[] args = new Object[]{startDate, endDate};
			int[] argTypes = new int[]{Types.NVARCHAR,Types.NVARCHAR};
			cmsJdbcTemplate.query(sql, args, argTypes, (ResultSet rs)->{
				try {
					ReportGenerator.generate(rs, reportDelimeter, (String[] fields)->offersNull.add(fields[OFFER_NUMBER_IDX]));
				} catch (final Exception e) {
					log.error("Error while generating Mize.reportA: {}", e.getMessage(), e);
				}
			});
			ReportGenerator.flush();
			log.debug("Returning Mize.reportA for period from {} to {}", startDate, endDate);
		} catch (final Exception e) {
			log.error("Error while generating Mize.reportA: {}", e.getMessage(), e);
		}
	}

	public void reportB(ExecutorReport report, String startDate, String endDate, ReportLogLevel logLevel, ReportDelimeter reportDelimeter, Set<String> offersNotNull) {
		try {
			log.info("Accepted Mize.reportB for period from {} to {}", startDate, endDate);
			ReportGenerator ReportGenerator = new ReportGenerator(MIZE_REPORT_PATH+"/"+ startDate+" to "+endDate+"-rebook_cancel_NOT_NULL.csv");
			String sql = mizeQuery.getObject().getProperty("mize.query.B");
			Object[] args = new Object[]{startDate, endDate};
			int[] argTypes = new int[]{Types.NVARCHAR,Types.NVARCHAR};
			cmsJdbcTemplate.query(sql, args, argTypes, (ResultSet rs)->{
				try {
					ReportGenerator.generate(rs, reportDelimeter, (String[] fields)->offersNotNull.add(fields[OFFER_NUMBER_IDX]));
				} catch (final Exception e) {
					log.error("Error while generating Mize.reportB: {}", e.getMessage(), e);
				}
			});
			ReportGenerator.flush();
			log.debug("Returning Mize.reportB for period from {} to {}", startDate, endDate);
		} catch (final Exception e) {
			log.error("Error while generating Mize.reportB: {}", e.getMessage(), e);
		}
	}

	public void reportC(ExecutorReport report, String startDate, String endDate, ReportLogLevel logLevel, ReportDelimeter reportDelimeter, Set<String> offersNotY) {
		try {
			log.info("Accepted Mize.reportC for period from {} to {}", startDate, endDate);
			ReportGenerator ReportGenerator = new ReportGenerator(MIZE_REPORT_PATH+"/"+ startDate+" to "+endDate+"-rebook_cancel_NOT_Y.csv");
			String sql = mizeQuery.getObject().getProperty("mize.query.C");
			Object[] args = new Object[]{startDate, endDate};
			int[] argTypes = new int[]{Types.NVARCHAR,Types.NVARCHAR};
			cmsJdbcTemplate.query(sql, args, argTypes, (ResultSet rs)->{
				try {
					ReportGenerator.generate(rs, reportDelimeter, (String[] fields)->offersNotY.add(fields[OFFER_NUMBER_IDX]));
				} catch (final Exception e) {
					log.error("Error while generating Mize.reportC: {}", e.getMessage(), e);
				}
			});
			ReportGenerator.flush();
			log.debug("Returning Mize.reportC for period from {} to {}", startDate, endDate);
		} catch (final Exception e) {
			log.error("Error while generating Mize.reportC: {}", e.getMessage(), e);
		}
	}

	public void reportD(ExecutorReport report,  String startDate, String endDate, ReportLogLevel logLevel, ReportDelimeter reportDelimeter) {
		try {
			log.info("Accepted Mize.reportD");
			ReportGenerator ReportGenerator = new ReportGenerator(MIZE_REPORT_PATH+"/"+ startDate+" to "+endDate+"-rev_share_amount_ALL.csv");
			String sql = mizeQuery.getObject().getProperty("mize.query.D");
			acctJdbcTemplate.query(sql, (ResultSet rs)->{
				try {
					ReportGenerator.generate(rs, reportDelimeter, (String[] fields)->true);
				} catch (final Exception e) {
					log.error("Error while generating Mize.reportD: {}", e.getMessage(), e);
				}
			});
			ReportGenerator.flush();
			log.debug("Returning Mize.reportD");
		} catch (final Exception e) {
			log.error("Error while generating Mize.reportD: {}", e.getMessage(), e);
		}

	}

	public void reportE(ExecutorReport report, String startDate, String endDate, ReportLogLevel logLevel, ReportDelimeter reportDelimeter, Set<String>[] whereOffers, String[] reportName) {
		try {
			log.info("Accepted Mize.reportE."+reportName);
			ReportGenerator[] ReportGenerator = new ReportGenerator[reportName.length];
			for(int i=0, max=reportName.length; i<max; ++i) {
				ReportGenerator[i] = new ReportGenerator(MIZE_REPORT_PATH + "/"+ startDate+" to "+endDate+"-rev_share_amount_" + reportName[i] + ".csv");
			}
			String sql = mizeQuery.getObject().getProperty("mize.query.D");
			acctJdbcTemplate.query(sql, (ResultSet rs)->{
				for(int i=0, max=reportName.length; i<max; ++i) {
					try {
						Set<String> whereSet = whereOffers[i];
						ReportGenerator[i].generate(rs, reportDelimeter, (String[] fields)->whereSet.contains(fields[OFFER_NUMBER_IDX]));
					} catch (final Exception e) {
						log.error("Error while generating Mize.reportE."+reportName[i]+": {}", e.getMessage(), e);
					}
				}
			});
			for(int i=0, max=reportName.length; i<max; ++i) {
				ReportGenerator[i].flush();
			}
			log.debug("Returning Mize.reportE."+reportName);
		} catch (final Exception e) {
			log.error("Error while generating Mize.reportE."+reportName+": {}", e.getMessage(), e);
		}

	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);

	public String pickStartDateOfTheMonth(String startDate, String endDate) throws ParseException {
		if( startDate == null && endDate == null ) {
			// pick up the first date of previous month
			LocalDate now = LocalDate.now();
			LocalDate firstOfPrevtMonth = now
					.withMonth(now.getMonthValue() - 1)
					.withDayOfMonth(1);
			return firstOfPrevtMonth.format(formatter);
		} else if( startDate != null ) {
			// check the format must be yyyy-MM-dd
			LocalDate date = LocalDate.parse(startDate, formatter);
			String str = date.format(formatter);
			if( !str.equals(startDate) ){
				throw new ParseException("startDate = "+startDate, OFFER_NUMBER_IDX);
			} else {
				return str;
			}
		} else { // endDate is always not null
			// check the format must be yyyy-MM-dd and set startDate to the first day of endDate month
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			String str = localDate.format(formatter);
			if( !str.equals(endDate) ){
				throw new ParseException("endDate = "+endDate, OFFER_NUMBER_IDX);
			} else {
				LocalDate firstOfEndDateMonth = localDate
						.withDayOfMonth(1);
				return firstOfEndDateMonth.format(formatter);
			}
		}
	}

	public String pickEndDateOfTheMonth(String startDate, String endDate, String startDate1) throws ParseException {
		if( startDate == null && endDate == null ) {
			// pick up the first date of the month next from startDate1
		} else if( endDate != null ){
			// check the format must be yyyy-MM-dd, set next day and check if end date is late then start date
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			String str = localDate.format(formatter);
			if( !str.equals(endDate) ){
				throw new ParseException("endDate = "+endDate, OFFER_NUMBER_IDX);
			} else {
				LocalDate nextDate = localDate
						.plusDays(1);
				if( !nextDate.isAfter(LocalDate.parse(startDate1, formatter)) ){
					throw new ParseException("Not valid date range - endDate must be same or after startDate!", OFFER_NUMBER_IDX);
				}
				return nextDate.format(formatter);
			}
		} else { // startDate is always not null
			// pick up the first date of the month next from startDate1
		}
		LocalDate localDate = LocalDate.parse(startDate1, formatter);
		LocalDate firstOfNextStartDateMonth = localDate
				.withMonth(localDate.getMonthValue() + 1)
				.withDayOfMonth(1);
		return firstOfNextStartDateMonth.format(formatter);
	}
}
