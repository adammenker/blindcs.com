package com.interviewprep.blindcs.account;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void addNewAccount(Account account) {
        if (!checkIfAccountInDB(account)) {
            accountRepository.save(account);
        }
    }

    public Boolean checkIfAccountInDB(Account account) {
        if (this.checkIfUsernameInUse(account)) {
            throw new IllegalStateException("username taken");
        } else {
            return false;
        }
    }

    public Boolean checkIfUsernameInUse(Account account) {
        Optional<Account> accountOptional = accountRepository.getAccountByUsername(account.getUsername());
        if (accountOptional.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteAccount(Long accountId) {
        Boolean accountExists = accountRepository.existsById(accountId);
        if (!accountExists) {
            throw new IllegalStateException("account with id: " + accountId + " doesn't exist");
        }
        accountRepository.deleteById(accountId);
    }

    @Transactional
    public void updateAccountUsername(Long accountId, String username) {
        Account account = getAccountById(accountId);

        if (username != null && username.length() > 0 && !Objects.equals(account.getUsername(), username)) {
            account.setUsername(username);
        }
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalStateException("no acct by id"));
    }

}
