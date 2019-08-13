package com.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(String msg)
	{
		super(msg);
	}
	public AccountNotFoundException(String msg,Throwable ex)
	{
		super(msg,ex);
	}
}
