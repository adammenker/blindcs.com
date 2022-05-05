package com.interviewprep.blindcs.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            Account acct1 = new Account(
                    1L,
                    "test",
                    "test"
            );

            Account acct2 = new Account(
                    2L,
                    "adam",
                    "password"
            );

            Account acct3 = new Account(
                    3L,
                    "john",
                    "password"
            );

            repository.saveAll(Stream.of(acct1, acct2, acct3).collect(Collectors.toList()));
        };
    }


}
