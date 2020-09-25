package codility;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class CodilityController {

	/*
	 * http://localhost:8080/healthcheck?format=short
	 * http://localhost:8080/healthcheck?format=full
	 * 
	 * fasterxml jackson 2.9.6
	 */

	@GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> healthcheck(HttpServletRequest request,
			@RequestParam(name = "format") String format) {
		String curentDateTime = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();

		switch (format) {
		case "short":
			rootNode.put("status", "OK");
			return ResponseEntity.ok(rootNode.toString());
		case "full":
			rootNode.put("currentTime", curentDateTime);
			rootNode.put("application", "OK");
			return ResponseEntity.ok(rootNode.toString());
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ""); // 400 Bad Format
	}

	@PutMapping(value = "/healthcheck")
	public void healthcheckPut() {
		throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "");
	}

	@PostMapping(value = "/healthcheck")
	public void healthcheckPost() {
		throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "");
	}

	@DeleteMapping(value = "/healthcheck")
	public void healthcheckDelete() {
		throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "");
	}
}
