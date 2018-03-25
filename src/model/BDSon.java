package model;

import java.util.HashMap;
import java.util.Map;

public class BDSon {
	
	Map<Integer,DescripteurSon> listeDescripteursSon;

    private BDSon()
    {
        this.listeDescripteursSon=new HashMap<>();
    }

    private static class BDSonHolder
    {
        private final static BDSon instance=new BDSon();
    }

    public static BDSon getInstance()
    {
        return BDSonHolder.instance;
    }

    public DescripteurSon getDescripteurSon(int numDesc)
    {
        return listeDescripteursSon.get(numDesc);
    }


    public  void ajouterDescripteurSon(DescripteurSon descripteur)
    {
        this.listeDescripteursSon.put(listeDescripteursSon.size(),descripteur);

    }

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
