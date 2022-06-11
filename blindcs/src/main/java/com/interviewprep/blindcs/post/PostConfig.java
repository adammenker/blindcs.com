package com.interviewprep.blindcs.post;

import com.interviewprep.blindcs.account.Account;
import com.interviewprep.blindcs.account.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
            Post post1 = new Post(
                    1L,
                    "adam",
                    new ArrayList<>(Arrays.asList("hello", "world")),
                    5
            );

            Post post2 = new Post(
                    2L,
                    "john",
                    new ArrayList<>(Arrays.asList("comment", "comment2")),
                    -8
            );

            repository.saveAll(Stream.of(post1, post2).collect(Collectors.toList()));
        };
    }
}
