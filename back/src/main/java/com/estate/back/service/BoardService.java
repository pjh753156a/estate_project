package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.request.board.PostCommentRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.dto.response.board.GetBoardResponseDto;
import com.estate.back.dto.response.board.GetSearchBoardListResponseDto;

public interface BoardService
{
    ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId);
    //??? 
    ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, int receptionNumber);
    //???
     
    ResponseEntity<? super GetBoardListResponseDto> getBoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord);
    //!!!복습시작
    ResponseEntity<? super GetBoardResponseDto> getBoard(int receptionNumber);
    //!!!복습완료
    ResponseEntity<ResponseDto> increaseViewCount(int receptionNumber);
    //???
}

