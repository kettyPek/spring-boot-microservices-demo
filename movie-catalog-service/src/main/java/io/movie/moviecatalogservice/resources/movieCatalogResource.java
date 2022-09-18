package io.movie.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.movie.moviecatalogservice.models.CatalogItem;
import io.movie.moviecatalogservice.models.Movie;
import io.movie.moviecatalogservice.models.Rating;
import io.movie.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class movieCatalogResource {

	@Autowired // option 1
	RestTemplate restTemplate;

	@Autowired // option 2
	WebClient.Builder webClientBuilder;

	// RestTemplate
	@RequestMapping("/{userId}") 
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
	  
		List<Rating> ratings = restTemplate.getForObject("http://rating-data-service/ratings/user/" +userId, UserRating.class).getRatings();
		  
		return ratings.stream().map(rating -> { 
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" +rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(),"des", rating.getRating()); 
			}).collect(Collectors.toList());
	  
	}

	// WebClient
	/*
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("123", 5), new Rating("124", 6));

		return ratings.stream().map(rating -> {
			Movie movie = webClientBuilder.build()
					.get().uri("http://localhost:8082/movies/" + rating.getMovieId())
					.retrieve().bodyToMono(Movie.class).block();
			return new CatalogItem(movie.getName(), "des", rating.getRating());
		}).collect(Collectors.toList());
	}
	*/

}
