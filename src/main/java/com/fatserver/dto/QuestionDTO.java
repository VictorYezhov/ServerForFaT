package com.fatserver.dto;

import java.sql.Timestamp;
import java.util.Set;

public class QuestionDTO {
    private Long id;
    private String title;
    private String discription;
    private Integer price;
    private Timestamp dateTime;
    private Set<SkillDTO> skills;
    private Integer views;
    private CategotryDTO category;


    public QuestionDTO(){
        this.id = null;
        this.title = "Title";
        this.dateTime = getDateTime();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Set<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDTO> skills) {
        this.skills = skills;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public CategotryDTO getCategory() {
        return category;
    }

    public void setCategory(CategotryDTO categotryDTO) {
        this.category = categotryDTO;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

}
