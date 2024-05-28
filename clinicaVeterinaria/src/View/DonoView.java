package View;

import java.util.Scanner;

import Controller.DonoController;
import Model.Dono;

public class DonoView {
    
    private final DonoController donoController;
    private final Scanner scanner;

    public DonoView(DonoController donoController) {
        this.donoController = donoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("### Menu de Donos ###");
            System.out.println("1. Cadastrar Dono");
            System.out.println("2. Buscar Dono por ID");
            System.out.println("3. Atualizar Dono");
            System.out.println("4. Excluir Dono");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    cadastrarDono();
                    break;
                case 2:
                    buscarDono();
                    break;
                case 3:
                    atualizarDono();
                    break;
                case 4:
                    excluirDono();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarDono() {
        System.out.println("### Cadastro de Dono ###");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        donoController.cadastrarDono(nome, telefone, endereco);
        System.out.println("Dono cadastrado com sucesso.");
    }

    private void buscarDono() {
        System.out.println("### Buscar Dono por ID ###");
        System.out.print("ID do Dono: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Dono dono = donoController.buscarDono(id);
        if (dono != null) {
            System.out.println("Dono encontrado:");
            System.out.println(dono);
        } else {
            System.out.println("Dono com ID " + id + " não encontrado.");
        }
    }

    private void atualizarDono() {
        System.out.println("### Atualizar Dono ###");
        System.out.print("ID do Dono: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Dono dono = donoController.buscarDono(id);
        if (dono != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo endereço: ");
            String endereco = scanner.nextLine();
            
            donoController.atualizarDono(id, nome, telefone, endereco);
            System.out.println("Dono atualizado com sucesso.");
        } else {
            System.out.println("Dono com ID " + id + " não encontrado.");
        }
    }

    private void excluirDono() {
        System.out.println("### Excluir Dono ###");
        System.out.print("ID do Dono: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        donoController.excluirDono(id);
        System.out.println("Dono com ID " + id + " excluído com sucesso.");
    }

    public void fecharScanner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }
    
}
