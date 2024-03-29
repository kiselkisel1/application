package com.example.application.service.impl;

import com.example.application.exceptions.ResourceNotFoundException;
import com.example.application.model.Album;
import com.example.application.repository.AlbumRepository;
import com.example.application.repository.ArtistRepository;
import com.example.application.repository.GenreRepository;
import com.example.application.service.AlbumService;
import com.example.application.service.ArtistService;
import com.example.application.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

   @Autowired
    AlbumRepository albumRepository;

   @Autowired
    ArtistService artistService;

   @Autowired
    GenreService genreService;

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album getOne(Integer id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ALBUM_DOES_NOT_EXIST"));
    }

    @Override
    public Album save(Album album) {

        for(Integer id:album.getGenres()){
           genreService.getOne(id);
        }
        for(Integer id:album.getArtists()){
            artistService.getOne(id);
        }
        return albumRepository.save(album);
    }

    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    @Override
    public List<Album> filter(String name, int year) {
        return albumRepository.filter(name,year);
    }

    @Override
    public List<Album> getAlbums(Integer artistId) {
        return albumRepository.getAlbumsWithArtist(artistId);
    }
}
