
/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public class No {

	private Elemento elemento;
	private No esq;
	private No dir;

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public No getEsq() {
		return esq;
	}

	public void setEsq(No esq) {
		this.esq = esq;
	}

	public No getDir() {
		return dir;
	}

	public void setDir(No dir) {
		this.dir = dir;
	}

	public No(Elemento elemento) {

		this.elemento = elemento;
	}

}
