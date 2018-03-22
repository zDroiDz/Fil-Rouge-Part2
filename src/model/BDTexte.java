package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDTexte {
	
	Map<Integer,DescripteurTexte> listeDescripteursTexte;

    private BDTexte()
    {
        this.listeDescripteursTexte=new HashMap<>();
    }

    private static class BDTexteHolder
    {
        private final static BDTexte instance=new BDTexte();
    }

    public static BDTexte getInstance()
    {
        return BDTexteHolder.instance;
    }

    public DescripteurTexte getDescripteurTexte(int numDesc)
    {
        return listeDescripteursTexte.get(numDesc);
    }


    public  void ajouterDescripteurTexte(DescripteurTexte descripteur)
    {
        this.listeDescripteursTexte.put(listeDescripteursTexte.size(),descripteur);

    }

    
    public List<String> getDescripteurs(String motCle,int seuil){
    	List<String> listeDescripteursRecherche =new ArrayList<>();
    	
    	for(DescripteurTexte d: this.listeDescripteursTexte.values())
    	{
    		if(d.checkSeuil(motCle, seuil))
    		{
    			listeDescripteursRecherche.add(d.toString());
    		}
    	}
    	
    	return listeDescripteursRecherche;
    }
    
    
    
    
    public String toString()
    {
        return listeDescripteursTexte.toString();
    }

}