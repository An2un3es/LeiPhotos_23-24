package leiphotos.domain.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


import leiphotos.domain.facade.IPhoto;

public abstract class ATrashLibrary implements TrashLibrary {

	protected ArrayList<IPhoto> photos;
	protected ArrayList<LocalDateTime> timePhotosAdded;
	
	protected ATrashLibrary() {
		photos = new ArrayList<IPhoto>();
	}

	@Override
	public int getNumberOfPhotos() {
		return photos.size();
	}

	@Override
	public boolean addPhoto(IPhoto photo) {
		for (IPhoto oldPhoto :photos) {
			if (oldPhoto.equals(photo)) {
				return false;
			}
		}
		photo.setAddedDate(LocalDateTime.now());
		return photos.add(photo);
	}

	@Override
	public boolean deletePhoto(IPhoto photo) {
		for (IPhoto oldPhoto :photos) {
			if (oldPhoto.equals(photo)) {
				photos.remove(oldPhoto);
				return true;
			}
		}
		return false;
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

	@Override
	public Collection<IPhoto> getPhotos() {
		if (cleaningTime())
			clean();
		Collection<IPhoto> colPhotos =this.photos;
		return colPhotos;
	}

	@Override
	public boolean deleteAll() {
		this.photos.clear();
		return true;
	}
	
	protected abstract void clean();
	protected abstract boolean cleaningTime();

}
