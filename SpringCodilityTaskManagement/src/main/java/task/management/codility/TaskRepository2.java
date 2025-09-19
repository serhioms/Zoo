package task.management.codility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository2 extends JpaRepository<TaskManagementController.Task, Long> {
    public Optional<TaskManagementController.Task> findById(Long id);
}