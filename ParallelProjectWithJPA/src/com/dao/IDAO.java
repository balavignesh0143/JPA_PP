package com.dao;

import java.util.List;

import com.bean.UserDetails;

public interface IDAO {

	int createAccount(UserDetails ud);

	double showBalance(int accNo);

	double depositBalance(int accNo, double balance);

	double withdrawBalance(int accNo, double balance);

	double fundTransfer(int accNo, int accNo1, double balance);

	List<?> printTransactions(int accNo);



}
