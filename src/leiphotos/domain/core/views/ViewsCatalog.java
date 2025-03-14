package leiphotos.domain.core.views;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import leiphotos.domain.core.Library;
import leiphotos.domain.core.MainLibrary;
import leiphotos.domain.core.TrashLibrary;
import leiphotos.domain.facade.IPhoto;
import leiphotos.domain.facade.ViewsType;

//Class automatically generated so the code compiles
//CHANGE ME
public class ViewsCatalog implements IViewsCatalog {
	
    private final Map<ViewsType, ILibraryView> viewsMap;

    
    public ViewsCatalog(MainLibrary mainLib, TrashLibrary trashLib) {
        viewsMap = new HashMap<>();
        viewsMap.put(ViewsType.ALL_MAIN, new MainLibraryView(mainLib, null));
        viewsMap.put(ViewsType.ALL_TRASH, new TrashLibraryView(trashLib, null));
    }
    
    @Override
    public ILibraryView getView(ViewsType t) {
        return viewsMap.get(t);
    }

    // Método para adicionar uma vista ao catálogo
    
    public void addView(ViewsType t, ILibraryView view) {
        viewsMap.put(t, view);
    }

    // Método para remover uma vista do catálogo
    
    public void removeView(ViewsType t) {
        viewsMap.remove(t);
    }

}
