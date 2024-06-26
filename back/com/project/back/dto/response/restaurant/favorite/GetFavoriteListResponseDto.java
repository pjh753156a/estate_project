package com.project.back.dto.response.restaurant.favorite;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.back.common.object.restaurant.RestaurantListItem;
import com.project.back.dto.response.ResponseCode;
import com.project.back.dto.response.ResponseDto;
import com.project.back.dto.response.ResponseMessage;
import com.project.back.entity.FavoriteRestaurantEntity;
import com.project.back.entity.RestaurantEntity;

//  찜(저장)한 식당 내역 목록 확인 Response Body DTO
public class GetFavoriteListResponseDto extends ResponseDto{
    private String favoriteUserId;
    private Integer favoriteRestaurantId;
    private List<RestaurantListItem> restaurantList;
    
    private GetFavoriteListResponseDto(FavoriteRestaurantEntity favoriteRestaurantEntity, List<RestaurantEntity> restaurantEntities) throws Exception {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        String writerId = favoriteRestaurantEntity.getFavoriteUserId();
        writerId = writerId.substring(0, 1) +
        "*".repeat(writerId.length() - 1); 
        this.favoriteUserId = writerId;
        this.favoriteRestaurantId = favoriteRestaurantEntity.getFavoriteRestaurantId();
        this.restaurantList = RestaurantListItem.getList(restaurantEntities);
    }

    public static ResponseEntity<GetFavoriteListResponseDto> success(FavoriteRestaurantEntity favoriteRestaurantEntity,List<RestaurantEntity> restaurantEntities)
    throws Exception {
        GetFavoriteListResponseDto responseBody = new GetFavoriteListResponseDto(favoriteRestaurantEntity,restaurantEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
