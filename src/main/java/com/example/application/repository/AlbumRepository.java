package com.example.application.repository;

import com.example.application.model.Album;
import com.example.application.model.Artist;
import com.example.application.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {

    @Query("select b from Album b where b.name = :name or b.year = :year")
    List<Album> filter(@RequestParam("name") String name, @RequestParam("year") int year);

//    @Query(value="SELECT*FROM ALBUM b WHERE artistId IN b.artists", nativeQuery = true)
        @Query(value="select b from Album b where artistId In :b.artists", nativeQuery = true)
        List<Album> getAlbumsWithArtist(@RequestParam("artistId") Integer artistId);
}
