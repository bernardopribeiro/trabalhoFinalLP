
/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public class FamilyTree implements IFamilyTree {

	private No raiz;

	public FamilyTree(No raiz) {
		// TODO Auto-generated constructor stub
		this.raiz = raiz;
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
			if (raiz.getDir() != null && raiz.getEsq() != null) {
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

	@Override
	public int larguraNivel(int nivel) {
		return larguraNivel(raiz, nivel);

	}

	public int larguraNivel(No raiz, int nivel) {
		if (raiz == null) {
			return 0;
		}
		if (nivel == 1) {
			return 1;
		}
		return larguraNivel(raiz.getEsq(), nivel - 1) + larguraNivel(raiz.getDir(), nivel - 1);
	}

	@Override
	public boolean existe(String nome, int idade) {
		return existe(raiz, idade, nome);
	}

	private boolean existe(No raiz, int idade, String nome) {
		if (raiz == null)
			return false;

		if (raiz.getElemento().getIdade() == idade && raiz.getElemento().getNome().equals(nome))
			return true;

		boolean res1 = existe(raiz.getEsq(), idade, nome);
		if (res1)
			return true;

		boolean res2 = existe(raiz.getDir(), idade, nome);

		return res2;
	}

}