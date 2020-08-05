package kg.attractor.demo.repo;

import kg.attractor.demo.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

    Page<Task> getAllByUserEmail(Pageable pageable, String email);
}
