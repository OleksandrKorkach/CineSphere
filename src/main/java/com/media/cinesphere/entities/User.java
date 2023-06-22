package com.media.cinesphere.entities;

import com.media.cinesphere.entities.enums.Status;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "was_created")
    private LocalDateTime wasCreated;

    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;

    // private ProfilePhoto;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "user")
    private List<WatchList> watchLists;

    @Override
    public String toString() {
        return "User{" +
                "id: " + getId() + ", " +
                "username: " + username + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public List<WatchList> getWatchLists() {
        return watchLists;
    }

    public void setWatchLists(List<WatchList> watchLists) {
        this.watchLists = watchLists;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getWasCreated() {
        return wasCreated;
    }

    public void setWasCreated(LocalDateTime wasCreated) {
        this.wasCreated = wasCreated;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
