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
@Table(name = "Mate")
public class Mate implements Serializable {
	private int id;
    private Account accountid;
    private int startage;
    private int endage;
    private String place;
    private int startheight;
    private int endheight;
    private String marrystatus;
    private String education;
    private String house;
    private int startsalary;
    private int endsalary;
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
	@Column(name = "startage")
	public int getStartage() {
		return startage;
	}
	public void setStartage(int startage) {
		this.startage = startage;
	}
	
	@Basic
	@Column(name = "endage")
	public int getEndage() {
		return endage;
	}
	public void setEndage(int endage) {
		this.endage = endage;
	}
	
	@Basic
	@Column(name = "place")
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Basic
	@Column(name = "startheight")
	public int getStartheight() {
		return startheight;
	}
	public void setStartheight(int startheight) {
		this.startheight = startheight;
	}
	
	@Basic
	@Column(name = "endheight")
	public int getEndheight() {
		return endheight;
	}
	public void setEndheight(int endheight) {
		this.endheight = endheight;
	}
	
	@Basic
	@Column(name = "marrystatus")
	public String getMarrystatus() {
		return marrystatus;
	}
	public void setMarrystatus(String marrystatus) {
		this.marrystatus = marrystatus;
	}
	
	@Basic
	@Column(name = "education")
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	@Basic
	@Column(name = "house")
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	
	@Basic
	@Column(name = "startsalary")
	public int getStartsalary() {
		return startsalary;
	}
	public void setStartsalary(int startsalary) {
		this.startsalary = startsalary;
	}
	
	@Basic
	@Column(name = "endsalary")
	public int getEndsalary() {
		return endsalary;
	}
	public void setEndsalary(int endsalary) {
		this.endsalary = endsalary;
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
