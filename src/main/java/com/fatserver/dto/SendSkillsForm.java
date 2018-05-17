package com.fatserver.dto;

import java.util.List;

/**
 * Created by Victor on 17.02.2018.
 * Container for Incoming Skills
 */
public class SendSkillsForm {

    private List<SkillDTO> skills;
    private Long userId;

    public SendSkillsForm() {
    }

    public SendSkillsForm(List<SkillDTO> skills, Long userId) {
        this.skills = skills;
        this.userId = userId;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
