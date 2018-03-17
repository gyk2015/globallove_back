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
@Table(name = "AccountDtl")
public class AccountDtl implements Serializable{
	private int id;
    private Account accountid;
    private String bloodtype;
    private String constellation;
    private String nation;
    private String zodiac;
    private String religion;
    private String house;
    
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
    @Column(name = "bloodtype")
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	
	@Basic
    @Column(name = "constellation")
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	
	@Basic
    @Column(name = "nation")
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Basic
    @Column(name = "zodiac")
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}
	
	@Basic
    @Column(name = "religion")
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	@Basic
    @Column(name = "house")
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
    
    
}
