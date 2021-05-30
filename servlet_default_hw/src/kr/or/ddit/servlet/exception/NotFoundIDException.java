package kr.or.ddit.servlet.exception;

public class NotFoundIDException extends Exception {
	public NotFoundIDException() {
		super("Id가 존재하지 않습니다.");
	}
}
