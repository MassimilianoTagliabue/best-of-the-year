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
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class homeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nome", "gino");
        return "index";
    }
    
    
    public ArrayList<Movie> getBestMovies() {
        ArrayList<Movie> film = new ArrayList<>();

        film.add(new Movie(1, "titanic"));
        film.add(new Movie(2, "batman"));
        film.add(new Movie(3, "joker"));
        film.add(new Movie(4, "fast and furious"));
        film.add(new Movie(5, "thor"));

        return film;
    
    }

    @GetMapping("/movie")
    public String getMovie(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movie";
    }
    


    public ArrayList<Song> getBestSong() {
        ArrayList<Song> canzoni = new ArrayList<>();

        canzoni.add(new Song(1, "godzilla"));
        canzoni.add(new Song(2, "domeniche d'agosto"));
        canzoni.add(new Song(3, "l'inverno di vivaldi"));
        canzoni.add(new Song(4, "umbrella"));
        canzoni.add(new Song(4, "battito"));

        return canzoni;
    }

    @GetMapping("/song")
    public String getSong(Model model) {
        model.addAttribute("songs", getBestSong());
        return "song";
    }
    

    @GetMapping("/movie/{id}")
    public String detailMovie(@PathVariable int id, Model model) {
        Movie film = new Movie();
        
        for (Movie curFilm : getBestMovies()) {
            if(curFilm.getId() == id){
                film=curFilm;
            }
        }
    
        model.addAttribute("titolo", film.getTitolo());
        return "detail";
    }

    @GetMapping("/song/{id}")
    public String detailSong(@PathVariable int id, Model model) {
        Song canzone = new Song();
        
        for (Song curSong : getBestSong()) {
            if(curSong.getId() == id){
                canzone=curSong;
            }
        }
    
        model.addAttribute("titolo", canzone.getTitolo());
        return "detail";
    }
    

}
