package leiphotos.domain.core;

import java.util.ArrayList;
import java.util.Collection;

import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.AbsSubject;


public class MainLibrary extends AbsSubject<PhotoLibraryEvent> implements Library{

	private Collection<IPhoto> photos;
	
	public MainLibrary() {
		photos = new ArrayList<>();
	}
	
	@Override
	public int getNumberOfPhotos() {
		return photos.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		if(photos.add(photo)) {
			emitEvent(new PhotoAddedLibraryEvent(photo, this)); //Notifica o observer
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		if(photos.remove(photo)) {
			emitEvent(new PhotoRemovedLibraryEvent(photo, this)); //Notifica o observer
			return true;
		}
			return false;
	}

	@Override
	public Collection<IPhoto> getPhotos() {
		return photos;
	}

	@Override
	public Collection<IPhoto> getMatches(String regexp) {
		Collection<IPhoto> colPhotos= new ArrayList<>();
		for (IPhoto photo : photos) {
			if (photo.matches(regexp)) {
				colPhotos.add(photo);
			}
		}
		return colPhotos;
	}

}
