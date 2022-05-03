package com.interviewprep.blindcs.account;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Account {
    private Long id;
    private String username;
    private String password;

    public Account(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
