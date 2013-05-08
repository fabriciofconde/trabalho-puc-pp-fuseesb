/**
 * 
 */
package puc.pp.portalacademico.dominio;

/**
 * 
 *
 */
public class Aluno {

	private long id;
	private String nome;
	
	/**
	 * @param id
	 * @param nome
	 */
	public Aluno(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}

	public static void definirAlunoAutenticado(Aluno aluno) {
		ALUNO_AUTENTICADO = aluno;
	}
	
	public static Aluno obterAlunoAutenticado() {
		return ALUNO_AUTENTICADO;
	}
	
	private static Aluno ALUNO_AUTENTICADO = null;
	
}
