package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class TransferDetails {
	@Column(length=20)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="auto")
	@SequenceGenerator(name = "auto",sequenceName="sequence_2")
	private int transId;
	@Column(length=20)
	private long accNoFrom;
	@Column(length=20)
	private long accNoTo;
	@Column(length=20)
	private double transferAmt;
	@Column(length=20)
	private String transType;
	@Column(length=20)
	private String dateOfTrans;
	@Column(length=20)
	private double balance;
	
	
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public long getAccNoFrom() {
		return accNoFrom;
	}
	public void setAccNoFrom(long accNoFrom) {
		this.accNoFrom = accNoFrom;
	}
	public long getAccNoTo() {
		return accNoTo;
	}
	public void setAccNoTo(long accNoTo) {
		this.accNoTo = accNoTo;
	}
	public double getTransferAmt() {
		return transferAmt;
	}
	public void setTransferAmt(double transferAmt) {
		this.transferAmt = transferAmt;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getDateOfTrans() {
		return dateOfTrans;
	}
	public void setDateOfTrans(String dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public TransferDetails() {

	}
	public TransferDetails(int transId, long accNoFrom, long accNoTo, double transferAmt, String transType,
			String dateOfTrans, double balance) {
		super();
		this.transId = transId;
		this.accNoFrom = accNoFrom;
		this.accNoTo = accNoTo;
		this.transferAmt = transferAmt;
		this.transType = transType;
		this.dateOfTrans = dateOfTrans;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "TransferDetails [transId=" + transId + ", accNoFrom=" + accNoFrom + ", accNoTo=" + accNoTo
				+ ", transferAmt=" + transferAmt + ", transType=" + transType + ", dateOfTrans=" + dateOfTrans
				+ ", balance=" + balance + "]";
	}
}
