package com.markiiimark.ec;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.markiiimark.ec.domain.Difficulty;
import com.markiiimark.ec.domain.Region;
import com.markiiimark.ec.service.TourPackageService;
import com.markiiimark.ec.service.TourService;

@SpringBootApplication	
public class ExplorecaliApplication implements CommandLineRunner {
	
	@Autowired
	private TourPackageService tourPackageService;
	@Autowired
	private TourService tourService;

//public class ExplorecaliApplication {	
	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("run() method executed");
		initTourPackages();
		initTours();
	}
	
	private void initTourPackages() {
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
		System.out.println("Number of tours packages = " + tourPackageService.total());
	}
	
	private void initTours() throws IOException {
//		TourFromFile.importTours().forEach(new java.util.function.Consumer<TourFromFile>() {
		TourFromFile.importTours().forEach(t -> tourService.createTour(
				t.title, 
				t.description, 
				t.blurb, 
				Integer.parseInt(t.price), 
				t.length, 
				t.bullets, 
				t.keywords, 
				t.packageType, 
				Difficulty.valueOf(t.difficulty), 
				Region.findByLabel(t.region)));
			
//			@Override
//			public void accept(TourFromFile t) {
//				// TODO Auto-generated method stub
//				tourService.createTour(
//						t.title, 
//						t.description, 
//						t.blurb, 
//						Integer.parseInt(t.price), 
//						t.length, 
//						t.bullets, 
//						t.keywords, 
//						t.packageType, 
//						Difficulty.valueOf(t.difficulty), 
//						Region.findByLabel(t.region));
//			}
//		});
		System.out.println("Number of tours = " + tourService.total());
	}
	
	static class TourFromFile {
		private String packageType, title, description, blurb, price, length, bullets, keywords, difficulty, region;
		
		/**
		 * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
		 *
		 * @return a List of TourFromFile objects.
		 * @throws IOException if ObjectMapper unable to open file.
         */
		
		static List<TourFromFile> importTours() throws IOException {
			return new ObjectMapper()
					.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
					.readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"), new TypeReference<List<TourFromFile>>(){});
		}
	}
//	
}
