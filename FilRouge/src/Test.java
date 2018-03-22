import control.ControlCreerProfil;
import vueTextuelle.BoundaryCreerProfil;


public class Test {

	
	public static void main(String[] args)
	{
		ControlCreerProfil controlCreerProfil =new ControlCreerProfil();
		BoundaryCreerProfil boundaryCreerProfil =new BoundaryCreerProfil(controlCreerProfil);
		boundaryCreerProfil.creerProfil();
	}
}
