package com.project.back.repository.resultSet;

public interface GetRestaurantReviewListItemResultSet {
    Integer getReviewNumber();
    Integer getReviewRestaurantId();
    String getReviewImage();
    Double getRating();
    String getReviewContents();
    String getReviewWriterId();
    String getReviewDate();
    String getNickname();
}
