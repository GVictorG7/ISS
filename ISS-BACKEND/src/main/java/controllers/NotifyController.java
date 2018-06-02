package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.INotifyService;

@RestController
@RequestMapping("/notifyall")
public class NotifyController {
    private final INotifyService notifyService;

    @Autowired
    public NotifyController(INotifyService notifyService) {
        this.notifyService = notifyService;
    }

    @PostMapping
    public void notifyUsers(@RequestBody String[] users) {
        new Thread(() -> {
            notifyService.sendMailToUsers(users);
        }).start();
    }
}
