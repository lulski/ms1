package lulski;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    @Mock
    private WebsiteService websiteService;

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

    @Test
    public void website_api_returns_navigation_menu_items() throws Exception {
        List<NavigationMenuItem> navMenuItems = new ArrayList<NavigationMenuItem>();
        navMenuItems.add(new NavigationMenuItem("home", "/home"));
        navMenuItems.add(new NavigationMenuItem("home", "/pics"));
        navMenuItems.add(new NavigationMenuItem("home", "/notes"));


        when(websiteService.getNavigationMenuItems()).thenReturn(navMenuItems);

        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void testArray() throws Exception {

        ArrayList<String[]> games = new ArrayList<String[]>();
        String[] ps4Games = { "last of us 2", "uncharted 4", "gran turismo sport" };
        String[] pcGames = { "dirt2", "valorant", "resident evil 3" };

        games.add(ps4Games);
        games.add(pcGames);

        for (String[] gamecollection : games) {
            System.out.println(Arrays.toString(gamecollection));
        }

        assertArrayEquals(new String[] { "last of us 2", "uncharted 4", "gran turismo sport" }, games.get(0));
    }







}