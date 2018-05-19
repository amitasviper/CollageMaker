package hello;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/user")
    public String user(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        String body = "Failed";
        try {
            HttpResponse<String> response = Unirest.get("https://amitasviper.com/assets/resp.json").asString();
            body = response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        model.addAttribute("name", body);
        return "greeting";
    }

}
