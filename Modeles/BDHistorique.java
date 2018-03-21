package Modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDHistorique {
	
	//2 Hasmap : Une corresponds à la requette, l'autre au résultats de recherche
	Map<Integer,String> listeRequeteRecherche;
	Map<Integer,ArrayList<String>> listeResultatRecherche;

    private BDHistorique()
    {
        this.listeResultatRecherche=new HashMap<>();
    }

    private static class BDHistoriqueHolder
    {
        private final static BDHistorique instance=new BDHistorique();
    }

    public static BDHistorique getInstance()
    {
        return BDHistoriqueHolder.instance;
    }

    public  void ajouterRecherche(String recherche, ArrayList<String> resultatRecherche)
    {
    	this.listeRequeteRecherche.put(listeRequeteRecherche.size(), recherche);
        this.listeResultatRecherche.put(listeResultatRecherche.size(),resultatRecherche);
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

    public String toString()
    {
    	String retour = "";
    	
    	//Note : Pas d'utilisation d'iterator, car parcourir 2 listes en même temps
    	for(int i =0;i<=listeRequeteRecherche.size();i++) {
    		retour =  "Requete : " + listeRequeteRecherche.get(i) + ",Resultats : " + listeResultatRecherche.get(i).toString() + "\n";
    	}
    	
    	return retour;
    }



}
