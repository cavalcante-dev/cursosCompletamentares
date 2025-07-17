package com.projetoTeorico.api.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    private UUID accountId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    @PrimaryKeyJoinColumn
    private BillingAddress billingAddress;

    @OneToMany(mappedBy = "account")
    private List<AccountStock> accountStocks;

    public Account(UUID accountId, String description, User user, BillingAddress billingAddress, List<AccountStock> accountStocks) {
        this.accountId = accountId;
        this.description = description;
        this.user = user;
        this.billingAddress = billingAddress;
        this.accountStocks = accountStocks;
    }

    public Account() {
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
