package pl.woukop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
 
import pl.woukop.model.Comment;
import pl.woukop.model.Discovery;
import pl.woukop.model.User;
import pl.woukop.util.ConnectionProvider;



public class CommentDAOImpl implements CommentDAO {
	
	private static final String CREATE_COMMENT = 
			"INSERT INTO comment(comment, discovery_id, user_id)"
			+ "VALUES(:comment, :discovery_id, :user_id);";
	private static final String READ_COMMENTS_BY_DISCOVERY = 
			"SELECT user.user_id, username, comment_id,comment "
			+ "FROM comment LEFT JOIN user ON comment.user_id=user.user_id"
			+" WHERE discovery_id=:discovery_id;";
	private static final String READ_ALL_COMMENTS = 
		      "SELECT user.user_id, username, comment_id,comment "
		      + "FROM comment LEFT JOIN user ON comment.user_id=user.user_id";
	
	public CommentDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }


	
	private NamedParameterJdbcTemplate template;
					
	@Override
	public Comment create(Comment comment) {
		Comment resultComment = new Comment(comment);
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("comment", comment.getContent());
		paramMap.put("discovery_id", comment.getDiscovery().getId());
		paramMap.put("user_id", comment.getUser().getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_COMMENT, paramSource, holder);
        if(update > 0) {
            resultComment.setId((Long)holder.getKey());
        }
        return resultComment;
	}

	@Override
	public Comment read(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Comment> readByDiscovery(Long discovery_id){
		SqlParameterSource paramSource = new MapSqlParameterSource("discovery_id", discovery_id);
		List<Comment> comments = template.query(READ_COMMENTS_BY_DISCOVERY, paramSource, new CommentRowMapper());
		
		return comments;
	}

	@Override
	public boolean update(Comment updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comment> getAll() {
		List<Comment> comments = template.query(READ_ALL_COMMENTS, new CommentRowMapper());
		return comments;
	}
	 private class CommentRowMapper implements RowMapper<Comment> {
	        @Override
	        public Comment mapRow(ResultSet resultSet, int row) throws SQLException {
	        	Comment comment =new Comment();
	        	comment.setId((resultSet.getLong("comment_id")));
	        	comment.setContent(resultSet.getString("comment"));
	            Discovery discovery=new Discovery();
	            User user = new User();
	            user.setUsername(resultSet.getString("username"));
	            comment.setDiscovery(discovery);
	            comment.setUser(user);
	        	/*
	        	Discovery discovery = new Discovery();
	            discovery.setId(resultSet.getLong("discovery_id"));
	            discovery.setName(resultSet.getString("name"));
	            discovery.setDescription(resultSet.getString("description"));
	            discovery.setUrl(resultSet.getString("url"));
	            discovery.setUpVote(resultSet.getInt("up_vote"));
	            discovery.setDownVote(resultSet.getInt("down_vote"));
	            discovery.setTimestamp(resultSet.getTimestamp("date"));
	            User user = new User();
	            user.setId(resultSet.getLong("user_id"));
	            user.setUsername(resultSet.getString("username"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            discovery.setUser(user);
	            comment.setUser(user);
	            comment.setDiscovery(discovery);
	            */
	            
	            return comment;
	        }
	    }

}
