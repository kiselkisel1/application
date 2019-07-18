package com.example.application.service;

import com.example.application.model.Artist;
import com.example.application.model.Genre;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArtistService {

    List<Artist> getAll();
    Artist getOne(Integer id);
    Artist save(Artist artist);
    void delete(Artist artist);
    List<Artist> filter( String name, int year,Integer[] genres);
    List<Artist> filterByGenre(Integer[] genres);
    List<Genre> findGenresFromAlbumToArtist(Integer id);
}
