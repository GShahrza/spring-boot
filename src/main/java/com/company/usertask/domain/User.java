package com.company.usertask.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "first_name",length = 25,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 30,nullable = false)
    private String lastName;

    @CreationTimestamp
    @Column(name = "user_created_at",columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime userCreatedAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "user_updated_at",columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime userUpdatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Account> accounts;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + userCreatedAt +
                ", updatedAt=" + userUpdatedAt +
                ", accounts=" + accounts +
                '}';
    }
}
