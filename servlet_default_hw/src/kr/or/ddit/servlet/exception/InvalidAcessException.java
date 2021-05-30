package kr.or.ddit.servlet.exception;

public class InvalidAcessException extends Exception {
	public InvalidAcessException() {
		super("잘못된 접근입니다");
	}
}
