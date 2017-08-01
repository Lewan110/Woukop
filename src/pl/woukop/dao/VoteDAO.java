package pl.woukop.dao;

import pl.woukop.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {
 
    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);
}