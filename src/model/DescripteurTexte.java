package model;

import java.util.HashMap;
import java.util.Map;

public class DescripteurTexte extends Descripteur {
	
private Map<String,Integer> map;
	
	public DescripteurTexte() {
		// TODO Auto-generated constructor stub
		this.map=new HashMap<>();
	}
	
	public void addContent(int nbOccurences,String word)
	{
		this.map.put(word, nbOccurences);
	}
	@Override
	public String toString() {
		return "DescripteurImage [map=" + map + "]";
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