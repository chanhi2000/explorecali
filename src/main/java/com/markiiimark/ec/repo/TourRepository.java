package com.markiiimark.ec.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.markiiimark.ec.domain.Tour;



public interface TourRepository extends CrudRepository<Tour, Integer> {
	List<Tour> findByTourPackageCode(String code);
}
