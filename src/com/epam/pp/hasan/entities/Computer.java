package com.epam.pp.hasan.entities;

import com.epam.pp.hasan.annotations.ProductAnnotation;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class Computer extends Product {
	private Integer ram;
	private Integer hdd;

	public final Integer getHdd() {
		return hdd;
	}

	@ProductAnnotation(resourse = "hdd", type = "Integer")
	public final void setHdd(final Integer hdd) {
		this.hdd = hdd;
	}

	public final Integer getRam() {
		return ram;
	}

	@ProductAnnotation(resourse = "ram", type = "Integer")
	public final void setRam(final Integer ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Computer [ram=" + ram + ", hdd=" + hdd + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getPrice()=" + getPrice() + "]";
	}

}
