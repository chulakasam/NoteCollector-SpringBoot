package lk.ijse.gdse.aad67.NoteCollector_v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//meken veiw ekk eliyata denn puluwn(serever side entity)
@RequestMapping("api/v1/welcome")
public class WelcomeController {
    @GetMapping
    public String viewWelcomeScreen(Model model){
        model.addAttribute("message","Note Collector - V2");
        return "welcome";
    }
}
