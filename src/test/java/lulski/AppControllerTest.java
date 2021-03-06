package lulski;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;




public class AppControllerTest extends AbstractTest{

    @Autowired//TODO refactor object to make test works without autowired,
    private MockMvc mvc;


    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void getAsyncMethod() throws Exception {
        // System.out.println(mvc.perform(MockMvcRequestBuilders.get("/asyncmethod")));

        mvc.perform(MockMvcRequestBuilders.get("/asyncmethod").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }





}