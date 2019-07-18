package com.example.application.service.impl;

import com.example.application.exceptions.ResourceNotFoundException;
import com.example.application.model.Artist;
import com.example.application.model.Genre;
import com.example.application.repository.ArtistRepository;
import com.example.application.repository.GenreRepository;
import com.example.application.service.AlbumService;
import com.example.application.service.ArtistService;
import com.example.application.service.GenreService;
import com.example.application.utils.CurrentYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    GenreService genreService;

    @Autowired
    AlbumService albumService;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getOne(Integer id){
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ARTIST_DOES_NOT_EXIST"));
    }

    @Override
    public Artist save(Artist artist) {

        CurrentYear.validateYear(artist.getStartActivityYear());
        CurrentYear.validateYear(artist.getEndActivityYear());

        for(Integer id:artist.getGenres()){
          genreService.getOne(id);
       }
        return artistRepository.save(artist);
    }

    @Override
    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }

    @Override
    public List<Artist> filter(String name, int year,Integer[] genres) {
        return artistRepository.filter(name,year,genres);
    }

    @Override
    public List<Artist> filterByGenre(Integer[] genres) {
        return artistRepository.filterByGenres(genres);
    }

    @Override
    public List<Album> findGenresFromAlbumToArtist(Integer id) {
        return albumService.getAlbums(id);
    }
}
