package com.example.kr.controllers;
import com.example.kr.entity.QuestEntity;
import com.example.kr.entity.UserEntity;
import com.example.kr.repositories.QuestRep;
import com.example.kr.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    UserRep userRep;
    @Autowired
    QuestRep questRep;
    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<UserEntity> users = userRep.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/quests")
    public String showQuests(Model model) {
        List<QuestEntity> quests  = questRep.findAllQuests();
        model.addAttribute("quests", quests);
        return "quests";
    }

}
