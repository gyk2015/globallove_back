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
@Table(name = "AccountFamily")
public class AccountFamily  implements Serializable{
	private int id;
    private Account accountid;
    private String parents;
    private String onlychild;
    private String child;
    
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
    @Column(name = "parents")
	public String getParents() {
		return parents;
	}
	public void setParents(String parents) {
		this.parents = parents;
	}
	
	@Basic
    @Column(name = "onlychild")
	public String getOnlychild() {
		return onlychild;
	}
	public void setOnlychild(String onlychild) {
		this.onlychild = onlychild;
	}
	
	@Basic
    @Column(name = "child")
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
    
}
