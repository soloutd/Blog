package blog.Blog.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
