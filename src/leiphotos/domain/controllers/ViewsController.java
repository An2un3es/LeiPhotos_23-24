package leiphotos.domain.controllers;

import java.util.Comparator;
import java.util.List;

import leiphotos.domain.core.views.ILibraryView;
import leiphotos.domain.core.views.IViewsCatalog;
import leiphotos.domain.core.views.ViewsCatalog;
import leiphotos.domain.facade.IPhoto;
import leiphotos.domain.facade.IViewsController;
import leiphotos.domain.facade.ViewsType;


//Class automatically generated so the code compiles
//CHANGE ME
public class ViewsController implements IViewsController {
	
	private IViewsCatalog views;

	public ViewsController(IViewsCatalog views) {
		this.views = views;
	}

	@Override
	public List<IPhoto> getPhotos(ViewsType viewType) {
		return views.getView(viewType).getPhotos();
		//ILibraryView libraryView = views.getView(viewType);
		//return libraryView.getPhotos();
	}

	@Override
	public List<IPhoto> getMatches(ViewsType viewType, String regexp) {
		ILibraryView libraryView = views.getView(viewType);
		return libraryView.getMatches(regexp);
	}

	@Override
	public void setSortingCriteria(ViewsType v, Comparator<IPhoto> criteria) {
		ILibraryView libraryView = views.getView(v);
		libraryView.setComparator(criteria);
	}

}
