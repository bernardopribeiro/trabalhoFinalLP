
/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public interface IFamilyTree {

	public int numeroElementos();

	public int maisVelho();

	public int maisNovo();

	public int alturaArvore();

	public int larguraGeracao(int nivel);

	public boolean existe(String nome, int idade);

	public void listarAteGeracao(int nivel);

	public void listarGeracao(int nivel);

	void inserir(int id, String nome, int idade) throws IllegalArgumentException;

}
