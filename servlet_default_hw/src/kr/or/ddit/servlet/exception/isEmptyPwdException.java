package kr.or.ddit.servlet.exception;

public class isEmptyPwdException extends Exception {
	public isEmptyPwdException() {
		super("비밀번호를 입력해주세요");
	}
}
