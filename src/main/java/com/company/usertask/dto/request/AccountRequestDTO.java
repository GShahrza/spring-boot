package com.company.usertask.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRequestDTO {

    String username;
    String password;
    String email;
    String accountNumber;
    BigDecimal money = BigDecimal.ZERO;

}
