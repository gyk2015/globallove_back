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
@Table(name = "AccountLifeHabit")
public class AccountLifeHabit implements Serializable{
	private int id;
    private Account accountid;
    private String smoking;
    private String drink;
    private String life;
    private String housework;
    private String pet;
    private String deposit;
    
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
    @Column(name = "smoking")
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	
	@Basic
    @Column(name = "drink")
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	
	@Basic
    @Column(name = "life")
	public String getLife() {
		return life;
	}
	public void setLife(String life) {
		this.life = life;
	}
	
	@Basic
    @Column(name = "housework")
	public String getHousework() {
		return housework;
	}
	public void setHousework(String housework) {
		this.housework = housework;
	}
	
	@Basic
    @Column(name = "pet")
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}
	
	@Basic
    @Column(name = "deposit")
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
}
