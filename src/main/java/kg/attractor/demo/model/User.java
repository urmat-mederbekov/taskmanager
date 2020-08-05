package kg.attractor.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @Column
    @Builder.Default
    private String role = "USER";
}
