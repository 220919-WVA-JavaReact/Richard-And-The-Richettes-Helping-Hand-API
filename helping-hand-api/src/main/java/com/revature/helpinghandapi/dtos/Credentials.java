package com.revature.helpinghandapi.dtos;
import lombok.Data;

import java.io.Serializable;

@Data
public class Credentials{

    private String first;
    private String last;
    private String username;
    private String password;

}
