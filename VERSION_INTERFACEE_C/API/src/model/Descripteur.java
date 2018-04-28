package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Descripteur.
 */
public abstract class Descripteur {
	
	/** The path. */
	protected String path;
	
	/** The id. */
	protected int id;
	
	/** The nom fichier. */
	protected String nomFichier;
	
	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Gets the nom fichier.
	 *
	 * @return the nomFichier
	 */
	public String getNomFichier() {
		return nomFichier;
	}
	
	/**
	 * Sets the path.
	 *
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the nom fichier.
	 *
	 * @param nomFichier the nomFichier to set
	 */
	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Descripteur [path=" + path + ", id=" + id + ", nomFichier=" + nomFichier + "]";
	}

}