package com.geekster.User.management.System.models;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UMS {
    @NotBlank(message = "user id cant be null")
    private String userId;
    @NotEmpty(message = "user name cant be empty")
    private String userName;
    @Email(message = "please provide valid mail")
    @NotEmpty(message = "mail cant be empty")
    private String email;
    @Size(min = 10 , max = 12 , message = "phone no should be range in 10 to 12 digits")
    @Pattern(regexp = "^[0-9]+$", message = "phone no should be in digits")
    private String phone_Number;
    private LocalDate date;
    private LocalTime time;
    @Pattern(regexp= "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "dob should be correct YYYY-MM-DD")
    private String dob;

}
