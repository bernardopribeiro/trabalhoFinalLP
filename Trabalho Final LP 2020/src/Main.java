import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IFamilyTree f = new FamilyTree();

		f.inserir(40, "Rainha Elizabeth ll", 94);
		f.inserir(20, "Charles", 71);
		f.inserir(60, "Anne", 69);
		f.inserir(10, "William", 37);
		f.inserir(30, "Harry", 35);
		f.inserir(70, "Peter", 42);

		menu(f);

	}

	private static void menu(IFamilyTree f) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== MENU =====");
		System.out.println("1 -> Adicionar elemento a familia");
		System.out.println("2 -> Elementos na familia");
		System.out.println("3 -> Idade do Membro mais Velho");
		System.out.println("4 -> Idade do Membro mais novo");
		System.out.println("5 -> Gera��es da Fam�lia");
		System.out.println("6 -> Existe este elemento na Fam�lia");
		System.out.println("7 -> Quantos membros por gera��o");
		System.out.println("8 -> Listagem at� ao grau desejado");
		System.out.println("9 -> Listagem do grau desejado da familia");
		System.out.println("10 -> Pr� ordem da Fam�lia:");
		System.out.println("11 -> Em ordem da Fam�lia:");
		System.out.println("12 -> Pos Ordem da Fam�lia:");
		System.out.println("13 -> Listar n�vel da ordem da fam�lia");
		System.out.println("14 -> Remover Familiar");
		System.out.println("0 -> Sair");
		System.out.print("Escreva aqui a op��o: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1:
			System.out.println("\nDiga todas as informa��es necessarias.\n");
			System.out.print("\nID -> ");
			int idInserir = scanner.nextInt();
			System.out.print("Nome -> ");
			String nomeInserir = scanner.next();
			System.out.print("Idade -> ");
			int idadeInserir = scanner.nextInt();
			f.inserir(idInserir, nomeInserir, idadeInserir);
			menu(f);
			break;
		case 2:
			System.out.println("\nExistem " + f.numeroElementos() + " membros na familia.");
			menu(f);
			break;
		case 3:
			System.out.println("\nA idade do membro mais velho �: " + f.maisVelho() + " anos.");
			menu(f);
			break;
		case 4:
			System.out.println("\nA idade do membro mais novo �: " + f.maisNovo() + " anos.");
			menu(f);
			break;
		case 5:
			System.out.println("\nA familia t�m " + f.alturaArvore() + " gera��es.");
			menu(f);
			break;
		case 6:
			System.out.println("\nEscolha qual a gera��o que deseja saber quantos membros existe\n");
			System.out.println("Escolha uma gera��o de [0 a " + f.alturaArvore() + "]");
			System.out.print("\nQual a gera��o? ");
			int larguraNivel = scanner.nextInt();
			System.out.println("\nA gera��o " + larguraNivel + " t�m " + f.larguraGeracao(larguraNivel) + " membros.");
			menu(f);
			break;
		case 7:
			System.out.println("\nEscolha at� a gera��o " + f.alturaArvore());
			System.out.print("\nQual nome? \n");
			String boolNome = scanner.next();
			System.out.print("\nQual idade? \n");
			int boolIdade = scanner.nextInt();
			System.out.println("\nExiste? " + f.existe(boolNome, boolIdade));
			menu(f);
			break;
		case 8:
			System.out.println("\nEscolha at� a gera��o " + f.alturaArvore());
			System.out.print("\nDeseja ver que gera��o? ");
			int listarNivel = scanner.nextInt();
			f.listarGeracao(listarNivel);
			System.out.println("\n");
			menu(f);
			break;
		case 9:

			menu(f);
			break;
		case 10:

			menu(f);
			break;
		case 11:

			menu(f);
			break;
		case 12:

			menu(f);
			break;
		case 13:

			menu(f);
			break;
		case 14:

			menu(f);
			break;
		default:
		}
	}

}
