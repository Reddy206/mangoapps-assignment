package com.quickbook.MovieRush.service;

import com.quickbook.MovieRush.Exception.ResourceNotFoundException;
import com.quickbook.MovieRush.model.*;
import com.quickbook.MovieRush.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public Booking bookTicket(Long movieId, Long showId, Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User", "userId", userId);
        }
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if (movieOpt.isEmpty()) {
            throw new ResourceNotFoundException("Movie", "movieId", movieId);
        }

        Optional<Show> showOpt = showRepository.findById(showId);
        if (showOpt.isEmpty()) {
            throw new ResourceNotFoundException("Show", "showId", showId);
        }

        Show show = showOpt.get();
        for (Seat seat : show.getSeats()) {
            if (!seat.isBooked()) {
                seat.setBooked(true);
                seatRepository.save(seat);

                Booking booking = new Booking();
                booking.setMovie(movieOpt.get());
                booking.setShow(show);
                booking.setSeat(seat);
                booking.setUser(user.get());
                return bookingRepository.save(booking);
            }
        }
        throw new ResourceNotFoundException("No available seats");
    }

    @Transactional
    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingOpt = bookingRepository.findById(bookingId);
        if (bookingOpt.isEmpty()) {
            throw new ResourceNotFoundException("Booking", "bookingId", bookingId);
        }

        Booking booking = bookingOpt.get();
        Seat seat = booking.getSeat();
        seat.setBooked(false);
        seatRepository.save(seat);

        bookingRepository.delete(booking);
    }

    public List<Show> getShowsForMovie(Long movieId) {
        List<Show> showByMovieId = showRepository.findShowByMovieId(movieId);
        if (showByMovieId.isEmpty()) {
            throw new ResourceNotFoundException("Show", "movieId", movieId);
        }
        return showByMovieId;
    }
}
