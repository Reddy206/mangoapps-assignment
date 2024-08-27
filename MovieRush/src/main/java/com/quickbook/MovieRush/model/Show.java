package com.quickbook.MovieRush.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movie_show")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private int totalSeats;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @JsonIgnore
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Seat> seats;

    @Transient
    public int getAvailableSeats() {
        return (int) seats.stream().filter(seat -> !seat.isBooked()).count();
    }
}
