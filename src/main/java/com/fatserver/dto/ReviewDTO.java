package com.fatserver.dto;

import com.fatserver.entity.Review;

/**
 * Created by Victor on 16.05.2018.
 */
public class ReviewDTO {


    private Long id;
    private String review;
    private Long about;
    private Long from;
    private boolean anonymous;

    public ReviewDTO(Review review) {
        id = review.getId();
        this.review = review.getReview();
        about = review.getAbout().getId();
        from = review.getFrom().getId();
        anonymous = review.isAnonymous();
    }

    public ReviewDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getAbout() {
        return about;
    }

    public void setAbout(Long about) {
        this.about = about;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
}
