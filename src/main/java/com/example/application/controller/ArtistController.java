package com.example.application.controller;

 import com.example.application.model.Artist;
 import com.example.application.service.ArtistService;
  import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import java.util.List;

@RestController
@RequestMapping("artists")
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(Artist.class);

    @Autowired
    ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAll();
}

    @GetMapping("{id}")
    public Artist getArtistById(@PathVariable Integer id) {
        return artistService.getOne(id);
    }

    @PostMapping
    public Artist create(@RequestBody @Valid Artist artist){
        return artistService.save(artist);
    }

    @PutMapping("{id}")
    public Artist update(@PathVariable("id") Integer id,
                         @RequestBody @Valid Artist artistFromUser ){
        logger.debug("id "+id+" = artistFromUser "+artistFromUser.toString() );

        Artist artist=artistService.getOne(id);
        BeanUtils.copyProperties(artistFromUser,artist,"id");
        return artistService.save(artist);
    }



    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        Artist artist=artistService.getOne(id);
        artistService.delete(artist);
    }

//    @GetMapping("/filter")
//    public  List<Artist> filter(@RequestParam("name") String name,
//                                @RequestParam("year") int year,
//                                @RequestParam("genres") Integer[]genres) {
//    return artistRepository.filter(name,year,genres);
//    }

    }


