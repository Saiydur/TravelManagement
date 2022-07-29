package com.travelmanagement.model.transaction;

import com.travelmanagement.model.travelpackage.TravelPackageModel;
import com.travelmanagement.model.user.UsersModel;

import javax.persistence.*;

@Entity
@Table(name = "transaction_history_traveller")
public class TransactionTravellerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "purchase_date")
    private String purchaseDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "travel_package_id")
    private TravelPackageModel travelPackage;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private UsersModel user;

    @Column(name = "is_cancel")
    private boolean isCancel=false;

    @Column(name = "is_paid")
    private boolean isPaid=false;

    public TransactionTravellerModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public TravelPackageModel getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackageModel travelPackage) {
        this.travelPackage = travelPackage;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
