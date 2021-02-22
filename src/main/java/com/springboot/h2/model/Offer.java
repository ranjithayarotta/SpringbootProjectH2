package com.springboot.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "OFFER")
public class Offer {
	@Id
	@GeneratedValue
	@Column(name = "OFFER_ID")
	private Long offerId;
	@Column(name = "OFFER_NAME")

	private String offerName;
	@Column(name = "OFFER_VALID_FROM")
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date offerValidFrom;
	@Column(name = "OFFER_VALID_TILL")
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date offerValidTill;
	@Column(name = "OFFER_LOCATION")
	private String offerLocation;

	public Offer() {

	}

	public Offer(Long offerId, String offerName, Date offerValidFrom, Date offerValidTill, String offerLocation) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerValidFrom = offerValidFrom;
		this.offerValidTill = offerValidTill;
		this.offerLocation = offerLocation;
	}

	@Column(name = "IMAGES")
	@JsonIgnore
	private String images;

	public Long getOfferId() {
		return offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public Date getOfferValidFrom() {
		return offerValidFrom;
	}

	public Date getOfferValidTill() {
		return offerValidTill;
	}

	public String getOfferLocation() {
		return offerLocation;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}
