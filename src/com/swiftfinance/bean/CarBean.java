package com.swiftfinance.bean;

public class CarBean {
	private int carid;
	private String name;
	/*
	 * private int manufacturerid; private String manufacturer;
	 */
	private double price;

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public int getManufacturerid() { return manufacturerid; }
	 * 
	 * public void setManufacturerid(int manufactuerid) { this.manufacturerid =
	 * manufactuerid; }
	 * 
	 * public String getManufacturer() { return manufacturer; }
	 * 
	 * public void setManufacturer(String manufactuer) { this.manufacturer =
	 * manufactuer; }
	 */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}