package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BDImage {
	
	Map<Integer,DescripteurImage> listeDescripteurImage=new HashMap<>();
	
    private static class BDImageHolder
    {
        private final static BDImage instance=new BDImage();
    }

    public static BDImage getInstance()
    {
        return BDImageHolder.instance;
    }
    
    public  void ajouterDescripteurImage(DescripteurImage descripteur)
    {
        this.listeDescripteurImage.put(listeDescripteurImage.size(),descripteur);
    }
    
    public DescripteurImage getDescripteurImage(int id)
    {
    	return this.listeDescripteurImage.get(id);
    }

	@Override
	public String toString() {
		return "BDImage [listeDescripteurImage=" + listeDescripteurImage + "]";
	}
    
    

}
