package com.example.application.controller;

 import com.example.application.exceptions.ResourceNotFoundException;
 import com.example.application.model.Artist;
 import com.example.application.service.ArtistService;
 import com.example.application.validator.ArtistValidator;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.validation.BindingResult;
 import org.springframework.web.bind.MethodArgumentNotValidException;
 import org.springframework.web.bind.WebDataBinder;
 import org.springframework.web.bind.annotation.*;

 import javax.validation.Valid;
 import java.util.List;

@RestController
@RequestMapping("artists")
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(Artist.class);

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new ArtistValidator());
//    }

    @Autowired
    ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists(@RequestParam(required=false) String name,
                                @RequestParam(required=false) Integer year,
                                @RequestParam(required=false) Integer[]genres) {

        if(name!=null && year!=null && genres!=null ){
            logger.debug("inside filter");
           return artistService.filter(name,year,genres);
        }
        return artistService.getAll();
}

    @GetMapping("{id}")
    public Artist getArtistById(@PathVariable Integer id) {
       Artist artist=artistService.getOne(id);
       if(artist.getGenres()==null || artist.getGenres().length==0){
           logger.debug("there are no genres");
       }
       //If genre for an artist is not present – collect all genres from albums tied to given artist on get operation
        return artist;
    }

    @PostMapping
    public Artist create(@Valid @RequestBody Artist artist){

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


    @GetMapping("/g")
    public  List<Artist> filterg(@RequestParam Integer[]genres) {
        logger.debug("filter by genres" );
        return artistService.filterByGenre(genres);
    }
    }


