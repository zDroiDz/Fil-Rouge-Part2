package model;

public abstract class Descripteur {
	
	protected String path;
	protected int id;
	protected String nomFichier;
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the nomFichier
	 */
	public String getNomFichier() {
		return nomFichier;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param nomFichier the nomFichier to set
	 */
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	@Override
	public String toString() {
		return "Descripteur [path=" + path + ", id=" + id + ", nomFichier=" + nomFichier + "]";
	}

}