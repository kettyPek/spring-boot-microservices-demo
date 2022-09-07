package io.movie.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.movie.ratingdataservice.models.Rating;
import io.movie.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRatingsByMovieId(@PathVariable String movieId) {

		return new Rating(movieId, 4);
	}

	@RequestMapping("/user/{userId}")
	public UserRating getRatingsByUserId(@PathVariable String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("123", 5),
				new Rating("124", 6));
		
		return new UserRating(ratings);
	}
}
