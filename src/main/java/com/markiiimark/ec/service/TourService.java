package com.markiiimark.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markiiimark.ec.domain.Difficulty;
import com.markiiimark.ec.domain.Region;
import com.markiiimark.ec.domain.Tour;
import com.markiiimark.ec.domain.TourPackage;
import com.markiiimark.ec.repo.TourPackageRepository;
import com.markiiimark.ec.repo.TourRepository;

@Service
public class TourService {
	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}
	
	/**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return Tour Entity
     */
	
	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageCode, Difficulty difficulty, Region region) {
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageCode);
		if (tourPackage == null) {
			throw new RuntimeException("Tour package does not exist: " + tourPackageCode);
		}
		Tour tour = new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region);
		return tourRepository.save(tour);
	}
	
	public Iterable<Tour> lookup() {
		return tourRepository.findAll();
	}
	
	public long total() {
		return tourRepository.count();
	}
	
}
