package org.lessons.java.spring.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.spring.best_of_the_year.classes.Movie;
import org.lessons.java.spring.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/")
public class homeController {
    

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("nome", "gino");
       return "index";
    }

    @GetMapping("/movie")
    public String getBestMovies(Model model){
        ArrayList <Movie> film = new ArrayList<>();

        film.add(new Movie(3, "titanic"));
        film.add(new Movie(6, "ginetto"));
        film.add(new Movie(4, "pupetto"));
        model.addAttribute("movies", film);

        return "movie";
    }
    

    @GetMapping("/song")
    public String getBestSong(Model model) {

        ArrayList <Song> canzoni = new ArrayList<>();
        canzoni.add(new Song(3, "godzilla"));
        canzoni.add(new Song(6, "dr dre"));
        canzoni.add(new Song(4, "l'inverno di vivaldi"));

        model.addAttribute("songs",canzoni);

        return "song";
    }
    
    
}
