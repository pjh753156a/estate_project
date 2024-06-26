package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 식당 정보 등록 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PostRestaurantInfoRequestDto 
{
    @NotBlank
    private String restaurantImage;
    @NotBlank
    private String restaurantName;
    @NotBlank
    private String restaurantFoodCategory;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String restaurantLocation;
    @NotBlank
    private String restaurantBusinessRegistrationNumber;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
    private String restaurantWriterId;
}
