package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.dto.response.board.GetSearchBoardListResponseDto;

public interface BoardService
{
    ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId);
    ResponseEntity<? super GetBoardListResponseDto> getBoardList();
    //!!!복습시작
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord);
    //!!!복습완료
}

