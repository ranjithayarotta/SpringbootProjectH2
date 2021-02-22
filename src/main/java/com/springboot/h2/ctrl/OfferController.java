package com.springboot.h2.ctrl;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.h2.exception.SourceNotfoundException;
import com.springboot.h2.model.Offer;
import com.springboot.h2.serv.OfferService;

@RestController
@RequestMapping("/collect")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@PostMapping("/offer")
	public ResponseEntity<String> saveOffer(@RequestBody Offer offer) throws SourceNotfoundException, JSONException {
		offerService.saveOfferData(offer);
		JSONObject json = new JSONObject();
		json.put("success", "true");
		return new ResponseEntity<>(json.toString(), HttpStatus.CREATED);

	}

	@GetMapping("/offer")
	public ResponseEntity<Iterable<Offer>> getAllOffer(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "offerId") String sortBy) {
		Iterable<Offer> offer = offerService.getAllOfferData(pageNo, pageSize, sortBy);
		return new ResponseEntity<Iterable<Offer>>(offer, new HttpHeaders(), HttpStatus.OK);

	}

}
