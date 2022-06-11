package com.interviewprep.blindcs.post;

import com.interviewprep.blindcs.account.Account;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )


    @Getter @Setter private Long id;

    //@Getter @Setter @ManyToOne private Account posterName;
    @Getter @Setter private String posterName;
    @Getter @Setter @ElementCollection private List<String> comments;
    @Getter @Setter private int votes;

    public Post() {
        this.votes = 0;
        comments = new ArrayList<>();
    }

    public Post(Long id, String posterName) {
        this();
        this.id = id;
        this.posterName = posterName;
    }
}
