package com.company.usertask.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponseDTO {

    Long accountId;
    String username;
    String password;
    String email;
    String accountNumber;
    BigDecimal money = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "AccountResponseDTO{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", money=" + money +
                '}';
    }
}
