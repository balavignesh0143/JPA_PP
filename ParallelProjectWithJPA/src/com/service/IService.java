package com.service;

import java.util.List;

public interface IService{
	public int createAccount(String name, long mblNo, int accNo, double balance);
	public double showBalance(int accNo);
	public double depositBalance(int accNo, double balance);
	public double withdrawBalance(int accNo,double balance);
	public double validationBal(double balance);
	public String validationName(String name);
	public long validationMblNo(long mblNo);
	public double fundTransfer(int accNo, int accNo1, double balance);
	public List<?> printTransactions(int accNo);

}
