package blog.Blog.Domain.Dto;

import blog.Blog.Domain.Comment;
import blog.Blog.Domain.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

public class PostDto {

    @NotEmpty(message = "article Title can'be be Empty")
    private String article;

    @Lob
    @NotEmpty(message = "the body of your article can't be Empty")
    private String body;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String autor;

    private String flag;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    Set<Comment> commentSet;
    // private String report;

    private User user;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
