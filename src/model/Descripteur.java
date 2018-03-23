package model;

public abstract class Descripteur {
	
	private String path;
	private int id;
	private String nomFichier;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomFichier() {
		return nomFichier;
	}
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	@Override
	public String toString() {
		return "Descripteur [path=" + path + ", id=" + id + ", nomFichier=" + nomFichier + "]";
	}

}