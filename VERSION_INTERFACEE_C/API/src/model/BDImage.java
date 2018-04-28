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


// TODO: Auto-generated Javadoc
/**
 * The Class BDImage.
 */
public class BDImage {
	
	/** The liste descripteur image. */
	Map<Integer,DescripteurImage> listeDescripteurImage=new HashMap<>();
	
    /**
     * The Class BDImageHolder.
     */
    private static class BDImageHolder
    {
        
        /** The Constant instance. */
        private final static BDImage instance=new BDImage();
    }

    /**
     * Gets the single instance of BDImage.
     *
     * @return single instance of BDImage
     */
    public static BDImage getInstance()
    {
        return BDImageHolder.instance;
    }
    
    /**
     * Ajouter descripteur image.
     *
     * @param descripteur the descripteur
     */
    public  void ajouterDescripteurImage(DescripteurImage descripteur)
    {
        this.listeDescripteurImage.put(listeDescripteurImage.size(),descripteur);
    }
    
    /**
     * Gets the descripteur image.
     *
     * @param id the id
     * @return the descripteur image
     */
    public DescripteurImage getDescripteurImage(int id)
    {
    	return this.listeDescripteurImage.get(id);
    }
    
    /**
     * Gets the liste descripteur image.
     *
     * @return the liste descripteur image
     */
    public Map<Integer,DescripteurImage> getListeDescripteurImage(){
    	return this.listeDescripteurImage;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BDImage [listeDescripteurImage=" + listeDescripteurImage + "]";
	}
	
	
	
}