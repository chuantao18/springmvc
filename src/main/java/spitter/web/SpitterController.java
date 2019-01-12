package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spitter.Spitter;
import spitter.data.JdbcSpitterRepository;
import spitter.data.SpitterRepository;

import javax.validation.Valid;

@Component
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegisterForm( Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String processRegisration(Spitter spitter){
//        spitterRepository.save(spitter);
//        return "redirect:/spitter/"+spitter.getUsername();
//    }

    /*
        开始注解参数校验
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegisration(@Valid Spitter spitter, Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUserName(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
