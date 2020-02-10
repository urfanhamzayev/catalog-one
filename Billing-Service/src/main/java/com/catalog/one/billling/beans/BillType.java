package com.catalog.one.billling.beans;

public class BillType {

	private String type;
	private int id;
	
	public BillType(int id, String type) {
		super();
		this.id=id;
		this.type=type;
	}
	
	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Bill [type=" + type + ", id=" + id + "]";
	}

}
