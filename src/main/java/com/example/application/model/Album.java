package com.example.application.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min=5,max=200,message = "Name should contain from 5 to 200 symbols")
    private String name;

    @NotNull
    private int year;

    @Size(max=2000,message = "Notes should contain less than 2000 symbols")
    private String notes;

    private  Integer[] genres;

    private Integer[] artists;

    
}
