package com.mkyong;

import com.mkyong.error.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginAuthenticationController {

    @Autowired
    private UserRepository repository;

    // Find
    @GetMapping("/users")
    List<Users> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    Users newUser(@Valid @RequestBody Users newUsers) {
        return repository.save(newUsers);
    }


    @PostMapping("/api/authenticate")
   // @ResponseStatus(HttpStatus.CREATED)
    String authenticate(@RequestBody Users newUsers) {
        System.out.println("Inside authenticate @@@@@@@@@@");
        String status = "{\"response\": \"failed\"}";
        Users dbUsers = repository.findUserByStatusAndName("A", newUsers.getName());
        if(null != dbUsers){
            status = "{\"response\": \"success\"}";
        }
        return status;
    }

    // Find
    @GetMapping("/user/{id}")
    Users findOne(@PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    /*// Save or update
    @PutMapping("/users/{user}")
    User saveOrUpdate(@RequestBody User newUser, @PathVariable String user) {

        return repository.fi(user)
                .map(x -> {
                    x.setName(newUser.getName());
                    x.setAuthor(newUser.getAuthor());
                    x.setPrice(newUser.getPrice());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    // update author only
    @PatchMapping("/books/{id}")
    User patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String author = update.get("author");
                    if (!StringUtils.isEmpty(author)) {
                        x.setAuthor(author);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new BookUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new BookNotFoundException(id);
                });

    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
*/

}
