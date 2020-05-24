package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.asyncmethod.GitHubLookupService;
import hello.asyncmethod.User;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

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
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        try {
            String result;

            CompletableFuture<User> page1 = gitHubLookupService.findUser("lulski");
            CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
            CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return "async method ";
    }

}