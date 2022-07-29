package com.travelmanagement.model.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class UsersDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message = "first name required")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "last name required")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "email required")
    private String email;

    @Column(name = "phone_number")
    @NotNull(message = "phone number required")
    private String phoneNumber;

    @Column(name = "address")
    @NotNull(message = "address required")
    private String address;

    @OneToOne(mappedBy = "usersDetailsModel",cascade = CascadeType.ALL)
    private UsersModel usersModel;

    public UsersDetailsModel(int id, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UsersDetailsModel(String firstName, String lastName, String email, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UsersDetailsModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public UsersModel getUsersModel() {
        return usersModel;
    }

    public void setUsersModel(UsersModel usersModel) {
        this.usersModel = usersModel;
    }
}
