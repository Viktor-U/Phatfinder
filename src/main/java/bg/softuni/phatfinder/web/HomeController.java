package bg.softuni.phatfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){

        int sofiaTemp = new Random().nextInt();

        model.addAttribute("sofiaTemp", sofiaTemp);

//        ModelAndView mnv = new ModelAndView();
//        mnv.setViewName("index");
//        mnv.addObject("sofiaTemp", sofiaTemp);

        return "index";
    }
}
