package codility;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Setter
	@Getter
	@NoArgsConstructor
	@Jacksonized
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TaskRequest {
		private String description;
		private Integer priority;
	}


	@Value
	@Builder
	@Jacksonized
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class TaskResponse {
		private String description;
		private Integer priority;
	}


	/*
	http://localhost:8080/task?id=10
	 */
	@PutMapping(value = "/task/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
		TaskResponse taskResponse = TaskResponse.builder()
				.description(taskRequest.getDescription())
				.priority(taskRequest.getPriority()).build();
		return ResponseEntity.ok(taskResponse);
	}

}
