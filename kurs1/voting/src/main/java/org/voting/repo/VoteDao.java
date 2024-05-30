package org.voting.repo;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.voting.model.Vote;

@Repository
@Transactional
public class VoteDao {
    private static final String KEY = "games";

    @Resource(name="redisTemplate")
    private ZSetOperations<String, String> zSetOps;

    public void addNewVote(Vote vote) {
        zSetOps.add(KEY, vote.getGameId(), vote.getVoteCount().doubleValue());
    }

    public void incrementVote(String id) {
        zSetOps.incrementScore(KEY, id, 1);
    }
}
