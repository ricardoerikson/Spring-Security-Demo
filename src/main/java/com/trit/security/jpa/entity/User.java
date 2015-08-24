package com.trit.security.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;

    protected User() {
    }

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, firstName='%s', lastName='%s', password='%s']", this.id, this.firstName,
                this.lastName, this.password);
    }

    public String getFirstName() {
        return this.firstName;
    }

}
