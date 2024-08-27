package com.quickbook.MovieRush.config;

import com.quickbook.MovieRush.model.Movie;
import com.quickbook.MovieRush.model.Seat;
import com.quickbook.MovieRush.model.Show;
import com.quickbook.MovieRush.repository.MovieRepository;
import com.quickbook.MovieRush.repository.SeatRepository;
import com.quickbook.MovieRush.repository.ShowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(MovieRepository movieRepository, ShowRepository showRepository, SeatRepository seatRepository) {
        return args -> {
            Movie movie1 = new Movie(null, "The Matrix", "Sci-Fi", new ArrayList<>());
            Movie movie2 = new Movie(null, "Inception", "Action", new ArrayList<>());

            Show show1 = new Show(null, "10:00 AM", 5, movie1, new ArrayList<>());
            Show show2 = new Show(null, "02:00 PM", 5, movie1, new ArrayList<>());

            Show show3 = new Show(null, "12:00 PM", 5, movie2, new ArrayList<>());
            Show show4 = new Show(null, "04:00 PM", 5, movie2, new ArrayList<>());

            movie1.setShows(Arrays.asList(show1, show2));
            movie2.setShows(Arrays.asList(show3, show4));

            movieRepository.saveAll(Arrays.asList(movie1, movie2));

            for (Show show : Arrays.asList(show1, show2, show3, show4)) {
                for (int i = 1; i <= show.getTotalSeats(); i++) {
                    Seat seat = new Seat(null, i, false, show);
                    seatRepository.save(seat);
                }
            }
        };
    }
}
