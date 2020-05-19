/*
	Tema de Trabalho: Arvore Geneologica

	Elementos do grupo: 
	-> Bernardo Pereira
	-> Bernardo Barbosa
 */

public class Elemento {

	private String nome;
	private int idade;
	private int id;

	// Acessores

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Construtores

	public Elemento(int id, String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + id + " -> Nome: " + nome + ", idade: " + idade + ".";
	}

}