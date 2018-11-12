package blog.Blog.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comment {
    @Id@GeneratedValue
    private long id;
    @NotEmpty
    @Lob
    private String text;

    @ManyToOne
    private Post post;



}
