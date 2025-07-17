package com.projetoTeorico.api.services;

import com.projetoTeorico.api.controller.DTO.CreatUserDTO;
import com.projetoTeorico.api.entity.User;
import com.projetoTeorico.api.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Captor
    private ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Nested
    // Concluded
    class creatUser {

        @Test
        @DisplayName("Should sucesseful create a new user")
        void shouldCreateUser() {

            // Arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@gmail.com",
                    "12345",
                    Instant.now(),
                    null
            );
            doReturn(user).when(userRepository).save(userArgumentCaptor.capture());
            var input = new CreatUserDTO(
                    "username",
                    "email@email.com",
                    "12345");

            // Act
            var output = userService.creatUser(input);

            // Assert
            assertNotNull(output);

            var userCaptured = userArgumentCaptor.getValue();
            assertEquals(input.userName(), userCaptured.getUserName());
            assertEquals(input.email(), userCaptured.getEmail());
            assertEquals(input.password(), userCaptured.getPassword());

        }

        @Test
        @DisplayName("Should throw exception when erro occurs")
        void shouldThrowExceptionWhenErro() {

            // Arrange
            doThrow(new RuntimeException()).when(userRepository).save(any());
            var input = new CreatUserDTO(
                    "username",
                    "email@email.com",
                    "12345");

            // Act & Assert
            assertThrows(RuntimeException.class, () -> userService.creatUser(input));

        }

    }

    @Nested
    // Concluded
    class getUserById {

        @Test
        @DisplayName("Should get the user by its ID when optional is present")
        void shouldGetUserByIDWhenOptionalIsPresent() {

            //Arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@gmail.com",
                    "12345",
                    Instant.now(),
                    null
            );
            doReturn(Optional.of(user)).when(userRepository).findById(uuidArgumentCaptor.capture());
            //Act
            var output = userService.getUserByID(user.getUserID().toString());

            //Assert
            assertTrue(output.isPresent());
            assertEquals(user.getUserID(), uuidArgumentCaptor.getValue());

        }
        @Test
        @DisplayName("Should get the user by its ID when optional is empty")
        void shouldGetUserByIDWhenOptionalIsEmpty() {

            //Arrange
            var user = new User(
                    UUID.randomUUID(),
                    "username",
                    "email@gmail.com",
                    "12345",
                    Instant.now(),
                    null
            );
            doReturn(Optional.empty()).when(userRepository).findById(uuidArgumentCaptor.capture());

            //Act
            var output = userService.getUserByID(user.getUserID().toString());

            //Assert
            assertTrue(output.isEmpty());
            assertEquals(user.getUserID(), uuidArgumentCaptor.getValue());

        }

    }

}