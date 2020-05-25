
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

	public int larguraGeracao(int nivel) {
		return larguraGeracao(raiz, nivel);

	}

	public int larguraGeracao(No raiz, int nivel) {
		if (raiz == null) {
			return 0;
		}
		if (nivel == 1) {
			return 1;
		}
		return larguraGeracao(raiz.getEsq(), nivel - 1) + larguraGeracao(raiz.getDir(), nivel - 1);
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

	@Override
	public void listarAteGeracao(int nivel) {
		listarAteGeracao(raiz, nivel);
	}

	private void listarAteGeracao(No raiz, int nivel) {
		if (nivel > 0) {
			System.out.print("\n" + raiz.getElemento().toString() + " ");
			listarAteGeracao(raiz.getEsq(), nivel - 1);
			listarAteGeracao(raiz.getDir(), nivel - 1);
		}
	}

	@Override
	public void listarGeracao(int nivel) {
		listarGeracao(raiz, nivel);
	}

	private void listarGeracao(No raiz, int nivel) {
		if (raiz != null) {
			if (nivel != 1) {
				listarGeracao(raiz.getEsq(), nivel - 1);
				listarGeracao(raiz.getDir(), nivel - 1);
			} else {
				System.out.print("\n" + raiz.getElemento().toString() + " ");
			}
		}
	}

	@Override
	public void inserir(int id, String nome, int idade) throws IllegalArgumentException {
		if (raiz != null)
			inserir(raiz, id, nome, idade);
		else
			raiz = new No(new Elemento(id, nome, idade));
	}

	public void inserir(No raiz, int id, String nome, int idade) {
		if (id < raiz.getElemento().getId()) {
			if (raiz.getEsq() != null) {
				inserir(raiz.getEsq(), id, nome, idade);
			} else {
				raiz.setEsq(new No(new Elemento(id, nome, idade)));
			}
		} else if (id > raiz.getElemento().getId()) {
			if (raiz.getDir() != null) {
				inserir(raiz.getDir(), id, nome, idade);
			} else {
				raiz.setDir(new No(new Elemento(id, nome, idade)));
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

}