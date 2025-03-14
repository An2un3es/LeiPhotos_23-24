package leiphotos.domain.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Set;

import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.Photo;
import leiphotos.domain.core.PhotoFactory;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.ILibrariesController;
import leiphotos.domain.facade.IPhoto;

//Class automatically generated so the code compiles
//CHANGE ME
public class LibrariesController implements ILibrariesController {
	
	private MainLibrary mainLibrary;
	private TrashLibrary trashLibrary;
	

	public LibrariesController(MainLibrary mainLib, TrashLibrary trashLib) {
		this.mainLibrary = mainLib;
		this.trashLibrary = trashLib;
	}

	/**
	 * Imports a photo with the given title and path to the photo file.
	 * 
	 * @param title The title of the photo.
	 * @param pathToPhotoFile The path to the photo file.
	 * @return An Optional containing the imported photo, or an empty Optional if the import fails.
	 * @throws FileNotFoundException 
	 */
	@Override
	public Optional<IPhoto> importPhoto(String title, String pathToPhotoFile){
		
		try {
            // Cria uma nova foto com o PhotoFactory
            Photo photo = PhotoFactory.INSTANCE.createPhoto(title, pathToPhotoFile);
            
            // Adiciona a foto à mainLibrary
            mainLibrary.addPhoto(photo);
            
            // Retorna a foto como um Optional
            return Optional.of(photo);
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao importar foto: " + e.getMessage());
            return Optional.empty();
        }
	}

	@Override
	public void deletePhotos(Set<IPhoto> selectedPhotos) {
		for (IPhoto p : selectedPhotos) {
			if(mainLibrary.getPhotos().contains(p)) {
				trashLibrary.addPhoto(p);
				mainLibrary.deletePhoto(p);
			}
		}
	}

	@Override
	public void emptyTrash() {
		trashLibrary.deleteAll();
	}

	/**aqui na proxima fase temos que emitir um PhotoChangeEvent provavelmente
	 * para retirar ou adicionar da biblioteca dos favoritos.
	*/
	@Override
	public void toggleFavourite(Set<IPhoto> selectedPhotos) {
		for (IPhoto p : mainLibrary.getPhotos()) {
			if(selectedPhotos.contains(p)) {
				p.toggleFavourite();
			}
		}
	}

	@Override
	public Iterable<IPhoto> getMatches(String regExp) {
		return mainLibrary.getMatches(regExp);
	}

}
