package com.example.demo.service;

import com.example.demo.mappers.FilmMapper;
import com.example.demo.models.Film;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FilmService{
    private final WebClient webClient;

    public FilmService(WebClient.Builder webCLientBuilder){
        this.webClient = webCLientBuilder.baseUrl("https://api.themoviedb.org").build();
    }

    public Film retrieveFilm(String filmName){
        //filmName = filmName.replaceAll("\\s+", "+").toLowerCase();
        String response = this.webClient.get().uri("/3/search/movie?api_key=14578137b1c918d2816431737084e1d2" +
                "&query="+filmName).retrieve().bodyToMono(String.class).block();

        return FilmMapper.fromFilmDataToFilm(response);


    }
}
