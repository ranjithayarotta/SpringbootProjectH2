package com.springboot.h2.serv;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.h2.exception.SourceNotfoundException;
import com.springboot.h2.model.Offer;
import com.springboot.h2.repo.IOfferRepo;
import com.springboot.h2.utility.Utility;



@Service
public class OfferService {

	private static final int MINIMUM_SIZE = 1;
	private static final int MAXIMUM_SIZE = 5000;

	@Autowired
	private IOfferRepo offerRepo;

	@Autowired
	private ImageComponent imageComponent;

	public Iterable<Offer> getAllOfferData(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Offer> pagedResult = offerRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Offer>();
		}
		//return new ArrayList<Offer>();

	}

	public Offer saveOfferData(Offer offer) throws SourceNotfoundException {
		int radomNumber = Utility.getTheRandomNumber(MINIMUM_SIZE, MAXIMUM_SIZE);
		String url = imageComponent.getImage(radomNumber);
		offer.setImages(url);
		return offerRepo.save(offer);
		//return new Offer();
	}

}
