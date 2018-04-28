package model;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class DescripteurTexte.
 */
public class DescripteurTexte extends Descripteur {
	
/** The map. */
private Map<String,Integer> map;
	
	/**
	 * Instantiates a new descripteur texte.
	 *
	 * @param id the id
	 * @param path the path
	 */
	public DescripteurTexte(int id,String path) {
		// TODO Auto-generated constructor stub
		this.map=new HashMap<>();
		this.setId(id);
	}
	
	/**
	 * Adds the content.
	 *
	 * @param word the word
	 * @param nbOccurences the nb occurences
	 */
	public void addContent(String word,int nbOccurences)
	{
		this.map.put(word, nbOccurences);
	}
	
	/* (non-Javadoc)
	 * @see model.Descripteur#toString()
	 */
	@Override
	public String toString() {
		return "DescripteurTexte [map=" + map + "]"+super.toString();
	}
	
	/**
	 * Exists.
	 *
	 * @param motCle the mot cle
	 * @return true, if successful
	 */
	public boolean exists(String motCle){
		return this.map.containsKey(motCle);
	}

	/**
	 * Check seuil.
	 *
	 * @param motCle the mot cle
	 * @param seuil the seuil
	 * @return true, if successful
	 */
	public boolean checkSeuil(String motCle, int seuil) 
	{
		if(this.map.containsKey(motCle)){
			if(this.map.get(motCle)>=seuil)
			{
				return true;
			}
		}
		
		return false;
	}
}