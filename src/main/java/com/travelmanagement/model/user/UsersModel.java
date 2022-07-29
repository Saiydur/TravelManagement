package com.travelmanagement.model.user;

import com.travelmanagement.model.transaction.TransactionTravellerModel;
import com.travelmanagement.model.travelpackage.TravelPackageModel;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @NotNull(message = "username required")
    private String username;

    @Column(name = "password")
    @NotNull(message = "password required")
    private String password;

    @Column(name = "enable")
    private boolean enable=true;

    @Column(name = "role")
    @NotNull(message = "role required")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    @Valid
    private UsersDetailsModel usersDetailsModel;

    @OneToMany(mappedBy = "usersModel", cascade = CascadeType.ALL)
    private List<TravelPackageModel> travelPackageModels;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TransactionTravellerModel> transactionTravellerModels;

    public UsersModel() {
    }

    public UsersModel(String username, String password, boolean enable, UsersDetailsModel usersDetailsModel) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.usersDetailsModel = usersDetailsModel;
    }

    public UsersModel(int id, String username, String password, boolean enable, UsersDetailsModel usersDetailsModel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.usersDetailsModel = usersDetailsModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public UsersDetailsModel getUsersDetailsModel() {
        return usersDetailsModel;
    }

    public void setUsersDetailsModel(UsersDetailsModel usersDetailsModel) {
        this.usersDetailsModel = usersDetailsModel;
    }

    public boolean isEnable() {
        return enable;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TravelPackageModel> getTravelPackageModels() {
        return travelPackageModels;
    }

    public void setTravelPackageModels(List<TravelPackageModel> travelPackageModels) {
        this.travelPackageModels = travelPackageModels;
    }

    public void add(TravelPackageModel tempTravelPackageModel){
        if (travelPackageModels==null){
            travelPackageModels = new ArrayList<>();
        }
        travelPackageModels.add(tempTravelPackageModel);

        tempTravelPackageModel.setUsersModel(this);
    }

    public List<TransactionTravellerModel> getTransactionTravellerModels() {
        return transactionTravellerModels;
    }

    public void add(TransactionTravellerModel tempTransactionTravellerModel){
        if (transactionTravellerModels==null){
            transactionTravellerModels = new ArrayList<>();
        }
        transactionTravellerModels.add(tempTransactionTravellerModel);

        tempTransactionTravellerModel.setUser(this);
    }
}
