package leiphotos.domain.core.views;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import leiphotos.domain.facade.IPhoto;

public interface ILibraryView {
	
	/**
	 * Allows the definition of a ordering criteria
	 *  
	 * @param c the comparator
	 */
	void setComparator(Comparator<IPhoto> c);
	
	/**
	 * Returns the number of photos in this view
	 * 
	 * @return the number of photos
	 */
	int numberOfPhotos();
	
	/**
	 * Returns the list of all photos in this view
	 * 
	 * @return A List with all photos
	 */
	List<IPhoto> getPhotos();
	
	/**
	 * Returns a collection with the photos in the view 
	 * that match the regexp
	 * 
	 * @param regexp The regular expression
	 * @requires regexp is a regular expression
	 * @return A List with the photos in the view matching the expression
	 */
	List<IPhoto> getMatches(String regexp);
}
