package com.estate.back.service.implimentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estate.back.dto.request.board.PostBoardRequestDto;
import com.estate.back.dto.response.ResponseDto;
import com.estate.back.dto.response.board.GetBoardListResponseDto;
import com.estate.back.entity.BoardEntity;
import com.estate.back.repository.BoardRepository;
import com.estate.back.repository.UserRepository;
import com.estate.back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplementation implements BoardService
{
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto, String userId) 
    {
        try
        {
            boolean isExistUser = userRepository.existsByUserId(userId);
            if(!isExistUser) return ResponseDto.authenticationFailed();

            BoardEntity boardEntity = new BoardEntity(dto,userId);
            boardRepository.save(boardEntity);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() 
    {
        try
        {
            List<BoardEntity> boardEntities = boardRepository.findByOrderByReceptionNumberDesc();
            return GetBoardListResponseDto.success(boardEntities);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }
}
//???

// !!!복습시작
// 0. 클라이언트로부터 Authorization 헤더와 Request Body를 포함하여 요청
// 0.1 권한이 없는 사용자이면 'AF' 응답 처리 (403)
// 0.2 유효하지 않은 데이터이면 'VF' 응답 처리 (403)

// (title, contents), userId

// 1. 데이터베이스의 user 테이블에서 해당 유저가 존재하는지 확인
// 1.1 존재하지 않는 유저라면 'AF'응답 처리 (401)
// 1.2 데이터베이스 오류가 발생하면 'DBE' 응답 처리

// 2. Board 테이블에 데이터 삽입
// 2.1 데이터베이스 오류가 발생하면 'DBE'응답 처리

// 3. 'SU'응답 처리
// !!!복습완료