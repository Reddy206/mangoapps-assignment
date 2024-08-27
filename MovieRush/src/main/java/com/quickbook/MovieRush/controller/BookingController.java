package com.quickbook.MovieRush.controller;

import com.quickbook.MovieRush.Exception.ApiResponse;
import com.quickbook.MovieRush.model.Booking;
import com.quickbook.MovieRush.model.Movie;
import com.quickbook.MovieRush.model.Show;
import com.quickbook.MovieRush.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> allMovies = bookingService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(@RequestParam Long movieId, @RequestParam Long showId, @RequestParam Long userId) {
        Booking booking = bookingService.bookTicket(movieId, showId, userId);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return new ResponseEntity<>("Booking with bookingId "+ bookingId + " Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/shows/{movieId}")
    public ResponseEntity<List<Show>> getShowsForMovie(@PathVariable Long movieId) {
        List<Show> showsForMovie = bookingService.getShowsForMovie(movieId);
        return new ResponseEntity<>(showsForMovie, HttpStatus.OK);
    }
}
