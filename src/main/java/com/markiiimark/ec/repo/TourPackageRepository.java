package com.markiiimark.ec.repo;

import org.springframework.data.repository.CrudRepository;

import com.markiiimark.ec.domain.TourPackage;


public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
	TourPackage findByName(String name);
}
