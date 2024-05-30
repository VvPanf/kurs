package org.voting.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.voting.model.Game;
import org.voting.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        List<Game> games = gameService.getAll();
        model.addAttribute("games", games);
        return "index";
    }

    @PostMapping("/vote")
    public String postVote(@RequestParam("id") String id) {
        gameService.voteById(id);
        return "ok";
    }

    @GetMapping("/add")
    public String getAdd() {
        return "add";
    }

    @PostMapping("/add")
    public String postAdd(Game game) {
        gameService.addGame(game);
        return "redirect:/";
    }
}
