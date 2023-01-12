package com.dbpostgresql.postgresql.controller;

import com.dbpostgresql.postgresql.exceptions.UserExceptions;
import com.dbpostgresql.postgresql.model.UserDto;
import com.dbpostgresql.postgresql.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userRepository.save(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        Optional<UserDto> optionalUserDto = userRepository.findById(id);
        if (optionalUserDto.isPresent()) {
            return optionalUserDto.get();
        } else throw new UserExceptions();
    }



}
