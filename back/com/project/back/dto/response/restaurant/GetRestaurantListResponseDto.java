package com.project.back.dto.response.restaurant;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.RestaurantListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.RestaurantEntity;

// 식당 목록 검색 Response Body DTO
public class GetRestaurantListResponseDto extends ResponseDto {
    private List<RestaurantListItem> restaurantList;
    
    private GetRestaurantListResponseDto(List<RestaurantEntity> restaurantEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.restaurantList = RestaurantListItem.getList(restaurantEntities);
    }

    public static ResponseEntity<GetRestaurantListResponseDto> success(List<RestaurantEntity> restaurantEntities)
    throws Exception {
        GetRestaurantListResponseDto responseBody = new GetRestaurantListResponseDto(restaurantEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}



