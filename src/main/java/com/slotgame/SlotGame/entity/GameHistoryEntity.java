package com.slotgame.SlotGame.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name ="game_history")
public class GameHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "history_id")
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  // Cascade silme işlemi
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private GameEntity game;

    @Column(nullable = false,name= "play_date")
    private LocalDateTime playDate;

    private BigDecimal winamount;

    public BigDecimal getWinamount() {
        return winamount;
    }

    public void setWinamount(BigDecimal winamount) {
        this.winamount = winamount;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public UserEntity getUser() {
        return user;
    }

    public GameEntity getGame() {
        return game;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public void setPlayDate(LocalDateTime playDate) {
        this.playDate = playDate;
    }
}