package com.projetoTeorico.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class AccountStockID {

    @Column(name = "account_ID")
    private UUID accountId;

    @Column(name = "stock_Id")
    private String stockId;

    public AccountStockID(String stockId) {
        this.stockId = stockId;
    }

    public AccountStockID(UUID accountId, String stockId) {
        this.accountId = accountId;
        this.stockId = stockId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

}
