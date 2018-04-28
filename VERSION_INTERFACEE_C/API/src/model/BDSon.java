package model;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BDSon.
 */
public class BDSon {
	
	/** The liste descripteurs son. */
	Map<Integer,DescripteurSon> listeDescripteursSon;

    /**
     * Instantiates a new BD son.
     */
    private BDSon()
    {
        this.listeDescripteursSon=new HashMap<>();
    }

    /**
     * The Class BDSonHolder.
     */
    private static class BDSonHolder
    {
        
        /** The Constant instance. */
        private final static BDSon instance=new BDSon();
    }

    /**
     * Gets the single instance of BDSon.
     *
     * @return single instance of BDSon
     */
    public static BDSon getInstance()
    {
        return BDSonHolder.instance;
    }

    /**
     * Gets the descripteur son.
     *
     * @param numDesc the num desc
     * @return the descripteur son
     */
    public DescripteurSon getDescripteurSon(int numDesc)
    {
        return listeDescripteursSon.get(numDesc);
    }


    /**
     * Ajouter descripteur son.
     *
     * @param descripteur the descripteur
     */
    public  void ajouterDescripteurSon(DescripteurSon descripteur)
    {
        this.listeDescripteursSon.put(listeDescripteursSon.size(),descripteur);

    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String retour = ""; 
		
		for(DescripteurSon ds : this.listeDescripteursSon.values()){
			System.out.println("\n Descripteur \n");
			System.out.println(ds.toString());
		}
		
		return retour ;
	}

    

}
