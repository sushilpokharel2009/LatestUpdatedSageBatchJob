package com.capitalone.sage.batch.bean;

import java.util.UUID;

//import org.apache.commons.lang.builder.HashCodeBuilder;

public class ReconDTO {
	private int id;
	private String name;
//	private String abaNumber;
//	private String bankAccountNumberTokenized;
//	private UUID pmtAcctUnqId;
	private String bankAccountNumber;
	private String routingNumber;
	// private ReasonCodes reasonCodes;
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
		return "ReconDTO [id=" + id + ", name=" + name + ", bankAccountNumber=" + bankAccountNumber + ", routingNumber="
				+ routingNumber + "]";
	}


}
