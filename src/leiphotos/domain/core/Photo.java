package leiphotos.domain.core;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Optional;

import leiphotos.domain.facade.GPSCoordinates;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.RegExpMatchable;

public class Photo implements IPhoto, RegExpMatchable{

	private String title;
	private LocalDateTime capturedDate;
	private LocalDateTime addedDate;
	private boolean isFavorite;
	private PhotoMetadata metadata;
	private File file;
	private long size;

	public Photo(String title, LocalDateTime dateAddedLib, PhotoMetadata meta, File file) {
		this.title = title;
		this.addedDate = dateAddedLib;
		this.capturedDate = meta.date();
		this.metadata = meta;
		this.file = file;
		this.isFavorite = false;
		this.size = file.length();
	}


	@Override
	public String title() {
		return title;
	}

	@Override
	public LocalDateTime capturedDate() {
		return capturedDate;
	}

	@Override
	public LocalDateTime addedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime date) {
		this.addedDate = date;
	}

	@Override
	public boolean isFavourite() {
		return isFavorite;
	}

	@Override
	public void toggleFavourite() {
		isFavorite = !isFavorite;
	}

	@Override
	public Optional<? extends GPSCoordinates> getPlace() {

		return Optional.ofNullable(metadata != null ? metadata.location() : null);
	}

	@Override
	public long size() {
		return size;
	}

	@Override
	public File file() {
		return file;
	}

	@Override
	public boolean matches(String regexp) {
		// Verifica se algum dos dados da foto emparelha com a expressão regular fornecida
		return title.matches(regexp) ||
				capturedDate.toString().matches(regexp) ||
				metadata.matches(regexp) ||
				file.getAbsolutePath().matches(regexp);
	}

	@Override
	public boolean equals(Object obj) {

		File f = this.file;

		if((obj instanceof Photo) && (((Photo) obj).file().equals(f))) {
			return true;
		}
		else
			return false;
	}
}