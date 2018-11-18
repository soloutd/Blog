package blog.Blog.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public void addComment(Comment comment) {
        commentSet.add(comment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", body='" + body + '\'' +
               // ", date=" + date +
                ", autor='" + autor + '\'' +
                ", flag='" + flag + '\'' +
              //  ", commentSet=" + commentSet +
                '}';
    }
}
