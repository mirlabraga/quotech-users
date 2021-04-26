package com.quotech.quotechusers.controllers;

import com.quotech.quotechusers.exception.ResourceNotFoundException;
import com.quotech.quotechusers.models.User;
import com.quotech.quotechusers.models.UserId;
import com.quotech.quotechusers.models.dto.UserDto;
import com.quotech.quotechusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserDto bodyUser) {
        User user = UserDto.fromDto(bodyUser);
        userRepository.save(user);
        return new ResponseEntity("User created succcessfully", HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/client/{clientId}")
    public ResponseEntity<?> update(@PathVariable(value = "clientId") String clientId,
                                    @PathVariable(value = "userId") String userId,
                                    @RequestBody UserDto bodyUser) throws ResourceNotFoundException {

        User recoverUser = userRepository.findById(new UserId(clientId, userId))
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        recoverUser.setRole(bodyUser.getMetadata().getRole());
        recoverUser.setEmail(bodyUser.getMetadata().getEmail());
        recoverUser.setName(bodyUser.getMetadata().getName());
        userRepository.save(recoverUser);
        return new ResponseEntity("User updated succcessfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/client/{clientId}")
    public void delete(@PathVariable(value = "clientId") String clientId,
                       @PathVariable(value = "userId") String userId) throws ResourceNotFoundException  {
        User user = userRepository.findById(new UserId(clientId, userId))
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        userRepository.delete(user);
    }

    @GetMapping("/users/{userId}/client/{clientId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "clientId") String clientId,
                                               @PathVariable(value = "userId") String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(new UserId(clientId, userId))
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(UserDto.toDto(user));
    }

    @GetMapping("/users")
    public List<UserDto>  findAll() {
        Iterable<User> users = userRepository.findAll();
        List<UserDto> listUsers = new ArrayList<>();
        users.forEach(user -> listUsers.add(UserDto.toDto(user)));
        return listUsers;
    }
}
