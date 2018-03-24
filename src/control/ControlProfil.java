package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import model.BDProfil;
import model.DescripteurTexte;
import model.Profil;

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
    			System.out.println(tab[2]);
    			
    			/*mdp*/
    			System.out.println(tab[5]);
    			
    			/*type*/
    			System.out.println(tab[8]);
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
				if(profil.getAdmin()){
				    out.println("<profil> <identifiant> "+profil.getIdentifiant()+" </identifiant> <password> "+profil.getMDP()+" </password> <type> administrateur </type> </profil>");

				}else{
				    out.println("<profil> <identifiant> "+profil.getIdentifiant()+" </identifiant> <password> "+profil.getMDP()+" </password> <type> utilisateur </type> </profil>");
				}
			   
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
				e.printStackTrace();
			}
	}
}
