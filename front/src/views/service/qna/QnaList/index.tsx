import { ChangeEvent, useEffect, useState } from 'react';
import { useCookies } from 'react-cookie';
import { useNavigate } from 'react-router';

import { usePagination } from 'src/hooks';
import { useUserStore } from 'src/stores';

import { GetSearchBoardListResponseDto } from 'src/apis/board/dto/response';
import ResponseDto from 'src/apis/response.dto';
import { BoardListItem } from 'src/types';

import { getSearchBoardListRequest } from 'src/apis/board';

import { AUTH_ABSOLUTE_PATH, COUNT_PER_PAGE, COUNT_PER_SECTION, QNA_DEATIL_ABSOLUTE_PATH, QNA_WRITE_ABSOLUTE_PATH } from 'src/constant';

import './style.css';

//                    component                    //
function ListItem ({
    receptionNumber,
    status,
    title,
    writerId,
    writeDatetime,
    viewCount
}: BoardListItem) {

    //                    function                    //
    const navigator = useNavigate();
    
    //                    event handler                    //
    const onClickHandler = () => navigator(QNA_DEATIL_ABSOLUTE_PATH(receptionNumber));
    
    //                    render                    //
    return (
        <div className='qna-list-table-tr' onClick={onClickHandler}>
            <div className='qna-list-table-reception-number'>{receptionNumber}</div>
            <div className='qna-list-table-status'>
                {status ?
                <div className='disable-bedge'>완료</div> :
                <div className='primary-bedge'>접수</div>
                }
            </div>
            <div className='qna-list-table-title' style={{ textAlign: 'left' }}>{title}</div>
            <div className='qna-list-table-writer-id'>{writerId}</div>
            <div className='qna-list-table-write-date'>{writeDatetime}</div>
            <div className='qna-list-table-viewcount'>{viewCount}</div>
        </div>
    );
}

//                    component                    //
export default function QnaList() 
{
    //                    state                    //
    const {loginUserRole} = useUserStore();

    const{
        viewList,
        pageList,
        totalPage,
        currentPage,
        totalLenght,
        setCurrentPage,
        setCurrentSection,
        changeBoardList,
        onPageClickHandler,
        onPreSectionClickHandler,
        onNextSectionClickHandler
    } = usePagination<BoardListItem>(COUNT_PER_PAGE, COUNT_PER_SECTION);

    const [cookies] = useCookies();
    const [searchWord, setSearchWord] = useState<string>('');
    const [isToggleOn, setToggleOn] = useState<boolean>(false);

    //                    function                    //
    const navigator = useNavigate();
    
    const getSearchBoardListResponse = (result: GetSearchBoardListResponseDto | ResponseDto | null) => {

        const message =
            !result ? '서버에 문제가 있습니다.' :
            result.code === 'VF' ? '검색어를 입력하세요.' :
            result.code === 'AF' ? '인증에 실패했습니다.' :
            result.code === 'DBE' ? '서버에 문제가 있습니다.' : '';

        if (!result || result.code !== 'SU') {
            alert(message);
            if (result?.code === 'AF') navigator(AUTH_ABSOLUTE_PATH);
            return;
        }

        const { boardList } = result as GetSearchBoardListResponseDto;
        changeBoardList(boardList, isToggleOn);
        setCurrentPage(!boardList.length ? 0 : 1);
        setCurrentSection(!boardList.length ? 0 : 1);
    };
    
    //                event handler                    //
    const onWriteButtonClickHandler = () => 
    {
        if (loginUserRole !== 'ROLE_USER') return;
        navigator(QNA_WRITE_ABSOLUTE_PATH);
    };
    
    const onToggleClickHandler = () => 
    {
        if (loginUserRole !== 'ROLE_ADMIN') return;
        setToggleOn(!isToggleOn);
    };
    
    const onSearchWordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => 
    {
        const searchWord = event.target.value;
        setSearchWord(searchWord);
    };

    const onSearchButtonClickHandler = () => 
    {
        if (!searchWord) return;
        if (!cookies.accessToken) return;

        getSearchBoardListRequest(searchWord, cookies.accessToken).then(getSearchBoardListResponse);
    };
    
    //                    effect                    //
    useEffect(() => {
        if (!cookies.accessToken) return;
        getSearchBoardListRequest(searchWord,cookies.accessToken).then(getSearchBoardListResponse);
    }, [isToggleOn]);
    
    //                    render                    //
    const toggleClass = isToggleOn ? 'toggle-active' : 'toggle';
    const searchButtonClass = searchWord ? 'primary-button' : 'disable-button';
    
    return (
        <div id='qna-list-wrapper'>
            <div className='qna-list-top'>
                <div className='qna-list-size-text'>전체 <span className='emphasis'>{totalLenght}건</span> | 페이지 <span className='emphasis'>{currentPage}/{totalPage}</span></div>
                <div className='qna-list-top-right'>
                    {loginUserRole === 'ROLE_USER' ?
                    <div className='primary-button' onClick={onWriteButtonClickHandler}>글쓰기</div> :
                    <>
                    <div className={toggleClass} onClick={onToggleClickHandler}></div>
                    <div className='qna-list-top-admin-text'>미완료 보기</div>
                    </>
                    }
                </div>
            </div>
            <div className='qna-list-table'>
                <div className='qna-list-table-th'>
                    <div className='qna-list-table-reception-number'>접수번호</div>
                    <div className='qna-list-table-status'>상태</div>
                    <div className='qna-list-table-title'>제목</div>
                    <div className='qna-list-table-writer-id'>작성자</div>
                    <div className='qna-list-table-write-date'>작성일</div>
                    <div className='qna-list-table-viewcount'>조회수</div>
                </div>
                {viewList.map(item => <ListItem {...item} />)}
            </div>
            <div className='qna-list-bottom'>
                <div style={{ width: '299px' }}></div>
                <div className='qna-list-pagenation'>
                    <div className='qna-list-page-left' onClick={onPreSectionClickHandler}></div>
                    <div className='qna-list-page-box'>
                        {pageList.map(page =>
                        page === currentPage ?
                        <div className='qna-list-page-active'>{page}</div> :
                        <div className='qna-list-page' onClick={() => onPageClickHandler(page)}>{page}</div>
                        )}
                    </div>
                    <div className='qna-list-page-right' onClick={onNextSectionClickHandler}></div>
                </div>
                <div className='qna-list-search-box'>
                    <div className='qna-list-search-input-box'>
                        <input className='qna-list-search-input' placeholder='검색어를 입력하세요.' value={searchWord} onChange={onSearchWordChangeHandler} />
                    </div>
                    <div className={searchButtonClass} onClick={onSearchButtonClickHandler}>검색</div>
                </div>
            </div>
        </div>
    );
}
{/* 최종완료 */}