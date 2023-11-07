package com.kaiser.usermicroservices.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends Person{

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

}
