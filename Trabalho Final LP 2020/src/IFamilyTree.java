
/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public interface IFamilyTree {
	
	public void inserir(int id, String nome, int idade) throws IllegalArgumentException;

	public int numeroElementos();

	public int maisVelho();

	public int maisNovo();

	public int alturaArvore();

	public int larguraGeracao(int nivel);

	public boolean existe(String nome, int idade);

	public void listarAteGeracao(int listarAteGeracao);

	public void listarGeracao(int nivel);

	public String preOrder();

	public String inOrder();

	public String posOrder();

	public void listarNiveis();

	public String listarLado(String ladoImprimir);

		

}
