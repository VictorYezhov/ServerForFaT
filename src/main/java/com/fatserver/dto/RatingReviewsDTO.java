package com.fatserver.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 16.05.2018.
 */
public class RatingReviewsDTO {

    private List<ReviewDTO> reviews;
    private int rating;

    public RatingReviewsDTO() {
        reviews = new ArrayList<>();
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
