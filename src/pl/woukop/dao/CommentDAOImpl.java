package pl.woukop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
 
import pl.woukop.model.Comment;
import pl.woukop.util.ConnectionProvider;



public class CommentDAOImpl implements CommentDAO {
	
	private static final String CREATE_COMMENT = 
			"INSERT INTO comment(comment, discovery_id, user_id)"
			+ "VALUES(:comment, :discovery_id, :user_id);";
	
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
		// TODO Auto-generated method stub
		return null;
	}

}
