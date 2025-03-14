package leiphotos.domain.core;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.utils.RegExpMatchable;

public record GPSLocation(double latitude, double longitude, String descricao) implements GPSCoordinates, RegExpMatchable {
	
	
    public GPSLocation(double latitude, double longitude, String descricao) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
    }
	
	@Override
	public double latitude() {
		return latitude;
	}
	
	@Override
	public double longitude(){
		return longitude;
	}
	
	public String getDescription() {
        return descricao;
    }
	
	
	 @Override
	public boolean matches(String regexp) {
	        return descricao.matches(regexp);
	    }
}
