package View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalView animalView = new AnimalView(null);
        ConsultaView consultaView = new ConsultaView(null);
        DonoView donoView = new DonoView(null);
        FuncionarioView funcionarioView = new FuncionarioView(null);
        ServicoView servicoView = new ServicoView(null);

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    animalView.exibirMenu();
                    break;
                case 2:
                    consultaView.exibirMenu();
                    break;
                case 3:
                    donoView.exibirMenu();
                    break;
                case 4:
                    funcionarioView.exibirMenu();
                    break;
                case 5:
                    servicoView.exibirMenu();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Menu Animal");
        System.out.println("2. Menu Consulta");
        System.out.println("3. Menu Dono");
        System.out.println("4. Menu Funcionário");
        System.out.println("5. Menu Serviço");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        return scanner.nextInt();
    }
}
