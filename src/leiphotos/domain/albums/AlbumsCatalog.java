package leiphotos.domain.albums;

import java.util.*;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.facade.IPhoto;

public class AlbumsCatalog implements IAlbumsCatalog {
	
	private final MainLibrary mainLibrary;
    private final Map<String, IAlbum> albumsMap;

	public AlbumsCatalog(MainLibrary mainLibrary) {
		this.mainLibrary = mainLibrary;
        this.albumsMap = new HashMap<>();
	}
	
	@Override
    public boolean createAlbum(String albumName) {
        if (!containsAlbum(albumName)) {
            albumsMap.put(albumName, new Album(this.mainLibrary,albumName));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAlbum(String albumName) {
        if (containsAlbum(albumName)) {
            albumsMap.remove(albumName);
            mainLibrary.unregisterListener(albumsMap.get(albumName));
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAlbum(String albumName) {
        return albumsMap.containsKey(albumName);
    }

    @Override
    public boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos) {
        if (containsAlbum(albumName)) {
        	albumsMap.get(albumName).addPhotos(selectedPhotos);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos) {
        if (containsAlbum(albumName)) {
            albumsMap.get(albumName).removePhotos(selectedPhotos);
            return true;
        }
        return false;
    }

    @Override
    public List<IPhoto> getPhotos(String albumName) {
        
        if (containsAlbum(albumName)) {
        	return albumsMap.get(albumName).getPhotos();
        	
        }
        return Collections.emptyList();
    }

    @Override
    public Set<String> getAlbumsNames() {
        return albumsMap.keySet();
    }

}
