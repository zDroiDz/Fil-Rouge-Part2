package model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BDHistorique.
 */
public class BDHistorique {
	
	/** The liste requete recherche. */
	//2 Hasmap : Une corresponds � la requette, l'autre au r�sultats de recherche
	protected static Map<Integer,String> listeRequeteRecherche = new HashMap<>();
	
	/** The liste resultat recherche. */
	protected static Map<Integer,List<String>> listeResultatRecherche = new HashMap<>();

  

    /**
     * The Class BDHistoriqueHolder.
     */
    private static class BDHistoriqueHolder
    {
        
        /** The Constant instance. */
        private final static BDHistorique instance=new BDHistorique();
    }

    /**
     * Gets the single instance of BDHistorique.
     *
     * @return single instance of BDHistorique
     */
    public static BDHistorique getInstance()
    {
        return BDHistoriqueHolder.instance;
    }

    /**
     * Ajouter recherche.
     *
     * @param recherche the recherche
     * @param resultatRecherche the resultat recherche
     */
    public  void ajouterRecherche(String recherche, List<String> resultatRecherche)
    {
    	listeRequeteRecherche.put(listeRequeteRecherche.size(), recherche);
        listeResultatRecherche.put(listeResultatRecherche.size(),resultatRecherche);
    }

    
    /**
     * Gets the resultats recherche.
     *
     * @param idHistorique the id historique
     * @return the resultats recherche
     */
    public List<String> getResultatsRecherche(int idHistorique)
    {
        return listeResultatRecherche.get(idHistorique);
    }
    
	/**
	 * Gets the liste recherche.
	 *
	 * @return the liste recherche
	 */
	public List<String> getListeRecherche() {
		ArrayList<String> retour = new ArrayList<>();
		
		for (Map.Entry<Integer, String> entry : listeRequeteRecherche.entrySet())
		{
		    retour.add(entry.getKey() + " : " + entry.getValue());
		}
		return retour;
	}
	
	/**
	 * Vider BD.
	 */
	public void viderBD() {
		this.listeRequeteRecherche.clear();
		this.listeResultatRecherche.clear();
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
    	String retour = "";
    	
    	//Note : Pas d'utilisation d'iterator, car parcourir 2 listes en m�me temps
    	if(listeRequeteRecherche.size() != 0) {
	    	for(int i =0;i<listeRequeteRecherche.size();i++) {
	    		retour +=  "Requete : " + listeRequeteRecherche.get(i) + ",Resultats : " + String.valueOf(listeResultatRecherche.get(i).toString()) + "\n";
	    	}
    	}
    	return retour;
    }



}
