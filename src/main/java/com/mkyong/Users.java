package com.mkyong;

import com.mkyong.error.validator.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please provide a user name")
    private String name;

    @NotEmpty(message = "Please provide a password")
    private String password;

    @NotEmpty(message="Status is active")
    private String status;

    // avoid this "No default constructor for entity"
    public Users() {
    }

    public Users(Long id, String name, String password, String status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public Users(String name, String password, String status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setStatus(String status){ this.status = status; }

    public String getStatus() { return this.status; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password +
                '}';
    }
}
