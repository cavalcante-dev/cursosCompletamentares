package com.projetoTeorico.api.controller;

import com.projetoTeorico.api.controller.DTO.CreatUserDTO;
import com.projetoTeorico.api.controller.DTO.CreateAccountDTO;
import com.projetoTeorico.api.controller.DTO.UpdateUserDTO;
import com.projetoTeorico.api.entity.User;
import com.projetoTeorico.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreatUserDTO creatUserDTO) {
        var userID = userService.creatUser(creatUserDTO);
        return ResponseEntity.created(URI.create("/v1/users/" + userID.toString())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserByID(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.listUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userID,
                                               @RequestBody UpdateUserDTO updateUserDTO) {
        userService.updateUserById(userID, updateUserDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<User> createAccount(@PathVariable("userId") String userId,
                                           @RequestBody CreateAccountDTO createAccountDTO) {
        userService.creatAccount(userId, createAccountDTO);
        return ResponseEntity.ok().build();
    }

}
