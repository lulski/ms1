package lulski;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


import lulski.model.Post;



public class PostModelTest  {


    Post post = new Post();

    @Test
    public void write_a_new_post_and_persist_to_database(){

        assertTrue("Post.save() method should've return int > 0", post.save() > 0);
    }
}