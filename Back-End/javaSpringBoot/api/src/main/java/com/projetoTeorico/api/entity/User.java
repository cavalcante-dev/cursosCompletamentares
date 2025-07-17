package com.projetoTeorico.api.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private UUID userID;

    @Column(name = "tb_username")
    private String userName;
    @Column(name = "tb_email")
    private String email;
    @Column(name = "tb_password")
    private String password;

    @CreationTimestamp
    private Instant creationTimeStamp;
    @UpdateTimestamp
    private Instant updateTimeStamp;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public User() {
    }

    public User(UUID userID, String userName, String email, String password, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
