package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int nastyCount;
    private int tastyCount;
    private String imageUrl;

    public String getEmptyString() {
        return emptyString;
    }

    public void setEmptyString(String emptyString) {
        this.emptyString = emptyString;
    }

    private int isTasty;
    private String foodDiscripn;
    private String emptyString=" ";

    public String getTastyFood() {
        return tastyFood;
    }

    public String getNastyFood() {
        return nastyFood;
    }

    private final String tastyFood="Tasty";
    private final String nastyFood="Nasty";
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodDiscripn() {
        return foodDiscripn;
    }

    public void setFoodDiscripn(String foodDiscripn) {
        this.foodDiscripn = foodDiscripn;
    }

    public int getTastyCount() {
        return tastyCount;
    }

    public int getIsTasty() {
        return isTasty;
    }

    public void setIsTasty(int isTasty) {
        this.isTasty = isTasty;
    }

    public void setTastyCount(int tastyCount) {
        this.tastyCount = tastyCount;
    }

    public int getNastyCount() {
        return nastyCount;
    }

    public void setNastyCount(int nastyCount) {
        this.nastyCount = nastyCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}
