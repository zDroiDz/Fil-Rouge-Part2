package control;

public class ControlChangerModeRecherche {

	private boolean modeOuvert = false ;
	
	public void setMode(int choix){
		if(choix == 1 && this.modeOuvert != true){
			this.modeOuvert = true ;
			
		}else if(choix == 2 && this.modeOuvert != false){
			this.modeOuvert = false ;
		}
		
		if(this.modeOuvert){
			System.out.println("Le mode actuel est : ouvert !");
		}else{
			System.out.println("Le mode actuel est : fermé !");
		}
	}

}
