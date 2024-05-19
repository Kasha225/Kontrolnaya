package com.example.kr.repositories;
import com.example.kr.entity.QuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuestRep extends JpaRepository<QuestEntity, Integer>{
    @Query(value = "SELECT questTitle as quest_title, questText as quest_text, personId as person_id, reward, penalty, timeOfStarted as time_of_started, timeForQuestInMinutes as time_for_quest_in_minutes, placeId as place_id, modelId as model_id, levelDifficulty as level_difficulty, questStatus as quest_status, questId as quest_id FROM quests", nativeQuery = true)
    List<QuestEntity> findAllQuests();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO quests (questTitle, questText, personId, reward, penalty, timeOfStarted, timeForQuestInMinutes, placeId, modelId, levelDifficulty, questStatus) " + "VALUES (:#{#quest.questTitle}, :#{#quest.questText}, :#{#quest.personId}, :#{#quest.reward}, :#{#quest.penalty}, :#{#quest.timeOfStarted}, :#{#quest.timeForQuestInMinutes}, :#{#quest.placeId}, :#{#quest.modelId}, :#{#quest.levelDifficulty}, :#{#quest.questStatus})", nativeQuery = true)
    void addQuest(@RequestBody QuestEntity quest);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM quests WHERE questId = :questId", nativeQuery = true)
    void deleteQuestById(@Param("questId") Integer questId);
    @Modifying
    @Transactional
    @Query(value ="UPDATE quests SET questTitle= :questTitle, questText= :questText, personId= :personId, reward= :reward, penalty= :penalty, timeOfStarted= :timeOfStarted, timeForQuestInMinutes= :timeForQuestInMinutes, placeId= :placeId, modelId= :modelId, levelDifficulty= :levelDifficulty, questStatus= :questStatus WHERE questId = :questId", nativeQuery = true)
    void updateQuestById(@Param("questId") Integer questId,
                         @Param("questTitle") String questTitle,
                         @Param("questText") String questText,
                         @Param("personId") String personId,
                         @Param("reward") Integer reward,
                         @Param("penalty") Integer penalty,
                         @Param("timeOfStarted") String timeOfStarted,
                         @Param("timeForQuestInMinutes") Short timeForQuestInMinutes,
                         @Param("placeId") String placeId,
                         @Param("modelId") String modelId,
                         @Param("levelDifficulty") Integer levelDifficulty,
                         @Param("questStatus") String questStatus);
}

