package com.projetoTeorico.api.services;

import com.projetoTeorico.api.controller.DTO.CreatUserDTO;
import com.projetoTeorico.api.controller.DTO.CreateAccountDTO;
import com.projetoTeorico.api.controller.DTO.UpdateUserDTO;
import com.projetoTeorico.api.entity.Account;
import com.projetoTeorico.api.entity.BillingAddress;
import com.projetoTeorico.api.entity.User;
import com.projetoTeorico.api.repository.AccountRepository;
import com.projetoTeorico.api.repository.BillingAddressRepository;
import com.projetoTeorico.api.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository, AccountRepository accountRepository, BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UUID creatUser(CreatUserDTO creatUserDTO) {
        // DTO -> Entity
        var entity = new User(
                UUID.randomUUID(),
                creatUserDTO.userName(),
                creatUserDTO.email(),
                creatUserDTO.password(),
                Instant.now(),
                null);
        var userSaved = userRepository.save(entity);
        return userSaved.getUserID();
    }

    public Optional<User> getUserByID(String userId) {
        var user = userRepository.findById(UUID.fromString(userId));
        return user;
    }

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);
        var userExists = userRepository.existsById(id);
        if (userExists) {
            userRepository.deleteById(id);
        }
    }

    public void updateUserById(String userId,
                               UpdateUserDTO updateUserDTO) {
        var id = UUID.fromString(userId);
        var userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            var user = userEntity.get();
            if (updateUserDTO.userName() != null) {
                user.setUserName(updateUserDTO.userName());
            }
            if (updateUserDTO.password() != null) {
                user.setPassword(updateUserDTO.password());
            }
            userRepository.save(user);
        }
    }

    public void creatAccount(String userId, CreateAccountDTO createAccountDTO) {

        var user = userRepository.findById(UUID.fromString(userId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var account = new Account(
                UUID.randomUUID(),
                createAccountDTO.description(),
                user,
                null,
                new ArrayList<>()
        );

        var accountCreated = accountRepository.save(account);

        var billingAdress = new BillingAddress(
                accountCreated.getAccountId(),
                createAccountDTO.street(),
                createAccountDTO.number(),
                account
        );

        billingAddressRepository.save(billingAdress);

    }

}
