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
@Table(name = "Friend")
public class Friend implements Serializable{
	private int id;
    private Account aid;
    private Account bid;
    private int status;
    
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
    @JoinColumn(name = "aid")
	public Account getAid() {
		return aid;
	}
	public void setAid(Account aid) {
		this.aid = aid;
	}
	
	@ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "bid")
	public Account getBid() {
		return bid;
	}
	public void setBid(Account bid) {
		this.bid = bid;
	}
	
	@Basic
    @Column(name = "status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
    
}
