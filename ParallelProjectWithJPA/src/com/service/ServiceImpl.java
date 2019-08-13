package com.service;

import java.util.List;
import java.util.Scanner;
import com.bean.UserDetails;
import com.dao.DAOImpl;
import com.dao.IDAO;

public class ServiceImpl implements IService {
	Scanner scanner = new Scanner(System.in);
	UserDetails details = new UserDetails();
	IDAO d = new DAOImpl();

	public int createAccount(String name, long mblNo, int accNo, double balance) {
		UserDetails details = new UserDetails();

		details.setName(name);
		details.setBalance(balance);
		details.setAccNo(accNo);
		details.setMblNo(mblNo);
		return d.createAccount(details);
	}

	@Override
	public double showBalance(int accNo) {
		double acc = d.showBalance(accNo);
		return acc;
	}

	public double depositBalance(int accNo, double balance) {
		double acc = d.depositBalance(accNo, balance);
		return acc;
	}

	public double withdrawBalance(int accNo, double balance) {
		double acc = d.withdrawBalance(accNo, balance);
		return acc;
	}

	public double fundTransfer(int accNo, int accNo1, double balance) {
		double acc = d.fundTransfer(accNo, accNo1, balance);
		return acc;
	}

	public double validationBal(double balance) {
		while (true) {
			if (balance <= 0) {
				System.out.println("Amount is lesser than zero...");
				System.out.println("Enter the amount again: ");
				balance = (long) scanner.nextDouble();
			} else {
				return balance;
			}
		}
	}

	public String validationName(String name) {
		if (name.matches("[A-Z][a-zA-Z]*"))
			return name;
		else
			System.out.println("Enter valid name: ");
		return name = scanner.next();
	}

	public long validationMblNo(long mblNo) {
		while (true) {
			if (String.valueOf(mblNo).length() == 10) {
				return mblNo;
			} else {
				System.out.println("Enter the valid mobile number: ");
				mblNo = scanner.nextLong();
			}
		}
	}

	@Override
	public List<?> printTransactions(int accNo) {
		return d.printTransactions(accNo);
	}
	
	/*
	@Override
	public String getTransaction(long accNo) {
		String str = d.getTransaction(accNo);
		return str;
	}
	
	@Override
	public void setBalance(long accNo, double bal, String str)  {
		d.setBalance(accNo, bal, str);
	}
	*/



}
