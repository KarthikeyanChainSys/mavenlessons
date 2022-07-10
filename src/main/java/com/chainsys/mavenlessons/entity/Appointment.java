package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointments")
public class Appointment {
	@Id
	@Column(name = "APP_ID")
	private int id;
	@Column(name = "APP_DATE")
	private Date appDate;
	@Column(name = "DOC_ID")
	private int docId;
	@Column(name = "PATIENT_NAME")
	private String patName;
	@Column(name = "FEES_COLLECTED")
	private float fees;
	@Column(name = "FEES_CATOGORY")
	private String catogory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor() {  
		return this.doctor;
	}
	public void setDoctor(Doctor doc) {
		this.doctor=doc;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getApp_date() {
		return appDate;
	}

	public void setApp_date(Date app_date) {
		this.appDate = app_date;
	}

	public int getDoc_id() {
		return docId;
	}

	public void setDoc_id(int doc_id) {
		this.docId = doc_id;
	}

	public String getPat_name() {
		return patName;
	}

	public void setPat_name(String pat_name) {
		this.patName = pat_name;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public String getCatogory() {
		return catogory;
	}

	public void setCatogory(String catogory) {
		this.catogory = catogory;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %.2f, %s", id, appDate, patName, fees, catogory);
	}
}
