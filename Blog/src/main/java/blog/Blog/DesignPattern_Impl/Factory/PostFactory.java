package blog.Blog.DesignPattern_Impl.Factory;


import blog.Blog.Domain.Dto.PostDto;
import blog.Blog.Domain.Post;

/*
* @uthor Solomon
*
* Date Nov 15, 2018
*
* Factory for post
*
*
* */
public class PostFactory {

    private static PostFactory postFactory = null;

    public PostFactory() {
    }

    public static PostFactory getInstance()
    {
        if (postFactory == null)
            postFactory = new PostFactory();

        return postFactory;
    }

    public Post createPostFromDto(PostDto postDto){

        Post post = new Post();
        post.setBody(postDto.getBody());
        //post.setAutor(postDto.getAutor());
        //post.setCommentSet(postDto.getCommentSet());
        post.setArticle(postDto.getArticle());

        return post;

    }


}

