package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

public class Film {
    @Getter
    @Setter
    String title;
    @Getter
    @Setter
    private String overview;

    @Getter
    @Setter
    private String releaseDate;

    public Film(String title, String overview, String releaseDate){
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public Film(){
    }
}
