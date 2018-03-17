package com.mcii.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Account")
public class Account  implements Serializable{
	private int id;
    private String username;
    private String password;
    private String userphone;
    private String useremail;
    private int usertype;
    private String emailcode;
    private int userstate;
    private int userlevel;

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
	
	@Basic
    @Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Basic
    @Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Basic
    @Column(name = "userphone")
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	@Basic
    @Column(name = "useremail")
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	@Basic
    @Column(name = "usertype")
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	
    @Basic
    @Column(name = "emailcode")
    public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	
    @Basic
    @Column(name = "userstate")
	public int getUserstate() {
		return userstate;
	}
	public void setUserstate(int userstate) {
		this.userstate = userstate;
	}
	
	@Basic
    @Column(name = "userlevel")
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
}
