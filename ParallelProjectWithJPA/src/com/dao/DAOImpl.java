package com.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bean.TransferDetails;
import com.bean.UserDetails;
import com.service.ServiceImpl;

public class DAOImpl implements IDAO {
	UserDetails details = new UserDetails();
	ServiceImpl service;
	EntityManager em;
	DB db = new DB();

	public int createAccount(UserDetails details) {
		em = db.getConnection();
		em.getTransaction().begin();
		em.persist(details);
		em.getTransaction().commit();
		return details.getAccNo();
	}

	@Override
	public double showBalance(int accNo) {
		em = db.getConnection();
		em.getTransaction().begin();
		details = em.find(UserDetails.class, accNo);
		em.getTransaction().commit();
		return details.getBalance();
	}

	public double depositBalance(int accNo, double balance) {
		em = db.getConnection();
		em.getTransaction().begin();
		details = em.find(UserDetails.class, accNo);
		if (details == null) {
			System.out.println("Invalid");
		} else {
			double originalBal = details.getBalance();
			double mainBal = originalBal + balance;
			Query query = em.createQuery("update Details d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
			query.setParameter("mainBal_1", mainBal);
			query.setParameter("accNo_1", accNo);
			query.executeUpdate();

			TransferDetails td = new TransferDetails();
			td.setAccNoFrom(accNo);
			td.setTransferAmt(balance);
			td.setTransType("deposit");
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			td.setDateOfTrans(dt.format(now));

			/*Query query_1 = em.createQuery("update TransferDetails d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
			query_1.setParameter("mainBal_1", mainBal);
			query_1.setParameter("accNo_1", accNo);
			query_1.executeUpdate();*/

			em.persist(td);
		}
		em.getTransaction().commit();
		return details.getBalance();
	}

	public double withdrawBalance(int accNo, double balance) {
		em = db.getConnection();
		em.getTransaction().begin();
		details = em.find(UserDetails.class, accNo);
		if (details == null) {
			System.out.println("Invalid");
		} else {
			double originalBal = details.getBalance();
			double mainBal = originalBal - balance;
			Query query = em.createQuery("update Details d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
			query.setParameter("mainBal_1", mainBal);
			query.setParameter("accNo_1", accNo);
			query.executeUpdate();

			TransferDetails td = new TransferDetails();
			td.setAccNoFrom(accNo);
			td.setTransferAmt(balance);
			td.setTransType("deposit");
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			td.setDateOfTrans(dt.format(now));
			em.persist(td);
			/*
			 * Query query_1 = em.
			 * createQuery("update TransferDetails d set d.balance=:mainBal_1 where d.accNo=:accNo_1"
			 * ); query_1.setParameter("mainBal_1", mainBal);
			 * query_1.setParameter("accNo_1", accNo); query_1.executeUpdate();
			 */
			
		}
		em.getTransaction().commit();
		return details.getBalance();
	}

	public double fundTransfer(int accNo, int accNo1, double balance) {

		em = db.getConnection();
		em.getTransaction().begin();
		details = em.find(UserDetails.class, accNo);
		if (details == null) {
			System.out.println("Invalid");
		} else {
			double originalBal = details.getBalance();
			double mainBal = originalBal - balance;
			Query query = em.createQuery("update Details d set d.balance=:mainBal where d.accNo=:accNo");
			query.setParameter("mainBal", mainBal);
			query.setParameter("accNo", accNo);
			query.executeUpdate();
			
			TransferDetails td = new TransferDetails();
			td.setAccNoFrom(accNo);
			td.setTransferAmt(balance);
			td.setTransType("deposit");
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			td.setDateOfTrans(dt.format(now));
			em.persist(td);
			
			if (details == null) {
				System.out.println("Invalid");
			} else {
				details = em.find(UserDetails.class, accNo1);
				double originalBal_1 = details.getBalance();
				double mainBal_1 = originalBal_1 + balance;
				Query query_1 = em.createQuery("update Details d set d.balance=:mainBal_1 where d.accNo=:accNo_1");
				query_1.setParameter("mainBal_1", mainBal_1);
				query_1.setParameter("accNo_1", accNo1);
				query_1.executeUpdate();
				
				TransferDetails td_1 = new TransferDetails();
				td_1.setAccNoFrom(accNo);
				td_1.setTransferAmt(balance);
				td_1.setTransType("deposit");
				DateTimeFormatter dt_1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDateTime now_1 = LocalDateTime.now();
				td_1.setDateOfTrans(dt_1.format(now_1));
				em.persist(td_1);
			}
		}
		em.getTransaction().commit();
		return details.getBalance();
	}

	/*@Override
	public List<?> printTransactions(int accNo) {
		em=db.getConnection();
		em.getTransaction().begin();
		details=em.find(UserDetails.class,accNo);
		
		Query query=em.createQuery("select t from TransferDetails t where accNo=:accNo");
		query.setParameter("accNo",accNo);
		@SuppressWarnings("unchecked")
		List<TransferDetails> transfer=query.getResultList();
		query.executeUpdate();
		
		
		TransferDetails td=new TransferDetails();
		//td.getTransId();
		td.getTransType();
		td.getAccNoFrom();
		td.getAccNoTo();
		td.getBalance();
		td.getDateOfTrans();
		td.getTransferAmt();
		
		Set s=new HashSet();
		s.add(td);
		em.persist(details);
		
		details.setChildren(s);
		em.getTransaction().commit();
		return null;		
		
	}*/
	
	/*
	public String getTransaction(int accNo)
	{
		em=db.getConnection();
		em.getConnection().begin();
		UserDetails details=em.find(UserDetails.class,accNo);
		em.getConnection().commit();
		return details.getTran();
	}
	
	@Override
	public void setBalance(int accNo, double balance, String str){
		em = db.getConnection();
		em.getTransaction().begin();
		UserDetails details=(UserDetails) em.find(UserDetails.class,new Int(accNo));	
		String str = details.getTran() + str;
		details.setTran(str);
		details.setBalance(balance);
		em.merge(details);
		em.getTransaction().commit();
	}
	*/

}