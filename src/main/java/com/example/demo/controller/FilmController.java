package com.example.demo.controller;

import com.example.demo.models.Film;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("api/films/{filmName}")
    @ResponseBody
    @CachePut(value="films")
    public ResponseEntity<Film> getFilm(@PathVariable String filmName){
        return ResponseEntity.ok(filmService.retrieveFilm(filmName));
    }
}
