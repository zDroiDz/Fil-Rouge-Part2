package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import model.BDHistorique;
import model.Descripteur;
import model.Profil;



public class ControlHistorique {

	private BDHistorique BDhistorique = BDHistorique.getInstance();
	
	private static final String PATH_LISTE_PROFIL= System.getProperty("user.dir")+"/src/model/profils/liste_profils.txt";
	
	public ControlHistorique() {
		
	}
	
	public List<String> consulterHistoriqueRecherche(int idHistorique){
		return BDhistorique.getResultatsRecherche(idHistorique);
	}
	
	public List<String> consulterListeRecherche(){
		return BDhistorique.getListeRecherche();
	}

	public void ajouterHistorique(String requeteRecherche, List<String> resultatRecherche) {
		BDhistorique.ajouterRecherche(requeteRecherche, resultatRecherche);
	}
	
	public String toString() {
		return ("Affichage BD : " + BDhistorique.toString() + "\n");
	}
	
	public void clearBDHistorique() {
		BDhistorique.viderBD();
	}
	
	public void FillBDHistorique(Profil profil)
	{
		String keyword="";
		
		try{
			/*cr�ation des ressources necessaires*/
			
    		InputStream flux=new FileInputStream(PATH_LISTE_PROFIL); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		while ((ligne=buff.readLine())!=null){
		
				if(ligne.contains(profil.getIdentifiant()))
				{
					String chaine = "";
					String[] gros=ligne.split("<historique>");
					String[] decoup=gros[1].split("\\|");
					
					for(int i=0;i<decoup.length-1;i++)
					{
						ArrayList<String> arrayList=new ArrayList<>();
						
						String[] motcle=decoup[i].split(":");
						arrayList.add(motcle[1]);
						BDhistorique.ajouterRecherche(motcle[0], arrayList);
						
					}
					
					
				}
				
    			
    			
    		}
    		buff.close(); 
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
	}

	
}
