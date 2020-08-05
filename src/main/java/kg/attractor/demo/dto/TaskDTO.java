package kg.attractor.demo.dto;

import kg.attractor.demo.model.State;
import kg.attractor.demo.model.Task;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private State state;
    private UserDTO user;

    public static TaskDTO from(Task task) {
        return builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dateTime(task.getDateTime())
                .state(task.getState())
                .user(UserDTO.from(task.getUser()))
                .build();
    }
}
