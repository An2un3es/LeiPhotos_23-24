package leiphotos.domain.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import leiphotos.domain.metadatareader.JavaXTMetadataReaderAdapter;
import leiphotos.domain.metadatareader.JpegMetadataReader;

public enum PhotoFactory {
	INSTANCE;


	public Photo createPhoto(String title, String pathToPhotoFile) throws FileNotFoundException {
		// Verifica se o arquivo existe
		File file = new File(pathToPhotoFile);
		if (!file.exists()) {
			throw new FileNotFoundException("Arquivo não encontrado: " + pathToPhotoFile);
		}

		// Cria um objeto JpegMetadataReader para obter os metadados do arquivo JPEG
		JpegMetadataReader metadataReader = new JavaXTMetadataReaderAdapter(file);

		// Extrai os metadados do objeto JpegMetadataReader
		String camera = metadataReader.getCamera();
		String manufacturer = metadataReader.getManufacturer();
		
		LocalDateTime date = metadataReader.getDate();
		double[] gpsLocation = metadataReader.getGpsLocation();

		// Cria os metadados da foto
		GPSLocation location = null;
		if (gpsLocation != null) {
			location = new GPSLocation(gpsLocation[1], gpsLocation[0], ""); // Latitude, Longitude
		}
		PhotoMetadata metadata = new PhotoMetadata(location, date, camera, manufacturer);

		// Cria e retorna a foto
		return new Photo(title, LocalDateTime.now(), metadata, file);
	}
}

