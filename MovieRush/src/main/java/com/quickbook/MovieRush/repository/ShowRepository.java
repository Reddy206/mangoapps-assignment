package com.quickbook.MovieRush.repository;

import com.quickbook.MovieRush.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
    List<Show> findShowByMovieId(Long movieId);
}
