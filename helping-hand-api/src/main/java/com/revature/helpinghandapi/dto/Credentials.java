package com.revature.helpinghandapi.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class Credentials {

    private String first;
    private String last;
    private String username;
    private String password;

}
