package com.epam.pp.hasan.entities;

import com.epam.pp.hasan.annotations.ProductAnnotation;

/**
 * 
 * @author Yosin_Hasan
 *
 */
public class Phone extends Product {
	private Integer camera;
	private Double screen;

	public final Integer getCamera() {
		return camera;
	}

	@ProductAnnotation(resourse = "camera", type = "Integer")
	public final void setCamera(final Integer camera) {
		this.camera = camera;
	}

	public final Double getScreen() {
		return screen;
	}

	@ProductAnnotation(resourse = "screen", type = "Double")
	public final void setScreen(final Double screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Phone [camera=" + camera + ", screen=" + screen + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getPrice()=" + getPrice() + "]";
	}

}
