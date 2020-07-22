package lulski;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import lulski.model.Post;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostModelTest {

    @Autowired
    Post post;

    @Test
    public void write_a_new_post_and_persist_to_database(){

        assertTrue("Post.save() method should've return int > 0", post.save() > 0);
    }
}