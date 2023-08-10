package com.company.usertask.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponseDTO {

    Long accountId;
    String username;
    String password;
    String email;
    String accountNumber;
    Double money = 0.0;

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
