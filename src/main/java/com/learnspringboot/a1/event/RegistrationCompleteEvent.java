package com.learnspringboot.a1.event;

import com.learnspringboot.a1.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String comfirmationUrl;
    public RegistrationCompleteEvent(User user, String comfirmationUrl) {
        super(user);
        this.user = user;
        this.comfirmationUrl = comfirmationUrl;
    }
}
