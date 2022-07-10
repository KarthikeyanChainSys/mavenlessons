package com.chainsys.mavenlessons.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Doctors")
public class Doctor {
	@Id
	@Column(name = "DOC_ID")
	private int id;
	@Column(name = "DOC_NAME")
	private String doc_name;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "SPECIALITY")
	private String speciality;
	@Column(name = "CITY")
	private String city;
	@Column(name = "PHONE_NO")
	private long phone_no;
	@Column(name = "STANDARD_FEES")
	private float standard_fees;
	//Bidirectional Association
	
	// Lazy - when we call the doctor class on that time the object will be create
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Appointment> appointments;
	public List<Appointment> getAppointments(){
		return this.appointments;
	}
	
	public int getDoc_id() {
		return id;
	}
	public void setDoc_id(int doc_id) {
		this.id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public float getStandard_fees() {
		return standard_fees;
	}
	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}
	@Override
	public String toString() {
		return String.format("[%d, %s, %s, %s, %d, %s, %.2f]", id, doc_name, dob, city, phone_no, speciality, standard_fees);
	}
}
