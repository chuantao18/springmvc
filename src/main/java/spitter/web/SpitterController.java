package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spitter.Spitter;
import spitter.data.JdbcSpitterRepository;
import spitter.data.SpitterRepository;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

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
    public String processRegisration(@Valid Spitter spitter, Errors errors,
                                     @RequestPart("profilePicture") MultipartFile profilePicture, RedirectAttributes model) throws IOException {
        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
        profilePicture.transferTo(new File("E:\\learn-test\\java\\spitter\\"+spitter.getUsername()+".jpg"));
        //Model传输数据
        model.addAttribute("username",spitter.getUsername());
        //return "redirect:/spitter/"+spitter.getUsername();
        model.addAttribute("spittleId",spitter.getId());
        //使用flash属性
        model.addFlashAttribute("spitter",spitter);
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUserName(username);
        if(!model.containsAttribute("spitter")){
            model.addAttribute(spitterRepository.findByUserName(username));
        }
        return "profile";
    }
}
