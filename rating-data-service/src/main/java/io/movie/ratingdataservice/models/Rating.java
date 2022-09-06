package io.movie.ratingdataservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rating {
	
	protected String movieId;
	protected int rating;

}
