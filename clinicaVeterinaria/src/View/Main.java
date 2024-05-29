package View;

import java.util.Scanner;
import Controller.AnimalController;
import Controller.ConsultaController;
import Controller.DonoController;
import Controller.FuncionarioController;
import Controller.ServicoController;
import Service.AnimalService;
import Service.ConsultaService;
import Service.DonoService;
import Service.FuncionarioService;
import Service.ServicoService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        AnimalService animalService = new AnimalService();
        ConsultaService consultaService = new ConsultaService();
        DonoService donoService = new DonoService();
        FuncionarioService funcionarioService = new FuncionarioService();
        ServicoService servicoService = new ServicoService();

        //controladores passando os serviços
        AnimalController animalController = new AnimalController(animalService);
        ConsultaController consultaController = new ConsultaController(consultaService);
        DonoController donoController = new DonoController(donoService);
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioService);
        ServicoController servicoController = new ServicoController(servicoService);

        AnimalView animalView = new AnimalView(animalController);
        ConsultaView consultaView = new ConsultaView(consultaController);
        DonoView donoView = new DonoView(donoController);
        FuncionarioView funcionarioView = new FuncionarioView(funcionarioController);
        ServicoView servicoView = new ServicoView(servicoController);

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
