package com.example.customer.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

//    @Email
    private String email;
    //private PetType petType;

    // Lazy fetch is better for performance than eager
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_id")
//    private Owner owner;

//    @OneToMany(
//            mappedBy = "pet",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private List<Visit> visits = new ArrayList<>();

    protected Customer() {

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


//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public PetType getPetType() {
//        return petType;
//    }
//
//    public void setPetType(PetType petType) {
//        this.petType = petType;
//    }
//
//    // Update the relationship between Owner and Pet when adding an Owner
//    public void addOwner(Owner owner) {
//
//        addOwner(owner, true);
//    }
//
//    public void addOwner(Owner owner, Boolean updateRelationship) {
//
//        this.owner = owner;
//        if (updateRelationship) {
//            owner.addPet(this, false);
//        }
//    }
//
//    // Update the relationship between Owner and Pet when removing an Owner
//    public void removeOwner(Owner owner) {
//
//        removeOwner(owner, true);
//    }
//
//    public void removeOwner(Owner owner, Boolean updateRelationship) {
//
//        this.owner = null;
//        if (updateRelationship) {
//            owner.removePet(this, false);
//        }
//    }
//
//    // Update the relationship between Visit and Pet when adding a Visit
//    public void addVisit(Visit visit) {
//
//        addVisit(visit, true);
//    }
//
//    public void addVisit(Visit visit, Boolean updateRelationship) {
//
//        visits.add(visit);
//        if (updateRelationship) {
//            visit.addPet(this, false);
//        }
//    }
//
//    // Update the relationship between Visit and Pet when removing a Visit
//    public void removeVisit(Visit visit) {
//
//        removeVisit(visit, true);
//    }
//
//    public void removeVisit(Visit visit, Boolean updateRelationship) {
//
//        visits.remove(visit);
//        if (updateRelationship) {
//            visit.removePet(this, false);
//        }
//    }
//
//    public Owner getOwner() {
//        return owner;
//    }
//
//    public List<Visit> getVisits() {
//        return this.visits;
//    }

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
