package leiphotos.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import leiphotos.domain.facade.GPSCoordinates;

class PhotoTest {

	@Test
	void testCreatePhotoWithoutGPS() {
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertTrue(p != null);
	}

	@Test
	void testCreatePhotoWithGPS() {
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		GPSLocation gps = new GPSLocation(40, -74, "New York");
		PhotoMetadata m = new PhotoMetadata(gps, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertTrue(p != null);
	}

	@Test
	void testToggleFavourite() {
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		p.toggleFavourite();
		assertTrue(p.isFavourite());
	}

	@Test
	void testSize() { //requires the use of a mock file class
		long expectedSize = 1024;
		MockFile expectedFile = new MockFile("test.jpg",expectedSize);
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, "test1", "test2");
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertEquals(expectedSize, p.size());
	}

	@Test
	void testNoMatches() {
		String regexp = "Exp.*";
		
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertFalse(p.matches(regexp));
	}


	@Test
	void testMatchesTitle() {
		String regexp = "Test.*";
		
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new MockFile("Different.jpg", 1024);
		String expectedTitle = "Test Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertTrue(p.matches(regexp));
	}


	@Test
	void testMatchesFile() {
		String regexp = "Test.*";
		
		LocalDateTime expectedCapturedDate = LocalDateTime.of(2024, 1, 1, 0, 0);
		File expectedFile = new File("test.jpg");
		String expectedTitle = "Different Photo";
		LocalDateTime expectedAddedDate = LocalDateTime.now();
		
		PhotoMetadata m = new PhotoMetadata(null, expectedCapturedDate, null, null);
		
		Photo p = new Photo(expectedTitle, expectedAddedDate, m, expectedFile);
		
		assertFalse(p.matches(regexp));
	}

	@Test
	void testEquals() {
		File file1 = new File("test1.jpg");
		File file2 = new File("test2.jpg");
		File file3 = new File("test1.jpg");

		//COMPLETE ME
	}

	@Test
	void testHashCode() {
		File file1 = new File("test1.jpg");
		File file2 = new File("test1.jpg");

		//COMPLETE ME
	}

	//COMPLETE ME

}