package com.example.demo.mappers;

import com.example.demo.exceptions.FilmException;
import com.example.demo.models.Film;
import org.json.JSONArray;
//import org.json.JSONException;
import org.json.JSONObject;
//import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;


public class FilmMapper {
    //final static Logger logger = Logger.getLogger(FilmMapper.class);
    public static Film fromFilmDataToFilm(String filmData){

        try {
            JSONObject jsonObject = new JSONObject(filmData);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            if(jsonArray.length() == 0){
                Film film = new Film();
                film.setTitle("");
                film.setOverview("");
                film.setReleaseDate("");
                return film;
            }

            JSONObject jsonResponse = jsonArray.getJSONObject(0);
            Film film = new Film();
            film.setTitle(jsonResponse.getString("title"));
            film.setOverview(jsonResponse.getString("overview"));
            film.setReleaseDate(jsonResponse.getString("release_date"));

            return film;
        }
        catch(Exception e){
            //logger.error("Unexpected Error happened during film retrieval", e);
            throw new FilmException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error happened during film retrieval");
        }


    }
}
