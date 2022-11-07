package com.revature.helpinghandapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Request not found.")
public class RequestNotFoundException extends RuntimeException{

}
