
/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public class FamilyTree implements IFamilyTree {

	private No raiz;

	public FamilyTree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int numeroElementos() {
		return numeroElementos(raiz);
	}

	private int numeroElementos(No raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return 1 + numeroElementos(raiz.getEsq()) + numeroElementos(raiz.getDir());
		}
	}

	@Override
	public int maisVelho() {
		return maisVelho(raiz);
	}

	private int maisVelho(No raiz) {

		int resposta = 0;

		if (raiz != null) {
			if (raiz.getDir() != null) {
				resposta = maisVelho(raiz.getDir());
				resposta = maisVelho(raiz.getEsq());
				resposta = raiz.getElemento().getIdade();

			}
			return resposta;
		}

		return Integer.MIN_VALUE;

	}

	public int maisNovo() {
		return maisNovo(raiz);
	}

	private int maisNovo(No raiz) {
		if (raiz != null) {
			if (raiz.getEsq() != null) {
				return maisNovo(raiz.getEsq());

			}
			if (raiz.getDir() != null) {
				return maisNovo(raiz.getDir());
			} else {
				return raiz.getElemento().getIdade();
			}
		} else {
			return Integer.MAX_VALUE;
		}
	}

	@Override
	public int alturaArvore() {
		return alturaArvore(raiz);
	}

	private int alturaArvore(No raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return 1 + Math.max(alturaArvore(raiz.getEsq()), alturaArvore(raiz.getDir()));
		}
	}
}