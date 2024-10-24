package com.learnspringboot.a1.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "[User]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName", columnDefinition = "NVARCHAR(255)")
    private String firstName;
    @Column(name = "lastName", columnDefinition = "NVARCHAR(255)")
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String password;
    @Column(name = "isEnabled")
    private boolean isEnabled = false;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "[userId]", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "[roleId]", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
//dfsdf
}
