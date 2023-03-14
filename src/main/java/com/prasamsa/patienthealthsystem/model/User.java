package com.prasamsa.patienthealthsystem.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String firstName;
    private String lastName;
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    //@Temporal(TemporalType.DATE)
    private Date dob;
    private String password;

    private String role;

   /* public User(String firstName, String lastName, String email, Date dob, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.password = password;

    }*/






}
