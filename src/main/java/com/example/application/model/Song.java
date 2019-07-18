package com.example.application.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min=5,max=200,message = "Name should contain from 5 to 200 symbols")
    private String name;

    //    @Range(min=1900, max=Year.now().getValue())
    private int year;

    private String comment;

    private  Integer[] artists;

    private  Integer[] albums;

    private  Integer[] genres;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer[] getArtists() {
        return artists;
    }

    public void setArtists(Integer[] artists) {
        this.artists = artists;
    }

    public Integer[] getAlbums() {
        return albums;
    }

    public void setAlbums(Integer[] albums) {
        this.albums = albums;
    }

    public Integer[] getGenres() {
        return genres;
    }

    public void setGenres(Integer[] genres) {
        this.genres = genres;
    }

    public Song() {
    }

    public Song(Integer id, @NotBlank(message = "Name is required") @Size(min = 5, max = 200, message = "Name should contain from 5 to 200 symbols") String name, int year, String comment, Integer[] artists, Integer[] albums, Integer[] genres) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.comment = comment;
        this.artists = artists;
        this.albums = albums;
        this.genres = genres;
    }
}
