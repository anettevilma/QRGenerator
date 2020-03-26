package com.qrgenerator.dto;


import java.util.HashMap;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InputDTO<ProductDetailDTO> {
	
	private ProductDetailDTO data;
	private int width=350;
	private int height=350;
	String sample;
	
	

	public ProductDetailDTO getData() {
		return data;
	}

	public void setData(ProductDetailDTO data) {
		
		
		this.data =data;
		
				 
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	

	
	
}
