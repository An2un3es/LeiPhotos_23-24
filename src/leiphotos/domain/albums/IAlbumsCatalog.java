package leiphotos.domain.albums;

import java.util.List;
import java.util.Set;

import leiphotos.domain.facade.IPhoto;

public interface IAlbumsCatalog {

	/**cria um novo álbum com o nome dado e junta-o ao catálogo, 
	 * se não existir nenhum com esse nome.
	 */
	boolean createAlbum(String albumName);

	/**
	 * remove um álbum com o nome dado do catálogo,
	 * se existir algum com esse nome.
	 */
	boolean deleteAlbum(String albumName);

	/**
	 * indica se existe no catálogo um álbum com o nome dado;
	 * 
	 * @param albumName
	 * @return
	 */
	boolean containsAlbum(String albumName);

	/**
	 * adiciona ao álbum com o nome dado as fotos dadas,
	 * se existir algum álbum com esse nome.
	 * 
	 * @param albumName
	 * @param selectedPhotos
	 * @return
	 */
	boolean addPhotos(String albumName, Set<IPhoto> selectedPhotos);

	/**
	 * remove ao álbum com o nome dado as fotos dadas,
	 * se existir algum álbum com esse nome.
	 * 
	 * @param albumName
	 * @param selectedPhotos
	 * @return
	 */
	boolean removePhotos(String albumName, Set<IPhoto> selectedPhotos);

	/**
	 * da as fotos do álbum com o nome dado;
	 * se não existir algum álbum com esse nome dá a lista vazia
	 * @param albumName
	 * @return
	 */

	List<IPhoto> getPhotos(String albumName);

	/**
	 * dá os nomes dos álbuns existentes
	 * @return
	 */
	Set<String> getAlbumsNames();

}
