package server.config;

import com.pglc1026.springboot3.demo.common.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Will Liu
 * @since 2023/1/4
 */
@HttpExchange(url = "/user", accept = "application/json", contentType = "application/json")
public interface UserClient {

    @GetExchange("/")
    Flux<User> getAll();

    @GetExchange("/{id}")
    Mono<User> getById(@PathVariable("id") Long id);

    @PostExchange("/")
    Mono<User> save(@RequestBody User user);

    @PutExchange("/{id}")
    Mono<User> update(@PathVariable Long id, @RequestBody User user);

    @DeleteExchange("/{id}")
    Mono<User> delete(@PathVariable Long id);

}
