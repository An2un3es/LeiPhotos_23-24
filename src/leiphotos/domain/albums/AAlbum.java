package leiphotos.domain.albums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import leiphotos.domain.core.LibraryEvent;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoLibraryEvent;
import leiphotos.domain.core.PhotoRemovedLibraryEvent;
import leiphotos.domain.facade.IPhoto;

public abstract class AAlbum implements IAlbum {

	protected final MainLibrary mainLibrary;
	protected final String name;
	protected final List<IPhoto> photos;


	protected AAlbum(MainLibrary mainLibrary, String name) {
		this.mainLibrary = mainLibrary;
		mainLibrary.registerListener(this);
		this.name = name;
		this.photos = new ArrayList<>();
	}
	
	
	@Override
	public void processEvent(PhotoLibraryEvent e) {
		if(e instanceof PhotoRemovedLibraryEvent && e.getLibrary().equals(mainLibrary)) {
			photos.remove(e.getPhoto());
		}
	}

	@Override
	public int numberOfPhotos() {
		return photos.size();
	}

	@Override
	public String getName() {
		return name;	
	}

	@Override
	public List<IPhoto> getPhotos() {
		return photos;
	}

	@Override
	public boolean addPhotos(Set<IPhoto> selectedPhotos) {
		return photos.addAll(selectedPhotos);
	}

	@Override
	public boolean removePhotos(Set<IPhoto> selectedPhotos) {
		return photos.removeAll(selectedPhotos);
	}
}
