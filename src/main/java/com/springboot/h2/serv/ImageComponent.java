package com.springboot.h2.serv;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.springboot.h2.exception.SourceNotfoundException;
import com.springboot.h2.model.Image;



@Component
public class ImageComponent {

	private Map<Integer, Image> imageInfo = new HashMap<>();

	@Autowired

	private RestTemplate restTemplate;

	@PostConstruct
	private void init() {
		
		

		ResponseEntity<List<Image>> responseEntity = restTemplate.exchange("https://jsonplaceholder.typicode.com/photos", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Image>>() {
				});
		List<Image> listOfObject = responseEntity.getBody();
		imageInfo = listOfObject.stream().collect(Collectors.toMap(Image::getId, image -> image));

	}

	public String getImage(Integer id) throws SourceNotfoundException {
		Image img = imageInfo.get(id);
		if (img == null) {
			throw new SourceNotfoundException("Image not found with id::" + id);
		} else {
			return imageInfo.get(id).getUrl();
		}
	}

}
