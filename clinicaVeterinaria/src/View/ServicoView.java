package View;

import java.util.Scanner;
import Controller.ServicoController;
import Model.Servico;

public class ServicoView {

    private final ServicoController servicoController;
    private final Scanner scanner;

    public ServicoView(ServicoController servicoController) {
        this.servicoController = servicoController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("### Menu de Serviço ###");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Buscar Serviço");
            System.out.println("3. Atualizar Serviço");
            System.out.println("4. Excluir Serviço");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    cadastrarServico();
                    break;
                case 2:
                    buscarServico();
                    break;
                case 3:
                    atualizarServico();
                    break;
                case 4:
                    excluirServico();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarServico() {
        System.out.println("### Cadastrar Serviço ###");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        
        servicoController.cadastrarServico(nome, preco);
        System.out.println("Serviço cadastrado com sucesso.");
    }

    private void buscarServico() {
        System.out.println("### Buscar Serviço ###");
        System.out.print("ID do Serviço: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Servico servico = servicoController.buscarServico(id);
        if (servico != null) {
            System.out.println("Serviço encontrado:");
            System.out.println("ID: " + servico.getId());
            System.out.println("Nome: " + servico.getNome());
            System.out.println("Preço: " + servico.getPreco());
        } else {
            System.out.println("Serviço com ID " + id + " não encontrado.");
        }
    }

    private void atualizarServico() {
        System.out.println("### Atualizar Serviço ###");
        System.out.print("ID do Serviço: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Servico servico = servicoController.buscarServico(id);
        if (servico != null) {
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Preço: ");
            double preco = scanner.nextDouble();
            
            servicoController.atualizarServico(id, nome, preco);
            System.out.println("Serviço atualizado com sucesso.");
        } else {
            System.out.println("Serviço com ID " + id + " não encontrado.");
        }
    }

    private void excluirServico() {
        System.out.println("### Excluir Serviço ###");
        System.out.print("ID do Serviço: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        servicoController.excluirServico(id);
        System.out.println("Serviço com ID " + id + " excluído com sucesso.");
    }

    public void fecharScanner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }
}
