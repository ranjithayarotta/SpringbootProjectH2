package com.springboot.h2.model;

import java.util.ArrayList;
import java.util.List;

public class OfferResponseDTO  {

	List<Offer> data = new ArrayList<>();

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Offer> getData() {
		return data;
	}

	public void setData(List<Offer> data) {
		this.data = data;
	}

}
