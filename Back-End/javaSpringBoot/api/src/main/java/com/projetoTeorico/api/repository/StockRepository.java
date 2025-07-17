package com.projetoTeorico.api.repository;

import com.projetoTeorico.api.entity.Stock;
import com.projetoTeorico.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {



}
