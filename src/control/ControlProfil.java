package control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.BDProfil;
import model.DescripteurTexte;

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
}
