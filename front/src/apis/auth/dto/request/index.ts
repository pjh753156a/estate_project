// description: 로그인 Request Body Dto
export interface SignInRequestDto
{
    userId: string;
    userPassword: string;
}

// description: 아이디 중복 확인 Request Body Dto
export interface IdCheckRequestDto
{
    userId: string;
}

// description: 이메일 인증 Request Body Dto
export interface EmailAuthRequestDto
{
    userEmail: string;
}

// description: 이메일 인증 확인 Request Body Dto
export interface EmailAuthCheckRequestDto
{
    userEmail: string;
    authNumber: string;
}

// description: 회원가입 Request Body Dto
export interface SignUpRequestDto
{
    userId: string;
    userPassword: string;
    userEmail: string;
    authNumber: string;
}
/* 최종완료 */