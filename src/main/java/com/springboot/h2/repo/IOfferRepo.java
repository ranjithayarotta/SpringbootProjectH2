package com.springboot.h2.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.h2.model.Offer;


@Repository
public interface IOfferRepo extends  PagingAndSortingRepository<Offer, Long> {

}
