package com.markiiimark.ec;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.markiiimark.ec.domain.TourPackage;
import com.markiiimark.ec.service.TourPackageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourPackageServiceTest {
	
	@Autowired
	TourPackageService tourPackageService;
	
	@Test
	public void testCreateTourpackage() {
		TourPackage tourPackage = null;
		tourPackage = tourPackageService.createTourPackage("code1",	"name1");
		
		System.out.println("testCreateTourPackage - tourPackage: " + tourPackage);
		assertNotNull(tourPackage);
	}
	
	@Test
	public void testTotal() {
		long total = tourPackageService.total();
		System.out.println("testTotal - total: " + total);
	}
	
	@Test
	public void testLookup() {
		Iterable<TourPackage> tourPackages = tourPackageService.lookup();
		for(TourPackage tourPackage: tourPackages) {
			System.out.println("testLookup - tourPackage: " + tourPackage);
		}
	}
	
	

}

