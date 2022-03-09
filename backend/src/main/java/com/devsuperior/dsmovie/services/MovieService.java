package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepositoy;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = movieRepositoy.findAll(pageable);
		Page<MovieDTO> page = result.map(p -> new MovieDTO(p));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = movieRepositoy.findById(id).get();
		MovieDTO movieDTO = new MovieDTO(result);
		return movieDTO;
	}
	
}
