package com.example.accessingdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // indicating that it is a JPA entity
// Because no @Table annotation exists, it is assumed that this entity is mapped to a table named Customer
public class Customer {

    @Id // so that JPA recognizes it as the object’s ID
    @GeneratedValue(strategy = GenerationType.AUTO) // to indicate that the ID should be generated automatically
    private Long id;
    private String firstName;
    private String lastName;

    //  Exists only for the sake of JPA. You do not use it directly, so it is designated as protected
    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
