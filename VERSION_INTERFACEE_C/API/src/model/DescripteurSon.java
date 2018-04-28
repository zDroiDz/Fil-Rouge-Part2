package model;

// TODO: Auto-generated Javadoc
/**
 * The Class DescripteurSon.
 */
public class DescripteurSon extends Descripteur {
	
	/** The tab. */
	private int tab[][];
	
	
	/**
	 * Instantiates a new descripteur son.
	 */
	public DescripteurSon() {
		this.tab = new int[2000][2000];
	}
	
	/**
	 * permet de mettre le tableau a sa "vraie" taille .
	 *
	 * @param ligne the ligne
	 * @param colonne the colonne
	 */
	public void setSize(int ligne, int colonne){
		int[][] temp = new int[ligne][colonne] ;
		for(int i  = 0 ; i < ligne ; i++){
			for(int j = 0 ; j < colonne ; j++){
				temp[i][j] = this.tab[i][j];
			}
		}
		this.tab= temp; 
	}
	
	/**
	 * Gets the nb lignes.
	 *
	 * @return the nb lignes
	 */
	public int getNbLignes(){
		return this.tab.length;
	}
	
	/**
	 * Gets the nb colonnes.
	 *
	 * @return the nb colonnes
	 */
	public int getNbColonnes(){
		return this.tab[1].length;
	}
	
	/**
	 * Adds the content.
	 *
	 * @param ligne the ligne
	 * @param colonne the colonne
	 * @param val the val
	 */
	public void addContent(int ligne, int colonne, int val)
	{
		this.tab[ligne][colonne] = val;
	}

	/* (non-Javadoc)
	 * @see model.Descripteur#toString()
	 */
	@Override
	public String toString() {
		String retour = "" ;
		
		for(int i = 0 ; i < this.tab.length ; i++){
			for(int j = 0 ; j < this.tab[1].length ; j++){
				retour += Integer.toString(this.tab[i][j]) + " ";
			}
			retour+="\n";
		}
		
		return retour ;
	}

}
