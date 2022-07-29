package com.travelmanagement.model.travelpackage;

import com.travelmanagement.model.transaction.TransactionTravellerModel;
import com.travelmanagement.model.user.UsersModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "travel_packages")
public class TravelPackageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull(message = "package name is required")
    private String packageName;

    @Column(name = "description")
    @NotNull(message = "package description is required")
    private String description;

    @Column(name = "price")
    @NotNull(message = "package price is required")
    private Double price;

    @Column(name = "start_date")
    @NotNull(message = "package start date is required")
    private String startDate;

    @Column(name = "end_date")
    @NotNull(message = "package end date is required")
    private String endDate;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UsersModel usersModel;

    @OneToMany(mappedBy = "travelPackage", cascade = CascadeType.REFRESH)
    private List<TransactionTravellerModel> transactionTravellerModelList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public UsersModel getUsersModel() {
        return usersModel;
    }

    public void setUsersModel(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public List<TransactionTravellerModel> getTransactionTravellerModelList() {
        return transactionTravellerModelList;
    }

    public void setTransactionTravellerModelList(List<TransactionTravellerModel> transactionTravellerModelList) {
        this.transactionTravellerModelList = transactionTravellerModelList;
    }
}
