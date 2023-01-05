package server.controller;

import com.google.common.collect.Lists;
import com.pglc1026.springboot3.demo.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.config.UserClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Will Liu
 * @since 2023/1/4
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userClient.getAll().collectList().block());
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable Long userId) {
        return ResponseEntity.ok(userClient.getById(userId).block());
    }

    @GetMapping("/save")
    public ResponseEntity<User> save() {
        User user = User.builder().name("李梅").age(19).build();
        Mono<User> save = userClient.save(user);
        return ResponseEntity.ok(save.block());
    }

    @GetMapping("/delete/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable Long userId) {
        return ResponseEntity.ok(userClient.delete(userId).block());
    }

    @GetMapping("/update/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId) {
        return ResponseEntity.ok(userClient.update(userId, User.builder().id(1L).name("李梅").age(20).build()).block());
    }

}
