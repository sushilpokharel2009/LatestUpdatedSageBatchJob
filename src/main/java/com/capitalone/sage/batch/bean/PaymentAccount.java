package com.capitalone.sage.batch.bean;

import java.util.*;

//import org.apache.commons.lang3.builder.HashCodeBuilder;
//import org.apache.commons.lang3.builder.ToStringBuilde;
public class PaymentAccount {
	private int id;
	private String name;
//	private String abaNumber;
//	private String bankAccountNumberTokenized;
//	private UUID pmtAcctUnqId;
	private String bankAccountNumber;
	private String routingNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public String getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	@Override
	public String toString() {
		return "PaymentAccount [id=" + id + ", name=" + name + ", bankAccountNumber=" + bankAccountNumber
				+ ", routingNumber=" + routingNumber + "]";
	}

	

}
