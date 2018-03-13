package model;

import java.util.HashMap;
import java.util.Map;

public class DescripteurTexte extends Descripteur {
	
private Map<Integer,String> map;
	
	public DescripteurTexte() {
		// TODO Auto-generated constructor stub
		this.map=new HashMap<>();
	}
	
	public void addContent(int nbOccurences,String word)
	{
		this.map.put(nbOccurences, word);
	}

	@Override
	public String toString() {
		return "DescripteurImage [map=" + map + "]";
	}

}
