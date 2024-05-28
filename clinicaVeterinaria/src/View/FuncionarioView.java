package View;

import java.util.Scanner;
import Controller.FuncionarioController;
import Model.Funcionario;

public class FuncionarioView {

    private final FuncionarioController funcionarioController;
    private final Scanner scanner;

    public FuncionarioView(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("### Menu de Funcionário ###");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Buscar Funcionário");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    buscarFuncionario();
                    break;
                case 3:
                    atualizarFuncionario();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarFuncionario() {
        System.out.println("### Cadastrar Funcionário ###");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        
        funcionarioController.cadastrarFuncionario(nome, cargo);
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    private void buscarFuncionario() {
        System.out.println("### Buscar Funcionário ###");
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }

    private void atualizarFuncionario() {
        System.out.println("### Atualizar Funcionário ###");
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Funcionario funcionario = funcionarioController.buscarFuncionario(id);
        if (funcionario != null) {
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Cargo: ");
            String cargo = scanner.nextLine();
            
            funcionarioController.atualizarFuncionario(id, nome, cargo);
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }

    private void excluirFuncionario() {
        System.out.println("### Excluir Funcionário ###");
        System.out.print("ID do Funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        funcionarioController.excluirFuncionario(id);
        System.out.println("Funcionário com ID " + id + " excluído com sucesso.");
    }

    public void fecharScanner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }
}
