package com.dbpostgresql.postgresql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,  reason = "user not found")
public class UserExceptions extends RuntimeException{
}
