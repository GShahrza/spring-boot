package com.company.usertask.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "username",length = 15,nullable = false,unique = true)
    private String username;

    @Column(name = "password",length = 20,nullable = false)
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "account_number",length = 16,nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "money",columnDefinition = "float default 0")
    private BigDecimal money = BigDecimal.ZERO;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "account_created_at",columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime accountCreatedAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "account_updated_at",columnDefinition = "timestamp default now()", nullable = false)
    private LocalDateTime accountUpdatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", money=" + money +
                ", isActive=" + isActive +
                ", createdAt=" + accountCreatedAt +
                ", updatedAt=" + accountUpdatedAt +
                '}';
    }
}
