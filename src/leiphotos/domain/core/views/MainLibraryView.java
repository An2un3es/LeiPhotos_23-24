package leiphotos.domain.core.views;

import java.util.ArrayList;
import java.util.Comparator;

import leiphotos.domain.core.Library;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.PhotoAddedLibraryEvent;
import leiphotos.domain.core.PhotoChangedLibraryEvent;
import leiphotos.domain.core.PhotoLibraryEvent;
import leiphotos.domain.core.PhotoRemovedLibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public class MainLibraryView extends ALibraryView implements Listener<PhotoLibraryEvent> {

	private ArrayList<IPhoto> cachedPhotos;
	
	protected MainLibraryView(MainLibrary mainLibrary, Comparator<IPhoto> comparator) {
		super(mainLibrary, comparator);
		cachedPhotos = (ArrayList<IPhoto>) getPhotos();
	}
	
	@Override
	public void processEvent(PhotoLibraryEvent e) {
		if(e instanceof PhotoAddedLibraryEvent) {
			cachedPhotos.add(e.getPhoto());
		}
		else if(e instanceof PhotoRemovedLibraryEvent) {
			cachedPhotos.remove(e.getPhoto());
		}
		else if (e instanceof PhotoChangedLibraryEvent) {
			for (IPhoto p : cachedPhotos) {
				if (p.equals(e.getPhoto())) {
					cachedPhotos.remove(cachedPhotos.indexOf(p));
					cachedPhotos.add(e.getPhoto());
				}
			}
		}
	}
}
