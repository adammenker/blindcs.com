package com.interviewprep.blindcs.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("Select p FROM Post p WHERE p.posterName = ?1")
    Optional<Post> getCommentsByPost(String posterName);

}
