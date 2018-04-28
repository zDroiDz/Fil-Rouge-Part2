package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Moteur.
 */
public class Moteur {
	
	/** The nb occ txt. */
	private int nbOccTxt;
	
	/** The nb ech. */
	private int  nbEch ;
	
	/** The nb intervallle. */
	private int nbIntervallle;
	
	/** The nb bits couleur. */
	private int nbBitsCouleur;
	
	/**
	 * Instantiates a new moteur.
	 *
	 * @param nbOccTxt the nb occ txt
	 * @param nbEch the nb ech
	 * @param nbIntervallle the nb intervallle
	 * @param nbBitsCouleur the nb bits couleur
	 */
	public Moteur(int nbOccTxt,int  nbEch,int nbIntervallle,int nbBitsCouleur){
		this.nbOccTxt=nbOccTxt;
		this.nbEch=nbEch;
		this.nbIntervallle=nbIntervallle;
		this.nbBitsCouleur=nbBitsCouleur;
	}
}
