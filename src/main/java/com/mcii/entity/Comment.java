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
@Table(name = "Comment")
public class Comment implements Serializable{
	
	public static final int MOOD = 0;
	public static final int ARTICLE = 1;
	
	private int id;
    private Account reviewerid;
    private int targetid;
    private int targettype;
    private String content;
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
    @JoinColumn(name = "reviewerid")
	public Account getReviewerid() {
		return reviewerid;
	}
	public void setReviewerid(Account reviewerid) {
		this.reviewerid = reviewerid;
	}
	
	@Basic
    @Column(name = "targetid")
	public int getTargetid() {
		return targetid;
	}
	public void setTargetid(int targetid) {
		this.targetid = targetid;
	}
	
	@Basic
    @Column(name = "targettype")
	public int getTargettype() {
		return targettype;
	}
	public void setTargettype(int targettype) {
		this.targettype = targettype;
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
    @Column(name = "time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
    
}
