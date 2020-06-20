package lulski.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lulski.asyncmethod.GitHubLookupService;
import lulski.asyncmethod.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AppController {

    @Autowired
    GitHubLookupService gitHubLookupService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/kocu")
    public String index(@RequestParam("name") String name) {
        return "Greetings from hot update " + name;
    }

    @RequestMapping("/asyncmethod")
    public String runAsyncMethod() {

        // Kick of multiple, asynchronous lookups
        try {
            StringBuilder result = new StringBuilder();
            List<CompletableFuture<User>> listUser = new ArrayList<CompletableFuture<User>>();

            CompletableFuture<User> page1 = gitHubLookupService.findUser("lulski");
            listUser.add(page1);

            CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
            listUser.add(page2);

            CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
            listUser.add(page3);


            listUser.forEach(user -> {
                try {
                    result.append(user.get().getName());
                    result.append("\n").append(user.get().getBlog()).append("\n\n");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

            return result.toString();

        }  catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "failed to fetch from gitHubLookupService";
    }

}