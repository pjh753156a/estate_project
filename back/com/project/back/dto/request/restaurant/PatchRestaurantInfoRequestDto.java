package com.project.back.dto.request.restaurant;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//식당 정보 수정 Request Body Dto
@Getter
@Setter
@NoArgsConstructor
public class PatchRestaurantInfoRequestDto{
    @NotBlank
    private String restaurantName;
    @NotBlank
    private String restaurantFoodCategory;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String restaurantLocation;
    @NotBlank
    private String restaurantId;
    @NotBlank
    private String restaurantImage;
    private String restaurantTelNumber;
    private String restaurantSnsAddress;
    private String restaurantOperationHours;
    private String restaurantFeatures;
    private String restaurantNotice;
    private String restaurantRepresentativeMenu;
    @NotBlank
    private String restaurantBusinessRegistrationNumber;
}
