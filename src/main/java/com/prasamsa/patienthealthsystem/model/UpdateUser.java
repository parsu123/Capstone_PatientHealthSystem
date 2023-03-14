
package com.prasamsa.patienthealthsystem.model;

        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import lombok.ToString;
        import org.springframework.format.annotation.DateTimeFormat;

        import javax.persistence.*;
        import java.util.Date;


@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UpdateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;

}
