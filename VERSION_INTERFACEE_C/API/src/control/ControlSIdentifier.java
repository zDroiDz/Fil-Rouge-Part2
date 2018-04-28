package control;

import model.BDProfil;
import model.Profil;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlSIdentifier.
 */
public class ControlSIdentifier {
	
	/** The La BD. */
	BDProfil LaBD=BDProfil.getInstance();
	
	/**
	 * S identifier.
	 *
	 * @param id the id
	 * @param mdp the mdp
	 * @return the profil
	 */
	public Profil SIdentifier(String id,String mdp)
	{
		return LaBD.connexion(id,mdp);
	}
	
}
