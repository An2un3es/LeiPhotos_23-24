package leiphotos.domain.core.views;

import leiphotos.domain.facade.ViewsType;

//Class automatically generated so the code compiles
//CHANGE ME

public interface IViewsCatalog {
	
    /**
     * Dá a vista no catálogo com um determinado tipo
     *
     * @param t o tipo da vista
     * @return a vista da biblioteca com o tipo especificado.
     */
    ILibraryView getView(ViewsType t);
}
