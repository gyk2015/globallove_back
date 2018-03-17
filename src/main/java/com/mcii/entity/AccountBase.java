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
@Table(name = "AccountBase")
public class AccountBase  implements Serializable{
	private int id;
    private Account accountid;
    private String realname;
    private String sex;
    private int age;
    private int height;
    private int weight;
    private String salary;
    private String education;
    private String workplace;
    private String marrystatus;
    private String nativeplace;
    private String headimg;
    

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
    @Column(name = "realname")
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@Basic
    @Column(name = "sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Basic
    @Column(name = "age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Basic
    @Column(name = "height")
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Basic
    @Column(name = "weight")
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Basic
    @Column(name = "salary")
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
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
    @Column(name = "workplace")
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
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
    @Column(name = "nativeplace")
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	
	@Basic
    @Column(name = "headimg")
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

}
