package bg.softuni.phatfinder.web;

import bg.softuni.phatfinder.model.DTOs.UserRegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @GetMapping("user/register")
    public String viewRegister() {
        return "register";
    }

    @PostMapping("user/register")
    public String doRegister(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            //handle errors
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel"
                    , bindingResult);
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            return "redirect:user/register";
        }



        return "redirect:/user/login";
    }

    @GetMapping("user/login")
    public String viewLogin(){
        return "login";
    }
}
