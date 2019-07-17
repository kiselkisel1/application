package com.example.application.controller;

import com.example.application.model.Genre;
import com.example.application.repository.GenreRepository;
import com.example.application.service.GenreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAll();
    }

    @GetMapping("{id}")
    public Genre getGenreById(@PathVariable("id")  Integer id){
        return  genreService.getOne(id);
    }

    @PostMapping
    public Genre create(@RequestBody @Valid Genre genre){

        return genreService.save(genre);
    }

    @PutMapping("{id}")
    public Genre update(@PathVariable("id") Integer id,
                        //spring из тела запроса(json) сам разбирает данные и кладет их в обьект типа artist
                        @RequestBody @Valid Genre genreFromUser ){
        Genre genre =genreService.getOne(id);
        BeanUtils.copyProperties(genreFromUser,genre,"id");
        return genreService.save(genre);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        Genre genre =genreService.getOne(id);
        genreService.delete(genre);
    }
}
