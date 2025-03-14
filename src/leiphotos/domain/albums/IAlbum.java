package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.core.PhotoLibraryEvent;
import leiphotos.domain.facade.IPhoto;
import leiphotos.utils.Listener;

public interface IAlbum extends Listener<PhotoLibraryEvent> {

	/**
	 * Returns the number of photos in the Album
	 * 
	 * @return the number of photos
	 */
	public int numberOfPhotos();
	
	/**
	 * Returns the name of the Album
	 * 
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Return a list of all photos in the album
	 * 
	 * @return the list with the photos
	 */
	public List<IPhoto> getPhotos();
	
	/**
	 * Adds the set of Photos to the Album
	 * 
	 * @return whether it was successful or not
	 */
	public boolean addPhotos(Set<IPhoto> selectedPhotos);
	
	/**
	 * Removes the set fotos from the Album
	 * 
	 * @return whether it was successful or not
	 */
	public boolean removePhotos(Set<IPhoto> selectedPhotos);

}
