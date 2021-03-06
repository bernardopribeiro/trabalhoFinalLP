
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

	/*
	 * ===================================================INSERIR===================
	 * ===================================
	 */

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

	/*
	 * ===================================================NUMERO DE
	 * ELEMENTOS======================================================
	 */

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

	/*
	 * ===================================================MAIS
	 * VELHO======================================================
	 */

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

	/*
	 * ===================================================MAIS
	 * NOVO======================================================
	 */

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

	/*
	 * ===================================================ALTURA
	 * ARVORE======================================================
	 */

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

	/*
	 * ===================================================LARGURA
	 * GERACAO======================================================
	 */

	public int larguraGeracao(No raiz, int nivel) {
		if (raiz == null) {
			return 0;
		}
		if (nivel == 1) {
			return 1;
		}
		return larguraGeracao(raiz.getEsq(), nivel - 1) + larguraGeracao(raiz.getDir(), nivel - 1);
	}

	/*
	 * ===================================================EXISTE====================
	 * ==================================
	 */

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

	/*
	 * ===================================================LISTAR ATE
	 * GERACAO======================================================
	 */

	@Override
	public void listarAteGeracao(int nivel) {
		listarAteGeracao(raiz, nivel);
	}

	public void listarAteGeracao(No raiz, int nivel) {

		if (raiz == null) {

			return;
		} else if (nivel >= 1) {
			listarAteGeracao(raiz.getEsq(), nivel - 1);
			System.out.println(raiz.getElemento().toString());
			listarAteGeracao(raiz.getDir(), nivel - 1);
		}
	}

	/*
	 * ===================================================LISTAR
	 * GERACAO======================================================
	 */

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

	/*
	 * ===================================================PRE-ORDEM=================
	 * =====================================
	 */

	@Override
	public String preOrder() {
		if (raiz == null) {
			return "Arvore Vazia";
		} else {
			return preOrder(raiz);
		}
	}

	private String preOrder(No raiz) {

		String resposta = "";

		if (raiz != null) {
			resposta += "\n" + raiz.getElemento().toString() + " ";
		}
		if (raiz.getEsq() != null) {
			resposta += preOrder(raiz.getEsq());
		}
		if (raiz.getDir() != null) {
			resposta += preOrder(raiz.getDir());
		}

		return resposta;
	}

	/*
	 * ===================================================IN-ORDER==================
	 * ====================================
	 */

	@Override
	public String inOrder() {
		if (raiz == null) {
			return "Arvore Vazia";
		} else {
			return inOrder(raiz);
		}
	}

	private String inOrder(No raiz) {

		String resposta = "";

		if (raiz != null) {
			resposta += inOrder(raiz.getEsq());
			resposta += "\n" + raiz.getElemento().toString() + " ";
			resposta += inOrder(raiz.getDir());
		}
		return resposta;
	}

	/*
	 * ===================================================POS-ORDER=================
	 * =====================================
	 */

	@Override
	public String posOrder() {
		if (raiz == null) {
			return "Arvore Vazia";
		} else {
			return posOrder(raiz);
		}
	}

	private String posOrder(No raiz) {

		String resposta = "";

		if (raiz != null) {
			resposta += posOrder(raiz.getEsq());
			resposta += posOrder(raiz.getDir());
			resposta += "\n" + raiz.getElemento().toString() + " ";
		}
		return resposta;
	}

	// ===================LISTAR POR NIVEL ===================

	@Override
	public void listarNiveis() {
		int nivel = alturaArvore();
		listarNiveis(nivel);
	}

	private void listarNiveis(int nivel) {
		for (int i = 1; i <= nivel; ++i) {
			System.out.println("\nLevel :" + i);
			listarGeracao(raiz, i);
			System.out.println("");
		}
	}

	// ===================LISTAR-LADO===================	 

	@Override
	public String listarLado(String lado) {
		if (raiz == null) {
			return "Arvore Vazia";
		} else {
			return listarLado(raiz, lado);
		}
	}

	private String listarLado(No raiz, String lado) {

		String resposta = "";

		if (raiz != null) {
			resposta += "\n" + raiz.getElemento().toString() + " ";
		}
		if (raiz.getEsq() != null && lado.equals("E")) {
			resposta += preOrder(raiz.getEsq());
		}
		if (raiz.getDir() != null && lado.equals("D")) {
			resposta += preOrder(raiz.getDir());
		}

		return resposta;
	}

	/*
	 * ===================================================REMOVER===================
	 * ===================================
	 */

	@Override
	public void remover(int id) {
		remover(raiz, id);
	}

	private No remover(No raiz, int id) {

		No pai = null;

		No atual = raiz;

		while (atual != null && atual.getElemento().getId() != id) {

			pai = atual;

			if (id < atual.getElemento().getId()) {
				atual = atual.getEsq();
			} else {
				atual = atual.getDir();
			}
		}

		if (atual == null) {
			return raiz;
		}

		if (atual.getEsq() == null && atual.getDir() == null) {

			if (atual != raiz) {
				if (pai.getEsq() == atual) {
					pai.setEsq(null);
				} else {
					pai.setDir(null);
				}
			}

			else {
				raiz = null;
			}
		}

		else if (atual.getEsq() != null && atual.getDir() != null) {

			No sucessor = minimoID(atual.getDir());

			int value = sucessor.getElemento().getId();
			String name = sucessor.getElemento().getNome();
			int age = sucessor.getElemento().getIdade();

			remover(raiz, sucessor.getElemento().getId());

			atual.getElemento().setId(value);
			atual.getElemento().setNome(name);
			atual.getElemento().setIdade(age);
		}

		else {

			No filho = (atual.getEsq() != null) ? atual.getEsq() : atual.getDir();

			if (atual != raiz) {
				if (atual == pai.getEsq()) {
					pai.setEsq(filho);
				} else {
					pai.setDir(filho);
				}
			}

			else {
				raiz = filho;
			}
		}

		return raiz;
	}

	private No minimoID(No atual) {
		while (atual.getEsq() != null) {
			atual = atual.getEsq();
		}
		return atual;
	}
	//teste

}