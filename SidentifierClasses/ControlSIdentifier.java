package model;

public class ControlSIdentifier {
	
	BDProfil LaBD=BDProfil.getInstance();
	
	public Profil SIdentifier(String id,String mdp)
	{
		return LaBD.connexion(id,mdp);
	}

}
