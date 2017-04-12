package com.markiiimark.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markiiimark.ec.domain.TourPackage;
import com.markiiimark.ec.repo.TourPackageRepository;

@Service
public class TourPackageService {
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		if (! tourPackageRepository.exists(code)) {
			return tourPackageRepository.save(new TourPackage(code, name));
		} 
		return null;
	}
	
	public Iterable<TourPackage> lookup() {
		return tourPackageRepository.findAll();
	}
	
	public long total() {
		return tourPackageRepository.count();
	}
}
