package codility;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CodilityController {

	/*
	 *  http://localhost:8080/healthcheck?format=short
	 *  http://localhost:8080/healthcheck?format=full
	 */
	
    @GetMapping(value="/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public String healthcheck(HttpServletRequest request, @RequestParam(name = "format") String format) {
    	String curentDateTime = ZonedDateTime.now(ZoneOffset.UTC ).format(DateTimeFormatter.ISO_INSTANT );
    	switch(format) {
    	case "short":
    		return "{\"status\": \"OK\"}";
    	case "full":
    		return "{\"currentTime\": \""+curentDateTime+"\", \"application\": \"OK\"}";
    	}
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Format"); // 404 Bad Format
    }
}
