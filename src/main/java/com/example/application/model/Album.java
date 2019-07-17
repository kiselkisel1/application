package com.example.application.model;

import com.example.application.utils.CurrentYear;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.Calendar;

@Entity
@Table
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min=5,max=200,message = "Name should contain from 5 to 200 symbols")
    private String name;

//    @Range(min=1900, max=Year.now().getValue())
    private int year;

    @Size(max=2000,message = "Notes should contain less than 2000 symbols")
    private String notes;

    private  Integer[] genres;

    private Integer[] artists;

    public Album(Integer id, @NotBlank(message = "Name is required") @Size(min = 5, max = 200, message = "Name should contain from 5 to 200 symbols") String name, @NotNull int year, @Size(max = 2000, message = "Notes should contain less than 2000 symbols") String notes, Integer[] genres, Integer[] artists) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.notes = notes;
        this.genres = genres;
        this.artists = artists;
    }

    public Album() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer[] getGenres() {
        return genres;
    }

    public void setGenres(Integer[] genres) {
        this.genres = genres;
    }

    public Integer[] getArtists() {
        return artists;
    }

    public void setArtists(Integer[] artists) {
        this.artists = artists;
    }
}
