package java7;

import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimestampParsing {

	@Test
	public void test() throws ParseException {
		assertTrue(new SimpleDateFormat("HH:mm:ss").parse("13:52:00").getTime() == 67920000L);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		assertTrue(sdf.format(new Date(135200000L)).equals("13:33:20:000"));
		
		assertTrue(new SimpleDateFormat("HH:mm:ss:SSS").format(new Date(135200000L)).equals("08:33:20:000"));

		assertTrue(new SimpleDateFormat("HH:mm:ss").format(135200000L).equals("08:33:20"));

		String PATClientRequestTime = "135200000";
		assertTrue(new Time(Long.parseLong(PATClientRequestTime)).toString().equals("08:33:20"));
		
		assertTrue(new Time(new SimpleDateFormat("HHmmssSSS").parse(PATClientRequestTime).getTime()).toString().equals("13:52:00"));
	}
		
}
