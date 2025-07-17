package com.projetoTeorico.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    @Column(name = "stockId")
    private String stockId;

    @Column(name = "description")
    private String description;

}
