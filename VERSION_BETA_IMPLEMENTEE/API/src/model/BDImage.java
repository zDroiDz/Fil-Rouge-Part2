package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import control.ControlIndexationImage;
import sun.security.krb5.internal.crypto.Des;


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
    
    public Map<Integer,DescripteurImage> getListeDescripteurImage(){
    	return this.listeDescripteurImage;
    }

	@Override
	public String toString() {
		return "BDImage [listeDescripteurImage=" + listeDescripteurImage + "]";
	}
	
	
	
}