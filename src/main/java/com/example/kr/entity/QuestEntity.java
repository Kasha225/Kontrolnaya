package com.example.kr.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "quests")
public class QuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questId", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "questTitle", nullable = false)
    private String questTitle;

    @Lob
    @Column(name = "questText", nullable = false)
    private String questText;

    @Lob
    @Column(name = "personId")
    private String personId;

    @ColumnDefault("0")
    @Column(name = "reward", nullable = false)
    private Integer reward;

    @ColumnDefault("0")
    @Column(name = "penalty", nullable = false)
    private Integer penalty;

    @Column(name = "timeOfStarted", nullable = false)
    private String timeOfStarted;

    @Column(name = "timeForQuestInMinutes", nullable = false)
    private Short timeForQuestInMinutes;

    @Lob
    @Column(name = "placeId")
    private String placeId;

    @Lob
    @Column(name = "modelId")
    private String modelId;

    @ColumnDefault("10")
    @Column(name = "levelDifficulty", nullable = false)
    private Integer levelDifficulty;

    @ColumnDefault("CREATED")
    @Lob
    @Column(name = "questStatus", nullable = false)
    private String questStatus;
}
