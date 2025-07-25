package com.projetoTeorico.api.repository;

import com.projetoTeorico.api.entity.Account;
import com.projetoTeorico.api.entity.AccountStockID;
import com.projetoTeorico.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {



}
