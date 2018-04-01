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

    
    public List<DescripteurTexte> getDescripteurs(String motCle,int seuil){
    	List<DescripteurTexte> listeDescripteursRecherche =new ArrayList<>();
    	List<String> voulu = new ArrayList<>();
    	List<String> nonVoulu = new ArrayList<>();
    	List<Integer> indices = new ArrayList<>();
    	String[] decompose = motCle.split(" ");
    	
    	
    	for(int i = 0 ; i< decompose.length ; i++){
    		if(decompose[i].charAt(0) == '-'){
    			nonVoulu.add(decompose[i].substring(1));
    		}else{
    			voulu.add(decompose[i]);
    		}
    	}
    	
    	
    	for(DescripteurTexte d: this.listeDescripteursTexte.values())
    	{
    		for(String s : voulu){
	    		if(d.checkSeuil(s, seuil))
	    		{
	    			listeDescripteursRecherche.add(d);
	    		}
    		}
    	}
    	
    	int cpt = 0 ;
    	boolean continuer = true ;
    	for(DescripteurTexte d : listeDescripteursRecherche){
    		for(String s : nonVoulu){
    			if(d.exists(s) && continuer == true){
    				indices.add(cpt);
    				continuer = false ;
    			}
    		}
    		continuer = true ;
    		cpt++ ;
    	}
    	
    	for(int i : indices){
    		System.out.println(i);
    		listeDescripteursRecherche.remove(i);
    	}
    	
    	return listeDescripteursRecherche;
    }
    
    
    
    
    public String toString()
    {
        return listeDescripteursTexte.toString();
    }

}