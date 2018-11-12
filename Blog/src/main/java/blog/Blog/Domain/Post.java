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

    @NotEmpty
    private String article;

    @Lob
    @NotEmpty
    private String body;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String flag;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    Set<Comment> commentSet;
   // private String report;

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
}
