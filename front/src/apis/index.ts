import { AxiosResponse } from "axios";
import ResponseDto from "./response.dto";

// !!!복습시작
// function : Request 처리 함수
export const requestHandler = <T>(response:AxiosResponse<T,any> )=> 
{
    const responseBody = response.data;
    return responseBody;
};
//!!!복습완료

//!!!복습시작
// function : Request Error 처리 함수
export const requestErrorHandler = (error:any) => 
{
        const responseBody = error.response?.data;
        if(!responseBody) return null;
        return responseBody as ResponseDto;
    
};
//!!!복습완료