package org.voting.service;

import org.voting.model.Game;
import org.voting.model.Vote;
import org.voting.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.voting.repo.VoteDao;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private VoteDao voteDao;

    public List<Game> getAll() {
        return gameRepo.findAll();
    }

    public Game addGame(Game game) {
        Game newGame = gameRepo.save(game);
        voteDao.addNewVote(new Vote(newGame.getId(), 0));
        return newGame;
    }

    public void voteById(String id) {
        voteDao.incrementVote(id);
    }
}
