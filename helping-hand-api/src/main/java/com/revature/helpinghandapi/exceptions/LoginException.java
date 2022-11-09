package com.revature.helpinghandapi.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "Request not found.")
public class LoginException extends RuntimeException{
}
