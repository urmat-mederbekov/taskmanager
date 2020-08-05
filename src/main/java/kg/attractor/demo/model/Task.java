package kg.attractor.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime dateTime;

    @Column
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private State state = State.NOT_COMPLETED;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}
