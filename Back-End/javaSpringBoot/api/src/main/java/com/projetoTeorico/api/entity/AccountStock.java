package com.projetoTeorico.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_account_stocks")
public class AccountStock {

    @EmbeddedId
    private AccountStockID id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    private Account account;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_Id")
    private Stock stock;

    @Column(name = "quantity")
    private Integer quantity;

    public AccountStock() {
    }

    public AccountStock(AccountStockID id, Account account, Stock stock, Integer quantity) {
        this.id = id;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
    }

    public AccountStockID getId() {
        return id;
    }

    public void setId(AccountStockID id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
