package io.movie.moviecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieCatalog {
	
	protected String title;
	protected String description;
	protected int rating;

}
