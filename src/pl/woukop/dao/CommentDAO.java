package pl.woukop.dao;

import java.util.List;

import pl.woukop.model.Comment;

public interface CommentDAO extends GenericDAO<Comment, Long> {
	List<Comment> getAll();
	List<Comment>readByDiscovery(Long discovery_id);
	

}
