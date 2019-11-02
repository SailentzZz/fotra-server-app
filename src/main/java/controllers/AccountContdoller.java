package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import database.entities.UserForum;
import database.repositories.UserForumRepository;

@RestController
@RequestMapping(value = "/account")
public class AccountContdoller {

    @Autowired
    private UserForumRepository userForumRepository;

    @GetMapping("/")
    public String getUser() {
        UserForum userForum = userForumRepository.findById(1).get();
        return userForum.toString();
    }

}
