package com.interviewprep.blindcs.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository testRepository;

    @Test
    void Should_ReturnOneAccount_When_UsernameInDB() {
        String testUsername = "test";
        Account testAccount = new Account(1L, testUsername, "test");
        testRepository.save(testAccount);

        Optional<Account> actual = testRepository.getAccountByUsername(testUsername);

        assertTrue(actual.get().equals(testAccount));
    }

    @Test
    void Should_ReturnNoAccount_When_UsernameNotInDB() {
        String testUsername = "test";
        Account testAccount = new Account(1L, testUsername, "test");
        testRepository.save(testAccount);

        String wrongTestUsername = "notTest";
        Optional<Account> actual = testRepository.getAccountByUsername(wrongTestUsername);

        assertFalse(actual.isPresent());
    }

}