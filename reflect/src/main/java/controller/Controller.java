package controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.Service;

public class Controller {

    @Autowired
    private Service userService;

    public Service getUserService() {
        return userService;
    }

    public void setUserService(Service userService) {
        this.userService = userService;
    }
}
