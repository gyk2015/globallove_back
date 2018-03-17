package com.mcii.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Email")
public class Email implements Serializable{
	private int id;
	private Account sendid;
	private Account receiveid;
	private String title;
	private String content;
	private int status;
	private Timestamp time;
	
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
    @JoinColumn(name = "sendid")
	public Account getSendid() {
		return sendid;
	}
	public void setSendid(Account sendid) {
		this.sendid = sendid;
	}
	
	@ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "receiveid")
	public Account getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(Account receiveid) {
		this.receiveid = receiveid;
	}
	
	@Basic
    @Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Basic
    @Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Basic
    @Column(name = "status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	 @Basic
	 @Column(name = "time")
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
