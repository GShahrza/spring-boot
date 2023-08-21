package com.company.usertask.dto.request;

import com.company.usertask.dto.response.AccountResponseDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDTO {

    String firstName;
    String lastName;
    Set<AccountRequestDTO> accounts;


}
