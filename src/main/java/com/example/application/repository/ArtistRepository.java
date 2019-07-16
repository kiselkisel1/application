package com.example.application.repository;

import com.example.application.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>, JpaSpecificationExecutor<Artist> {

    @Query("select b from Artist b where b.name = :name or b.startActivityYear <= :year and b.endActivityYear >= :year or b.genres = :genres")
    List<Artist> filter(@RequestParam("name") String name,@RequestParam("year") int year,@RequestParam("genres") Integer[]genres);
}
