package com.ats.exceptns;

public class MailSendingIssueException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MailSendingIssueException() {
	
	}
	
	public MailSendingIssueException(String msg) {
		super(msg);
	}
	
}
