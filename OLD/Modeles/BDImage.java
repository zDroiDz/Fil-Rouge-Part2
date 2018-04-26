package model;

import java.util.HashMap;
import java.util.Map;


public class BDImage {
	
	Map<Integer,DescripteurImage> listeDescripteursImage;

    private BDImage()
    {
        this.listeDescripteursImage=new HashMap<>();
    }

    private static class BDImageHolder
    {
        private final static BDImage instance=new BDImage();
    }

    public static BDImage getInstance()
    {
        return BDImageHolder.instance;
    }

    public DescripteurImage getDescripteurImage(int numDesc)
    {
        return listeDescripteursImage.get(numDesc);
    }


    public  void ajouterDescripteurImage(DescripteurImage descripteur)
    {
        this.listeDescripteursImage.put(listeDescripteursImage.size(),descripteur);

    }

    public String toString()
    {
        return listeDescripteursImage.toString();
    }

}
