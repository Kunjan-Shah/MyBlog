package blogcrud.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cid;
	private String comment;
	
	@ManyToOne
	private Blog blog;

	public Comment() {
		super();
	}
	
	public Comment(long cid, String comment, Blog blog) {
		super();
		this.cid = cid;
		this.comment = comment;
		this.blog = blog;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getComment() {
		return comment;
	}

	public void setCommentStr(String comment) {
		this.comment = comment;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", comment=" + comment + ", blog=" + blog + "]";
	}
	
}
