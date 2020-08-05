package kg.attractor.demo.service;

import kg.attractor.demo.dto.TaskDTO;
import kg.attractor.demo.form.TaskForm;
import kg.attractor.demo.model.Task;
import kg.attractor.demo.repo.TaskRepo;
import kg.attractor.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepo taskRepo;
    private final UserRepo userRepo;

    public void addTask(TaskForm taskForm, Principal principal){

        taskRepo.save(Task.builder()
        .title(taskForm.getTitle())
        .description(taskForm.getDescription())
        .dateTime(taskForm.getDateTime())
        .user(userRepo.findByEmail(principal.getName()))
        .build());
    }

    public Page<TaskDTO> getAllByUser(Pageable pageable, Principal principal){
        return taskRepo.getAllByUserEmail(pageable, principal.getName()).map(TaskDTO::from);
    }

    public TaskDTO getTaskById(Long id){
        return TaskDTO.from(taskRepo.findById(id).get());
    }

    public void editTaskById(Long id, TaskForm taskForm){
        Task task = taskRepo.findById(id).get();

        task.setTitle(taskForm.getTitle());
        task.setDescription(taskForm.getDescription());
        task.setDateTime(taskForm.getDateTime());

        taskRepo.save(task);
    }

    public void changeTaskState(Long id){
        Task task = taskRepo.findById(id).get();
        task.setState(task.getState().changeState());
        taskRepo.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepo.deleteById(id);
    }
}
