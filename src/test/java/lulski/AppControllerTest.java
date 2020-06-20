package lulski;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lulski.model.NavigationMenuItem;
import lulski.service.WebsiteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WebsiteService websiteService;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void getAsyncMethod() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/asyncmethod").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getNavigationMenuItems() throws Exception{
        List<NavigationMenuItem> navMenuItems = new ArrayList<NavigationMenuItem>();
        navMenuItems.add(new NavigationMenuItem("home","/home"));
        navMenuItems.add(new NavigationMenuItem("home","/pics"));
        navMenuItems.add(new NavigationMenuItem("home","/notes"));

        ResponseEntity<List<NavigationMenuItem>> expected = new ResponseEntity<List<NavigationMenuItem>>(navMenuItems,HttpStatus.OK);

        when(websiteService.getNavigationMenuItems()).thenReturn(navMenuItems);


        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}