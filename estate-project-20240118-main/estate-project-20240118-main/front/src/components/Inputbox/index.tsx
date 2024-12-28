import { ChangeEvent, KeyboardEvent } from "react";
import './style.css';

export interface InputBoxProps 
{
    label: string;
    value: string;
    error?: boolean;
    message?: string;
    placeholder: string;
    buttonTitle?: string;
    buttonStatus?: boolean;
    type: 'text' | 'password';
    onButtonClickHandler?: () => void;
    onChangeHandler: (event: ChangeEvent<HTMLInputElement>) => void;
    onKeydownHandler?:(event:KeyboardEvent<HTMLInputElement>) => void;
}

export default function InputBox({ label, type, value, placeholder, onChangeHandler, buttonTitle, buttonStatus, onButtonClickHandler, message, error,onKeydownHandler }: InputBoxProps) 
{
// <InputBox label="비밀번호" type="password" 
// value={password} placeholder="비밀번호를 입력해주세요" 
// onKeydownHandler={onPasswordKeydownHandler}
// onChangeHandler={onPasswordChangeHandler} message={message} error />

    const buttonClass = buttonStatus ? 'input-primary-button' : 'input-disable-button';
    const messageClass = 'input-message ' + (error ? 'error' : 'primary');

    return (
        <div className="input-box">
            <div className="input-label label">{label}</div>
            <div className="input-content-box">
                <input
                    className="input"
                    type={type}
                    value={value}
                    placeholder={placeholder}
                    onChange={onChangeHandler}
                    onKeyDown={onKeydownHandler}
                />
                { buttonTitle &&
                <div className={buttonClass} onClick={onButtonClickHandler}>
                    {buttonTitle}
                </div>
                }
            </div>
            <div className={messageClass}>
                {message}
            </div>
        </div>
    );
}
{/* /* 예습 */}