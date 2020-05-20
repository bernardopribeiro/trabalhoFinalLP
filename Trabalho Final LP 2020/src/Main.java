import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IFamilyTree f = new FamilyTree(family());

		menu(f);

	}

	private static void menu(IFamilyTree f) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== MENU =====");
		System.out.println("1 -> Adicionar elemento a familia");
		System.out.println("2 -> Elementos na familia");
		System.out.println("3 -> Idade do Membro mais Velho");
		System.out.println("4 -> Idade do Membro mais novo");
		System.out.println("5 -> Gerações da Família");
		System.out.println("6 -> Existe este elemento na Família");
		System.out.println("7 -> Quantos membros por geração");
		System.out.println("8 -> Listagem até ao grau desejado");
		System.out.println("9 -> Listagem do grau desejado da familia");
		System.out.println("10 -> Pré ordem da Família:");
		System.out.println("11 -> Em ordem da Família:");
		System.out.println("12 -> Pos Ordem da Família:");
		System.out.println("13 -> Listar nível da ordem da família");
		System.out.println("14 -> Remover Familiar");
		System.out.println("0 -> Sair");
		System.out.print("Escreva aqui a opção: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 0:
			System.exit(0);
			break;
		case 1:
			menu(f);
			break;
		case 2:
			System.out.println("\nExistem " + f.numeroElementos() + " membros na familia.");
			menu(f);
			break;
		case 3:
			System.out.println("\nA idade do membro mais velho é: " + f.maisVelho() + " anos.");
			menu(f);
			break;
		case 4:
			System.out.println("\nA idade do membro mais novo é: " + f.maisNovo() + " anos.");
			menu(f);
			break;
		case 5:
			System.out.println("\nA familia têm " + f.alturaArvore() + " gerações.");
			menu(f);
			break;
		case 6:
			System.out.println("\nEscolha qual a geração que deseja saber quantos membros existe\n");
			System.out.println("Escolha uma geração de [0 a " + f.alturaArvore() + "]");
			System.out.print("\nQual a geração? ");
			int larguraNivel = scanner.nextInt();
			System.out.println("\nA geração " + larguraNivel + " têm " + f.larguraNivel(larguraNivel) + " membros.");
			menu(f);
			break;
		case 7:
			System.out.println("\nEscolha até a geração " + f.alturaArvore());
			System.out.print("\nQual nome? \n");
			String boolNome = scanner.next();
			System.out.print("\nQual idade? \n");
			int boolIdade = scanner.nextInt();
			System.out.println("\nExiste? " +f.existe(boolNome,boolIdade));
			menu(f);
			break;
		case 8:

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

	public static No family() {
		No raiz;
		No no1 = new No(new Elemento(40, "Rainha Elizabeth ll", 94));
		No no2 = new No(new Elemento(20, "Charles", 71));
		No no3 = new No(new Elemento(50, "Anne", 69));
		No no4 = new No(new Elemento(10, "William", 37));
		No no5 = new No(new Elemento(30, "Harry", 35));
		No no6 = new No(new Elemento(60, "Peter", 42));

		no4.setEsq(no2);
		no4.setDir(no6);
		no2.setEsq(no1);
		no2.setDir(no3);
		no6.setEsq(no5);

		raiz = no4;
		return raiz;
	}
}
