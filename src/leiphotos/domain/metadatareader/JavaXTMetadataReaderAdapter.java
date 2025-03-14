package leiphotos.domain.metadatareader;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import leiphotos.services.JavaXTJpegMetadataReader;

public class JavaXTMetadataReaderAdapter implements JpegMetadataReader {

	JavaXTJpegMetadataReader dataReader;
	
	public JavaXTMetadataReaderAdapter(File file) {
		this.dataReader = new JavaXTJpegMetadataReader(file);
	}
	
	@Override
	public String getCamera() {
		return dataReader.getCamara();
	}

	@Override
	public String getManufacturer() {
		return dataReader.getManufacturer();
	}

	@Override
	public LocalDateTime getDate() {
		LocalDateTime localDateTime;
		// Define the format of the input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu:MM:dd HH:mm:ss");
        
        if (dataReader.getDate()!=null) {
        	 localDateTime = LocalDateTime.parse(dataReader.getDate(), formatter);
        }
        else {
        	 localDateTime = LocalDateTime.of(1, 1, 1, 1, 1, 1); //Caso a imagem não ter uma data disponivel 
        }
        return localDateTime;
	}

	@Override
	public String getAperture() {
		return dataReader.getAperture();
	}

	@Override
	public double[] getGpsLocation() {
		return dataReader.getGPS();
	}

}
