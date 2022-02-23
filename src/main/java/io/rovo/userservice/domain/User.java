package io.rovo.userservice.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Column(unique=true)
    private String username;

    @NotNull
    private String password;
    @ManyToMany(fetch = EAGER)
    @NotNull

    private Collection<Role> roles = new ArrayList<>();
}
