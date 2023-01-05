package com.pglc1026.springboot3.demo.server.controller;

import com.google.common.collect.Lists;
import com.pglc1026.springboot3.demo.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Will Liu
 * @since 2023/1/4
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(Lists.newArrayList(User.builder().id(1L).age(18).name("小明").build(),
                User.builder().id(2L).age(18).name("李雷").build()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId) {
        return ResponseEntity.ok(User.builder().id(userId).age(18).name("小明").build());
    }

    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("User: {}", user);
        return ResponseEntity.ok(user.toBuilder().id(9999L).name("success").build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable Long userId) {
        return ResponseEntity.ok(User.builder().id(userId).age(18).name("小明").build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody User user) {
        log.info("userId: {}", userId);
        log.info("User: {}", user);
        return ResponseEntity.ok(user.toBuilder().name(user.getName() + userId).build());
    }

}
