package com.interviewprep.blindcs.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository testRepository;
    private AccountService testService;
    Account existingAccount = new Account(0L, "0-test", "0-test");
    Account newAccount = new Account(1L, "test", "test");
    ArgumentCaptor<Account> existingAccountArgumentCaptor;

    @BeforeEach
    void setUp() {
        testService = new AccountService(testRepository);
        testService.addNewAccount(existingAccount);
        existingAccountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
    }


    // addNewAccount(Account account)
    @Test
    void Should_addNewAccount_When_AccountNotInDB() {
        verify(testRepository, times(1)).save(existingAccountArgumentCaptor.capture());

        Account actual = existingAccountArgumentCaptor.getValue();
        Account expected = existingAccount;

        assertTrue(actual.equals(expected));
    }

    // addNewAccount(Account account)
    @Test
    @Disabled
    void Should_Not_addNewAccount_When_AccountInDB() {
        given(testRepository.getAccountByUsername(existingAccount.getUsername()))
                .willReturn(Optional.ofNullable(existingAccount));

        testService.checkIfAccountInDB(existingAccount);

        verify(testRepository, times(1)).save(existingAccount);
    }

    // checkIfAccountInDB(Account account)
    @Test
    void Should_ThrowError_When_AddingExistingAccountToDB() {
        given(testRepository.getAccountByUsername(existingAccount.getUsername()))
                .willReturn(Optional.ofNullable(existingAccount));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            testService.checkIfAccountInDB(existingAccount);
        });

        String expected = "username taken";
        String actual = exception.getMessage();

        assertEquals(actual, expected);
    }

    // checkIfUsernameInUse(Account account)
    @Test
    void Should_ReturnTrue_When_UsernameInUse() {
        given(testRepository.getAccountByUsername(existingAccount.getUsername()))
                .willReturn(Optional.ofNullable(existingAccount));

        assertTrue(testService.checkIfUsernameInUse(existingAccount));
    }

    // checkIfUsernameInUse(Account account)
    @Test
    void Should_ReturnFalse_When_UsernameNotInUse() {
        given(testRepository.getAccountByUsername(existingAccount.getUsername()))
                .willReturn(Optional.empty());

        assertFalse(testService.checkIfUsernameInUse(existingAccount));
    }

    @Test
    @Disabled
    void Should_ReturnFalse_When_AccountNotInDB() {
        given(testRepository.getAccountByUsername(existingAccount.getUsername()))
                .willReturn(Optional.empty());

        Account newAccount = new Account(1L, "test", "test");

        assertFalse(testService.checkIfAccountInDB(newAccount));
    }

    @Test
    @Disabled
    void Should_getAccountById_AndReturnAccount_When_AccountInDB() {
        testService.addNewAccount(existingAccount);
        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);
        verify(testRepository).save(accountArgumentCaptor.capture());

        Account a = testService.getAccountById(0L);
        System.out.println(a);
        verify(testRepository).findById(0L);

        Account account = accountArgumentCaptor.getValue();
        assertTrue(account.equals(existingAccount));
    }

    @Test
    @Disabled
    void Should_getAccountById_AndThrowError_When_AccountNotInDB() {
        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);

        verify(testRepository).save(accountArgumentCaptor.capture());

        Account account = accountArgumentCaptor.getValue();
        assertTrue(account.equals(existingAccount));
    }
}








