package com.example.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity // this is an object to be managed by Hibernate
@Table(name = "TELECOM_PHONE_TABLE")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int phone_id;

	@Column
	private long phone_area;

	@Column
	private long phone_number;

	@Column
	private String phone_first_name;

	@Column
	private String phone_last_name;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "pl_id", referencedColumnName = "plan_id")
	private Plan plan;

	public Phone() {
		super();
	}

	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public long getPhone_area() {
		return phone_area;
	}

	public void setPhone_area(long phone_area) {
		this.phone_area = phone_area;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getPhone_first_name() {
		return phone_first_name;
	}

	public void setPhone_first_name(String phone_first_name) {
		this.phone_first_name = phone_first_name;
	}

	public String getPhone_last_name() {
		return phone_last_name;
	}

	public void setPhone_last_name(String phone_last_name) {
		this.phone_last_name = phone_last_name;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public void assignPlone(Plan pl) {
		this.plan = pl;
	}

	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", phone_area=" + phone_area + ", phone_number=" + phone_number
				+ ", phone_first_name=" + phone_first_name + ", phone_last_name=" + phone_last_name + "]";
	}

}
