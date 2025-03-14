package leiphotos.domain.core.views;

import java.util.Comparator;

import leiphotos.domain.core.Library;
import leiphotos.domain.facade.IPhoto;

public class TrashLibraryView extends ALibraryView {

    protected TrashLibraryView(Library library, Comparator<IPhoto> comparator) {
		super(library, comparator);
	}

}
