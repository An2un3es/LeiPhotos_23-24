package leiphotos.domain.core;

import java.time.LocalDateTime;

import leiphotos.utils.RegExpMatchable;

public record PhotoMetadata(GPSLocation location, LocalDateTime date, String camera, String fabricante) implements RegExpMatchable {

	public PhotoMetadata(GPSLocation location, LocalDateTime date, String camera, String fabricante) {
		this.location=location;
		this.date=date;
		this.camera=camera;
		this.fabricante=fabricante;
	}

	@Override
	public boolean matches(String regexp) {

		// Verifica se algum dos parâmetros é nulo e, se for, retorna false
		if (location != null && location.toString().matches(regexp)) {
			return true;
		}
		if (date != null && date.toString().matches(regexp)) {
			return true;
		}
		if (camera != null && camera.matches(regexp)) {
			return true;
		}
		if (fabricante != null && fabricante.matches(regexp)) {
			return true;
		}

		return false;
	}
}

