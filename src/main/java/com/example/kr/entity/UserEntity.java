package com.example.kr.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;
    @Column(name = "authToken", columnDefinition = "TEXT", nullable = false)
    private String authToken;

    @Column(name = "userName", nullable = false, columnDefinition = "TEXT")
    private String userName;

    @Column(name = "positionOnStarship", nullable = false, columnDefinition = "TEXT")
    private String positionOnStarship;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "sex", nullable = false, columnDefinition = "TEXT")
    private String sex;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "background", nullable = false, columnDefinition = "TEXT")
    private String background;

    @Column(name = "publicBackground", nullable = false, columnDefinition = "TEXT")
    private String publicBackground;

    @Column(name = "photo", nullable = false, columnDefinition = "TEXT")
    private String photo;

    @Column(name = "securityBackground", nullable = false, columnDefinition = "TEXT")
    private String securityBackground;

    @Column(name = "medicalBackground", nullable = false, columnDefinition = "TEXT")
    private String medicalBackground;

    @Column(name = "psychologyBackground", nullable = false, columnDefinition = "TEXT")
    private String psychologyBackground;

    @Column(name = "lastAvailable")
    private Integer lastAvailable;

    @ColumnDefault("0")
    @Column(name = "userSettings", nullable = false)
    private Integer userSettings;
}
