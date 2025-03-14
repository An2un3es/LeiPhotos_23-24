package leiphotos.domain.core.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import leiphotos.domain.core.Library;
import leiphotos.domain.facade.IPhoto;

public abstract class ALibraryView implements ILibraryView {

	protected Library library;
	protected Comparator<IPhoto> comparator;
	
	protected ALibraryView(Library library, Comparator<IPhoto> comparator) {
		this.library = library;
		this.comparator = comparator;
	}
	
	@Override
	public void setComparator(Comparator<IPhoto> c) {
		comparator = c;
	}
	
	@Override
	public int numberOfPhotos() {
		return library.getNumberOfPhotos();
	}

	@Override
	public List<IPhoto> getPhotos() {
		return new ArrayList<IPhoto>(library.getPhotos());
	}
	
	@Override
	public List<IPhoto> getMatches(String regexp) {
		return new ArrayList<IPhoto>(library.getMatches(regexp));
	}

}
