import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();

	}

	private static void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("===== MENU =====");
		System.out.println("1 -> Adicionar elemento a familia");
		System.out.println("2 -> Elementos na familia");
		System.out.println("3 -> Idade do Membro mais Velho");
		System.out.println("4 -> Idade do Membro mais novo");
		System.out.println("5 -> Gerações da Família");
		System.out.println("6 -> Quantos membros por geração");
		System.out.println("7 -> Listagem até ao grau desejado");
		System.out.println("8 -> Listagem do grau desejado da familia");
		System.out.println("9 -> Pré ordem da Família:");
		System.out.println("10 -> Em ordem da Família:");
		System.out.println("11 -> Pos Ordem da Família:");
		System.out.println("12 -> Listar nível da ordem da família");
		System.out.println("13 -> Remover Familiar");
		System.out.println("0 -> Sair");
		System.out.print("Escreva aqui a opção: ");
		int choice = scanner.nextInt();
	}

}
