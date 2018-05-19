package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @GetMapping("/add")
    public String add(@RequestParam(name="num1", required=false, defaultValue="0") String num1,
                           @RequestParam(name="num2", required=false, defaultValue="0") String num2, Model model) {
        float ans = Float.parseFloat(num1) + Float.parseFloat(num2);
        model.addAttribute("answer", ans);
        return "calculator_output";
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam(name="num1", required=false, defaultValue="0") String num1,
                      @RequestParam(name="num2", required=false, defaultValue="0") String num2, Model model) {
        float ans = Float.parseFloat(num1) - Float.parseFloat(num2);
        model.addAttribute("answer", ans);
        return "calculator_output";
    }

}
