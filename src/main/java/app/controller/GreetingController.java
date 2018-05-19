package app.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import app.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import app.repo.FriendRepository;

@Controller
public class GreetingController {
    @Autowired
    FriendRepository repository;

    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String process(){
        repository.save(new Friend("Amit", "Kumar"));
        repository.save(new Friend("Sachin", "Singhania"));
        repository.save(new Friend("Kim", "Chao"));
        repository.save(new Friend("David", "Dhavan"));
        repository.save(new Friend("Peter", "Fernandis"));

        return "Done";
    }

    @GetMapping("/friends")
    @ResponseBody
    public String user(Model model) {
        String result = "";

        for(Friend friend : repository.findAll()){
            result += friend.toString() + "<br>";
        }

        return result;
    }

    @GetMapping("/webhook")
    @ResponseBody
    public String webhook(Model model) {
        String body = null;
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://amitasviper.com/assets/resp.json").asJson();
            body = response.getBody().toString();
        } catch (UnirestException e) {
            System.out.println("Error encountered while downloading the resource from web");
            e.printStackTrace();
        }
            return body;
    }

}
