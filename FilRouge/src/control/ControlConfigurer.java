package control;

import model.BDMoteur;
import model.Moteur;

public class ControlConfigurer {
private BDMoteur bdMoteur=BDMoteur.getInstance();
public ControlConfigurer(){
	
}

public void creerMoteur(int nbOccTxt,int  nbEch,int nbIntervallle,int nbBitsCouleur){
	Moteur moteurCreer=new Moteur();
	bdMoteur.ajouterMoteur(moteurCreer);
	
}


}
