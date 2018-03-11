package com.fatserver.IncomingForms;

import com.fatserver.entity.Skill;

import java.util.List;

/**
 * Created by Victor on 17.02.2018.
 * Container for Incoming Skills
 */
public class SendSkillsForm {

    private List<IncomingSkill> skills;
    private Long userId;

    public SendSkillsForm() {
    }

    public SendSkillsForm(List<IncomingSkill> skills, Long userId) {
        this.skills = skills;
        this.userId = userId;
    }

    public List<IncomingSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<IncomingSkill> skills) {
        this.skills = skills;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
