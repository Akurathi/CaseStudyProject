package com.example.salesorderservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

//@Entity(name = "Customer")
//@Table(name = "customer")
@Data
public class Customer {

    private Long id;

    private String firstName;
    private String lastName;

    private String email;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    // only include id field when generating equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer {");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static final class CustomerBuilder {
        private Customer customer;

        private CustomerBuilder() {
            customer = new Customer();
        }

        public CustomerBuilder withId(Long id) {
            customer.setId(id);
            return this;
        }

        public CustomerBuilder withFirstName(String firstName) {
            customer.setFirstName(firstName);
            return this;
        }

        public CustomerBuilder withLastName(String lastName) {
            customer.setLastName(lastName);
            return this;
        }

        public CustomerBuilder withEmail(String Email) {
            customer.setEmail(Email);
            return this;
        }

//        public PetBuilder withOwner(Owner owner) {
//            pet.addOwner(owner);
//            owner.getPets().add(pet);
//            return this;
//        }
//
//        public PetBuilder withVisit(Visit visit) {
//            pet.addVisit(visit);
//            visit.addPet(pet);
//            return this;
//        }

        public Customer build() {
            return customer;
        }
    }
}
