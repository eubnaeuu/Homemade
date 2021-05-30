package kr.or.ddit.servlet.exception;

public class isEmptyIdException extends Exception {
	public isEmptyIdException() {
		super("ID를 입력해주세요");
	}
}
