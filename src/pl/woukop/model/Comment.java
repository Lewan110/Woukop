package pl.woukop.model;

import java.sql.Timestamp;

public class Comment {
	private long id;
	private String content;
	private Discovery discovery;
	private User user;
	
	public Comment() {};
	
	public Comment(Comment comment) {
		this.id=comment.id;
		this.content=comment.content;
		this.discovery=comment.discovery;
		this.user=comment.user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((discovery == null) ? 0 : discovery.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (discovery == null) {
			if (other.discovery != null)
				return false;
		} else if (!discovery.equals(other.discovery))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", discovery=" + discovery + ", user=" + user + "]";
	}
	
	

}
