package model;

public class DescripteurSon extends Descripteur {
	
	private int tab[][];
	
	
	public DescripteurSon() {
		this.tab = new int[10000][10000];
	}
	
	/**
	 * permet de mettre le tableau a sa "vraie" taille 
	 * @param ligne
	 * @param colonne
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
	
	public int getNbLignes(){
		return this.tab.length;
	}
	public int getNbColonnes(){
		return this.tab[1].length;
	}
	
	public void addContent(int ligne, int colonne, int val)
	{
		this.tab[ligne][colonne] = val;
	}

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
