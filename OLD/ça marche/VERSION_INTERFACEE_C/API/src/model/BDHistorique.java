package model;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDHistorique {
	
	//2 Hasmap : Une corresponds � la requette, l'autre au r�sultats de recherche
	protected static Map<Integer,String> listeRequeteRecherche = new HashMap<>();
	protected static Map<Integer,List<String>> listeResultatRecherche = new HashMap<>();

  

    private static class BDHistoriqueHolder
    {
        private final static BDHistorique instance=new BDHistorique();
    }

    public static BDHistorique getInstance()
    {
        return BDHistoriqueHolder.instance;
    }

    public  void ajouterRecherche(String recherche, List<String> resultatRecherche)
    {
    	listeRequeteRecherche.put(listeRequeteRecherche.size(), recherche);
        listeResultatRecherche.put(listeResultatRecherche.size(),resultatRecherche);
    }

    
    public List<String> getResultatsRecherche(int idHistorique)
    {
        return listeResultatRecherche.get(idHistorique);
    }
    
	public List<String> getListeRecherche() {
		ArrayList<String> retour = new ArrayList<>();
		
		for (Map.Entry<Integer, String> entry : listeRequeteRecherche.entrySet())
		{
		    retour.add(entry.getKey() + " : " + entry.getValue());
		}
		return retour;
	}
	
	public void viderBD() {
		this.listeRequeteRecherche.clear();
		this.listeResultatRecherche.clear();
	}

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
