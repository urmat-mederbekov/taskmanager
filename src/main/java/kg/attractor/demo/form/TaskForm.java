package kg.attractor.demo.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class TaskForm {

    @NotBlank(message = "Обязательное поле")
    private String title;

    @NotBlank(message = "Обязательное поле")
    private String description;

    @Future(message = "Невозможно создать событие с прошедшой датой")
//    @DateTimeFormat( pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Обязательное поле")
    private LocalDateTime dateTime = null;
}
