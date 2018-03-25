package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BDImage {
	
	/*Map<Integer,DescripteurImage> listeDescripteursImage;

    private BDImage()
    {
        this.listeDescripteursImage=new HashMap<>();
    }
*/
	
	List<DescripteurImage> tabR = new ArrayList<>() ;
	List<DescripteurImage> tabG = new ArrayList<>() ;
	List<DescripteurImage> tabB = new ArrayList<>() ;
	
		
	
    private static class BDImageHolder
    {
        private final static BDImage instance=new BDImage();
    }

    public static BDImage getInstance()
    {
        return BDImageHolder.instance;
    }
    
    public List<DescripteurImage> getDescripteurs(int couleur, int seuil) {
		// TODO Auto-generated method stub
    	
    	List<DescripteurImage> listImage = new ArrayList<>();
    	
    	switch(couleur){
    		case 1:
    			for(DescripteurImage d : this.tabR){
    				if(d.checkPlage(seuil)){
    					listImage.add(d);
    				}
    			}
    			break;
    		case 2 :
    			for(DescripteurImage d : this.tabG){
    				if(d.checkPlage(seuil)){
    					listImage.add(d);
    				}
    			}
    			break ;
    		case 3 :
    			for(DescripteurImage d : this.tabB){
    				if(d.checkPlage(seuil)){
    					listImage.add(d);
    				}
    			}
    			break ;
    	}
    	
    	return listImage ;	
    	
	}
    
    
    
    public void addTabR(DescripteurImage d){
    	this.tabR.add(d);
    }
    
    public void addTabB(DescripteurImage d){
    	this.tabB.add(d);
    }
    
    public void addTabG(DescripteurImage d){
    	this.tabG.add(d);
    }
    
    

}
