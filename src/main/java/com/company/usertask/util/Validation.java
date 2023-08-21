package com.company.usertask.util;

import com.company.usertask.domain.Account;
import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.exception.WrongFieldException;

public class Validation {

    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$*%^&+=])(?=\\S+$).{8,20}$";
    private static final String USERNAME_REGEX = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z\\d._]+(?<![_.])$";
    private static final String EMAIL_REGEX = "(?:[a-z\\d!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z\\d!#$%&'*+/=?^_`{|}~-]+)*|\"(?:" +
            "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])" +
            "*\")@(?:(?:[a-z\\d](?:[a-z\\d-]*[a-z\\d])?\\.)+[a-z\\d](?:[a-z\\d-]*[a-z\\d])?|\\[(?:(2(5[0-5]|[0-" +
            "4]\\d)|1\\d\\d|[1-9]?\\d)\\.){3}(?:(2(5[0-5]|[0-4]\\d)|1\\d\\d|[1-9]?\\d)|" +
            "[a-z\\d-]*[a-z\\d]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b" +
            "\\x0c\\x0e-\\x7f])+)])";

    private static final String ACCOUNT_NUMBER_REGEX = "\\d{8,}$";

    public static void validateAccountRequest(Account request) {
        validateUsername(request.getUsername());

        validateEmail(request.getEmail());

        validatePassword(request.getPassword());


    }

    public static void validateUserRequest(UserRequestDTO userRequestDTO){
        isShort(userRequestDTO.getFirstName(),3);
        isShort(userRequestDTO.getLastName(),6);
    }

    public static void validateAccountNumber(String accountNumber){
        isNull(accountNumber);
        if(!accountNumber.matches(ACCOUNT_NUMBER_REGEX)){
            throw new WrongFieldException("Account number length should not be shorter than 8 and only digits.");
        }
    }

    public static void validatePassword(String password) {
        isNull(password);
        if (!password.matches(PASSWORD_REGEX)) {
            throw new WrongFieldException("Password:\nIt contains at least 8 characters and at most 20 characters.\n"
                    .concat("It contains at least one digit.\n")
                    .concat("It contains at least one upper case alphabet.\n")
                    .concat("It contains at least one lower case alphabet.\n")
                    .concat("It contains at least one special character which includes !@#$%&*()-+=^.\n")
                    .concat("It doesn't contain any white space."));
        }
    }

    private static void validateUsername(String username) {
        isNull(username);
        if (!username.matches(USERNAME_REGEX)) {
            throw new WrongFieldException("Username:\nIt contains at least 8 characters and at most 20 characters.\n"
                    .concat("It contains at least one digit.\n")
                    .concat("It doesn't contain any white space.\n")
                    .concat("no _ or . at the beginning\n")
                    .concat("no _ or . at the end\n")
                    .concat("no __ or _. or ._ or .. inside"));
        }
    }

    private static void validateEmail(String email) {
        isNull(email);
        if (!email.matches(EMAIL_REGEX)) {
            throw new WrongFieldException("Wrong email!");
        }
    }

    public static void isShort(String data,int length){
        isNull(data);
        if(data.length() < length){
            throw new WrongFieldException
                    (String.format("data length should not be shorter than %d.Your data length is %d",
                            length,data.length()));
        }
    }

    public static <T> void isNull(T data){
        if(data == null){
            throw new WrongFieldException("Field can't null!");
        }
    }
}
