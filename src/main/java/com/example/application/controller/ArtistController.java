package com.example.application.controller;

 import com.example.application.exceptions.ThereIsNoSuchArtistException;
 import com.example.application.model.Artist;
 import com.example.application.repository.ArtistRepository;
 import com.example.application.service.ArtistService;
 import com.example.application.validator.ArtistValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ArtistValidator artistValidator;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAll();
}

//    @GetMapping("{id}")
//    public Artist getOne(@PathVariable("id") Artist artist){
//        return artist;
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<Artist> getUsersById(@PathVariable Long id)
//    {
//        Artist artist = artistService.getOne(id);
//        return ResponseEntity.ok().body(artist);
//    }
@GetMapping("{id}")
public ResponseEntity<Artist> getUsersById(@PathVariable Long id)
        throws ThereIsNoSuchArtistException {
    Artist artist=artistRepository.findById(id)
            .orElseThrow(() -> new ThereIsNoSuchArtistException());
    return ResponseEntity.ok().body(artist);
}

    @PostMapping
    public Artist create(@RequestBody Artist artist){
        return artistService.add(artist);
    }

    @PutMapping("{id}")
    public Artist update(@PathVariable("id") Artist artistFromDb,
                         //spring из тела запроса(json) сам разбирает данные и кладет их в обьект типа artist
                         @RequestBody Artist artistFromUser ){
        BeanUtils.copyProperties(artistFromUser,artistFromDb,"id");

        return artistService.update(artistFromDb);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Artist artist) {
        artistService.delete(artist);
    }

//    @GetMapping("/filter")
//    public  List<Artist> filter(@RequestParam("name") String name,
//                                @RequestParam("year") int year,
//                                @RequestParam("genres") Integer[]genres) {
//    return artistRepository.filter(name,year,genres);
//    }

    }


