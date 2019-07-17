package com.example.application.service.impl;

import com.example.application.exceptions.ResourceNotFoundException;
import com.example.application.model.Artist;
import com.example.application.model.Genre;
import com.example.application.repository.ArtistRepository;
import com.example.application.repository.GenreRepository;
import com.example.application.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    GenreRepository genreRepository;

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
        for(Integer id:artist.getGenres()){
            genreRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("GENRE_DOES_NOT_EXIST"));
       }
        return artistRepository.save(artist);
    }

    @Override
    public void delete(Artist artist) {
        artistRepository.delete(artist);
    }
}
