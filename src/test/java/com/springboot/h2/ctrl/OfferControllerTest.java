package com.springboot.h2.ctrl;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.springboot.h2.AbstractTest;
import com.springboot.h2.model.Offer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class OfferControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getOfferList() throws Exception {
		String uri = "/collect/offer";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Offer[] productlist = super.mapFromJson(content, Offer[].class);
		assertTrue(productlist.length > 0);
	};

	@Test
	public void createProduct() throws Exception {
		String uri = "/collect/offer";
		Date fromDate = parseDate("2021-02-22 17:40:08.762");
		Date toDate = parseDate("2021-02-22 17:40:08.762");
		Offer product = new Offer(1l, "big", fromDate, toDate, "Ernakulam");
		String inputJson = super.mapToJson(product);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		JSONObject expected = new JSONObject();
		expected.put("success", "true");
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, expected.toString());
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}