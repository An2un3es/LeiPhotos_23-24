package leiphotos.domain.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import leiphotos.domain.albums.IAlbumsCatalog;
import leiphotos.domain.facade.IAlbumsController;
import leiphotos.domain.facade.IPhoto;


//Class automatically generated so the code compiles
//CHANGE ME

public class AlbumsController implements IAlbumsController {
	
	private IAlbumsCatalog albumsCatalog;
	private String selectedAlbum;

	public AlbumsController(IAlbumsCatalog albumsCatalog) {
		this.albumsCatalog = albumsCatalog;	
	}

	@Override
	public boolean createAlbum(String name) {
		return albumsCatalog.createAlbum(name);
	}

	@Override
	public void removeAlbum() {
		if(selectedAlbum != null)
			albumsCatalog.deleteAlbum(selectedAlbum);
	}

	@Override
	public void selectAlbum(String name) {
		if(albumsCatalog.containsAlbum(name))
			selectedAlbum = name;
	}

	@Override
	public void addPhotos(Set<IPhoto> selectedPhotos) {
		if(selectedAlbum != null)
			albumsCatalog.addPhotos(selectedAlbum, selectedPhotos);

	}

	@Override
	public void removePhotos(Set<IPhoto> selectedPhotos) {
		if(selectedAlbum != null)
			albumsCatalog.removePhotos(selectedAlbum, selectedPhotos);
	}

	@Override
	public List<IPhoto> getPhotos() {
		if(selectedAlbum != null)
			return albumsCatalog.getPhotos(selectedAlbum);
		else return Collections.emptyList();
	}

	@Override
	public Optional<String> getSelectedAlbum() {
		if(selectedAlbum != null)
			return Optional.of(selectedAlbum);
		else return Optional.empty();
	}

	@Override
	public boolean createSmartAlbum(String name, Predicate<IPhoto> criteria) {
		if(albumsCatalog.containsAlbum(name))
			return false;
		else
			//TODO
			return true;
			
	}

	@Override
	public Set<String> getAlbumNames() {
		return albumsCatalog.getAlbumsNames();
	}

}
