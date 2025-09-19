package task.management.codility;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class TaskManagementController {

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
		private String message;
		private Integer status;
		private Integer priority;
	}

	@Data
	@AllArgsConstructor
	@Builder
	@NoArgsConstructor
	@Entity
	@Table(appliesTo = "TASKS")
	public class Task {
		@Id
		@GeneratedValue
		private Long id;

		private String description;
		private Integer priority;
	}

	static Map<Long, Task> db = new HashMap<>();
	static {
		db.put(Long.valueOf(1), Task.builder().id(1L).priority(1).build());
		db.put(Long.valueOf(5), Task.builder().id(5L).description("task's description").priority(5).build());
	}

	@Service
	public class TaskRepository1 {
		public Optional<Task> findById(Long id) {
			return db.containsKey(id)? Optional.of(db.get(id)): Optional.empty();
		}
	}

	@Autowired
	TaskRepository1 taskRepository1;

	@Autowired
	TaskRepository2 taskRepository2;

	/*
	http://localhost:8080/task?id=10
	 */
	@PutMapping(value = "/task/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {

		Optional<Task> task = taskRepository2.findById(id);

		if( task.isPresent() ){
			if( task.get().description == null ){
				return new ResponseEntity(TaskResponse.builder()
						.message("Task description is required")
						.status(400).build(), HttpStatus.BAD_REQUEST);
			} else {
				return ResponseEntity.ok(TaskResponse.builder()
						.message(task.get().description)
						.priority(task.get().priority).build());
			}
		} else {
			return new ResponseEntity(TaskResponse.builder()
					.message("Cannot find task with given id")
					.status(404).build(), HttpStatus.NOT_FOUND);
		}
	}

}
