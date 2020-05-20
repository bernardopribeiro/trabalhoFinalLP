
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

	public int larguraNivel(int nivel);

	public boolean existe(String nome, int idade);

}
