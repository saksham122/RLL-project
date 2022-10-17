package com.foodbox.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Purchase {
	@Id
	private long id;
	private float totalcost;
	private Date dop;
	private int quantity;
	private String foodname;
	private String transactionid;
	@OneToOne
	private signup su;
	
	public Purchase() {
		super();
	}

	public Purchase(long id, float totalcost, Date dop, int quantity, String foodname, String transactionid,
			signup su) {
		super();
		this.id = id;
		this.totalcost = totalcost;
		this.dop = dop;
		this.quantity = quantity;
		this.foodname = foodname;
		this.transactionid = transactionid;
		this.su = su;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(float totalcost) {
		this.totalcost = totalcost;
	}

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductname() {
		return foodname;
	}

	public void setProductname(String foodname) {
		this.foodname = foodname;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public signup getSu() {
		return su;
	}

	public void setSu(signup su) {
		this.su = su;
	}

	
}
