package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Admin;
import model.BDProfil;
import model.DescripteurTexte;
import model.Profil;
import model.Utilisateur;

public class ControlProfil {
	
	private static final String PATH_LISTE_PROFIL= System.getProperty("user.dir")+"/src/model/profils/liste_profils.txt";
	
	
	private BDProfil bdProfil=BDProfil.getInstance();
	
	public void FillBDProfils()
	{

		try{
			/*création des ressources necessaires*/
    		InputStream flux=new FileInputStream(PATH_LISTE_PROFIL); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		while ((ligne=buff.readLine())!=null){
    			String[] tab=ligne.split(" ");
    			
    			/*login*/
    			String login=tab[2];
    			
    			/*mdp*/
    			String mdp=tab[5];
    			
    			/*type*/
    			String type=tab[8];
    			String[] nomPrenom=login.split("\\.");
		
    			switch (type) {
				case "utilisateur":
					Utilisateur ut=new Utilisateur(nomPrenom[0], nomPrenom[1], mdp);
					bdProfil.ajouterUtilisateur(ut);
					break;
				case "administrateur":
					Admin ad=new Admin(nomPrenom[0], nomPrenom[1], mdp);
					bdProfil.ajouterUtilisateur(ad);
					break;
				}
    		}
    		buff.close(); 
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
	}
	
	public void addProfil(Profil profil){
		try(FileWriter fw = new FileWriter(PATH_LISTE_PROFIL, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				if(profil.isAdmin()){
				    out.println("<profil> <identifiant> "+profil.getIdentifiant()+" </identifiant> <password> "+profil.getMDP()+" </password> <type> administrateur </type> <historique> </historique> </profil>");

				}else{
				    out.println("<profil> <identifiant> "+profil.getIdentifiant()+" </identifiant> <password> "+profil.getMDP()+" </password> <type> utilisateur </type> <historique> </historique> </profil>");
				}
			   
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
				e.printStackTrace();
			}
	}
	
	public void addHistoricContent(Profil profil,String historiqueContent)
	{
		ArrayList<String> fileContent=new ArrayList<>();
		try{
			/*création des ressources necessaires*/
			
    		InputStream flux=new FileInputStream(PATH_LISTE_PROFIL); 
    		InputStreamReader lecture=new InputStreamReader(flux);
    		BufferedReader buff=new BufferedReader(lecture);
    		String ligne;
    		while ((ligne=buff.readLine())!=null){
    			
    			if(ligne.contains(profil.getIdentifiant()))
    			{
    				String chaine = "";
    				String[] content=ligne.split(" ");
    				
    				for(int i=0;i<11;i++)
    				{
    					chaine+=content[i]+" ";
    				}
    				
    				chaine+=historiqueContent+" ";
    				
    				for(int i=11;i<content.length;i++)
    				{
    					chaine+=content[i]+" ";
    				}
    					
    				fileContent.add(chaine);
    				
    			}
    			else
    			{
    				fileContent.add(ligne);
    			}
    			
    		}
    		buff.close(); 
    		}		
    		catch (Exception e){
    		System.out.println(e.toString());
    		}
		
		System.out.println(fileContent.toString());
		
		try(FileWriter fw = new FileWriter(PATH_LISTE_PROFIL);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
		
			{
					for(int i=0;i<fileContent.size();i++)
					{
						out.println(fileContent.get(i)+";");
					}
				    
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
				e.printStackTrace();
			}
	}
}
