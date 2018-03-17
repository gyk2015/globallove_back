package com.mcii.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Integral")
public class Integral implements Serializable{
	private int id;
	private Account accountid;
	private int integral;
	
	 @Id
	 @Column(name = "id")
	 @GeneratedValue(generator = "increment")
	 @GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "accountid")
	public Account getAccountid() {
		return accountid;
	}
	public void setAccountid(Account accountid) {
		this.accountid = accountid;
	}
	
	@Basic
    @Column(name = "integral")
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	
}
