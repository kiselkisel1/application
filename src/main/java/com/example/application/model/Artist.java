package com.example.application.model;

import com.example.application.utils.CurrentYear;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.omg.CORBA.INTERNAL;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Artist {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min=5,max=200,message = "Name should contain from 5 to 200 symbols")
    private String name;

    @Size(max=2000,message = "Notes should contain less than 2000 symbols")
    private String notes;

    @Min(1900)
    private int startActivityYear;

    @Min(1900)
    private int endActivityYear;

    private  Integer[] genres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartActivityYear() {
        return startActivityYear;
    }

    public void setStartActivityYear(int startActivityYear) {
        this.startActivityYear = startActivityYear;
    }

    public int getEndActivityYear() {
        return endActivityYear;
    }

    public void setEndActivityYear(int endActivityYear) {
        this.endActivityYear = endActivityYear;
    }

    public Integer[] getGenres() {
        return genres;
    }

    public void setGenres(Integer[] genres) {
        this.genres = genres;
    }

    public Artist(Integer id, @NotBlank(message = "Name is required") @Size(min = 5, max = 200, message = "Name should contain from 5 to 200 symbols") String name, @Size(max = 2000, message = "Notes should contain less than 2000 symbols") String notes, Integer startActivityYear, Integer endActivityYear, Integer[] genres) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.startActivityYear = startActivityYear;
        this.endActivityYear = endActivityYear;
        this.genres = genres;
    }

    public Artist() {
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", startActivityYear=" + startActivityYear +
                ", endActivityYear=" + endActivityYear +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
