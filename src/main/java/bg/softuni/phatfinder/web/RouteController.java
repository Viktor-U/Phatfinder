package bg.softuni.phatfinder.web;

import bg.softuni.phatfinder.model.DTOs.RouteShortIfoDTO;
import bg.softuni.phatfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model){
        List<RouteShortIfoDTO> allRoute = routeService.getAll();

        model.addAttribute("routes", allRoute);

        return "routes";
    }
}
