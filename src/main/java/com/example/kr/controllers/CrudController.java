package com.example.kr.controllers;

import com.example.kr.entity.QuestEntity;
import com.example.kr.entity.UserEntity;
import com.example.kr.repositories.QuestRep;
import com.example.kr.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    @Autowired
    UserRep userRep;

    @Autowired
    QuestRep questRep;

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserEntity user) {
        userRep.addUser(user);
    }

    @PostMapping("/addQuest")
    public void addQuest(@RequestBody QuestEntity quest) {
        questRep.addQuest(quest);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRep.deleteUserById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestParam(value = "userId", required = true) Long userId,
                                             @RequestParam(value = "authToken", required = true) String authToken,
                                             @RequestParam(value = "userName", required = true) String userName,
                                             @RequestParam(value = "positionOnStarship", required = true) String positionOnStarship,
                                             @RequestParam(value = "age", required = true) Integer age,
                                             @RequestParam(value = "sex", required = true) String sex,
                                             @RequestParam(value = "balance", required = true) Integer balance,
                                             @RequestParam(value = "background", required = true) String background,
                                             @RequestParam(value = "publicBackground", required = true) String publicBackground,
                                             @RequestParam(value = "photo", required = true) String photo,
                                             @RequestParam(value = "securityBackground", required = true) String securityBackground,
                                             @RequestParam(value = "medicalBackground", required = true) String medicalBackground,
                                             @RequestParam(value = "psychologyBackground", required = true) String psychologyBackground,
                                             @RequestParam(value = "lastAvailable", required = true) Integer lastAvailable,
                                             @RequestParam(value = "userSettings", required = true) Integer userSettings) {
        try {
            userRep.updateUserById(userId, authToken, userName, positionOnStarship, age, sex, balance, background, publicBackground, photo, securityBackground, medicalBackground, psychologyBackground, lastAvailable, userSettings);
            return ResponseEntity.ok("UserName updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating User.");
        }
    }

    @DeleteMapping("/deleteQuest/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable Integer id) {
        questRep.deleteQuestById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateQuest")
    public ResponseEntity<String> updateQuest(@RequestParam(value = "questId", required = true) Integer questId,
                                              @RequestParam(value = "questTitle", required = true) String questTitle,
                                              @RequestParam(value = "questText", required = true) String questText,
                                              @RequestParam(value = "personId", required = true) String personId,
                                              @RequestParam(value = "reward", required = true) Integer reward,
                                              @RequestParam(value = "penalty", required = true) Integer penalty,
                                              @RequestParam(value = "timeOfStarted", required = true) String timeOfStarted,
                                              @RequestParam(value = "timeForQuestInMinutes")Short timeForQuestInMinutes,
                                              @RequestParam(value = "placeId", required = true) String placeId,
                                              @RequestParam(value = "modelId", required = true) String modelId,
                                              @RequestParam(value = "levelDifficulty", required = true) Integer levelDifficulty,
                                              @RequestParam(value = "questStatus", required = true) String questStatus
    ) {try{
        questRep.updateQuestById(questId, questTitle, questText, personId, reward, penalty, timeOfStarted, timeForQuestInMinutes, placeId, modelId, levelDifficulty, questStatus);
        return ResponseEntity.ok("UserName updated successfully.");
    }catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating quest.");
    }
}
}