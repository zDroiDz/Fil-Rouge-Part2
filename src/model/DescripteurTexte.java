package model;

import java.util.HashMap;
import java.util.Map;

public class DescripteurTexte extends Descripteur {
	
private Map<String,Integer> map;
	
	public DescripteurTexte(int id,String path) {
		// TODO Auto-generated constructor stub
		this.map=new HashMap<>();
		this.setId(id);
	}
	
	public void addContent(String word,int nbOccurences)
	{
		this.map.put(word, nbOccurences);
	}
	
	@Override
	public String toString() {
		return "DescripteurTexte [map=" + map + "]"+super.toString();
	}

	public boolean checkSeuil(String motCle, int seuil) 
	{
		if(this.map.get(motCle)>=seuil)
		{
			return true;
		}
		return false;
	}
}