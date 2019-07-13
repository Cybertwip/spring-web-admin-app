package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/crud")
    public String crud(Model model, @RequestParam(defaultValue="Users") String kind) {

        model.addAttribute("kind", kind);

        return "crud";

    }

    @GetMapping("/resources")
    public String resources() { return "resources"; }

}
