package leiphotos.domain.core;

import leiphotos.domain.facade.IPhoto;

/**
 * @author malopes
 *
 * A photo removed event
 */
public class PhotoRemovedLibraryEvent extends PhotoLibraryEvent {

	/**
	 * Constructs a photo deleted library event.
	 * 
	 * @param photo The photo upon which the event has happened
	 * @param lib The library upon which the event has happened	  
	 */
	PhotoRemovedLibraryEvent(IPhoto photo, Library lib) {
		super(photo,lib);
	}

}
