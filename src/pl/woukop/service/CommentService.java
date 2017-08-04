package pl.woukop.service;

import java.sql.Timestamp;
import java.util.Date;
 
import pl.woukop.dao.DAOFactory;
import pl.woukop.dao.CommentDAO;
import pl.woukop.model.Discovery;
import pl.woukop.model.User;
import pl.woukop.model.Comment;

public class CommentService {
	
	public void addComment(String content, Discovery discovery, User user) {
		Comment comment=createCommentObject(content,discovery,user);
		DAOFactory factory = DAOFactory.getDAOFactory();
        CommentDAO commentDao = factory.getCommentDAO();
        commentDao.create(comment);
	}
	
	private Comment createCommentObject(String content, Discovery discovery, User user) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setDiscovery(discovery);
		comment.setUser(user);
		return comment;
	}

}
