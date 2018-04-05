package vuetextuelle;

import java.util.Scanner;

import control.ControlDescripteurs;

public class BoundaryVisualiserDescripteurs {
	
	private ControlDescripteurs controlDescripteurs;
	public BoundaryVisualiserDescripteurs(ControlDescripteurs controlDescripteurs)
	{
		this.controlDescripteurs=controlDescripteurs;
	}
	
	public void visualiserDescripteurs()
	{
		Scanner sc=new Scanner(System.in);
		int choix;
		do
		{
			System.out.println("Quels descripteurs voulez-vous visualiser\n1) Texte\n2) Son\n3) Image");
			choix=sc.nextInt();
			
			switch (choix) {
			case 1:
				System.out.println(this.controlDescripteurs.visualiserDescripteursTexte());
				break;
			case 2:
				System.out.println(this.controlDescripteurs.visualiserDescripteursSon());
				break;
			case 3:
				System.out.println(this.controlDescripteurs.visualiserDescripteursImage());
				break;
	
			default:
				System.out.println("Saisie incorrecte, veuillez recommencer");
				break;
			}
		}while(choix!=1 && choix!=2 && choix!=3 );
	}
	

}
