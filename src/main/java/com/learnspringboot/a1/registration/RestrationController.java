package com.learnspringboot.a1.registration;

import com.learnspringboot.a1.event.RegistrationCompleteEvent;
import com.learnspringboot.a1.user.IUserService;
import com.learnspringboot.a1.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RestrationController {
    private final IUserService userService;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationRequest registrationRequest){
        User user = userService.registerUser(registrationRequest);
        eventPublisher.publishEvent(new RegistrationCompleteEvent(user,""));
        return "redirect:/registration/registration-form?success";
    }
}
