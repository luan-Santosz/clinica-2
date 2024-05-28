package View;

import java.sql.Date;
import java.util.Scanner;

import Controller.ConsultaController;
import Model.Consulta;

public class ConsultaView {
    
    private final ConsultaController consultaController;
    private final Scanner scanner;
    
    public ConsultaView(ConsultaController consultaController) {
        this.consultaController = consultaController;
        this.scanner = new Scanner(System.in);
    }
    
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("---- Menu de Consultas ----");
            System.out.println("1. Marcar nova consulta");
            System.out.println("2. Buscar consulta por ID");
            System.out.println("3. Atualizar dados de uma consulta");
            System.out.println("4. Excluir consulta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    marcarConsulta();
                    break;
                case 2:
                    buscarConsulta();
                    break;
                case 3:
                    atualizarConsulta();
                    break;
                case 4:
                    excluirConsulta();
                    break;
                case 0:
                    System.out.println("Saindo do menu de consultas...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
    
    private void marcarConsulta() {
        System.out.println("Digite o ID do animal:");
        int idAnimal = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        System.out.println("Digite o ID do veterinário:");
        int idVeterinario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        System.out.println("Digite a data da consulta (formato: yyyy-mm-dd):");
        String dataString = scanner.nextLine();
        Date data = Date.valueOf(dataString);
        
        ConsultaController.MarcarConsulta(idAnimal, idVeterinario, data);

    }
    
    private void buscarConsulta() {
        System.out.println("Digite o ID da consulta:");
        int idConsulta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        Consulta consulta = consultaController.buscarConsulta(idConsulta);
        if (consulta != null) {
            System.out.println("Consulta encontrada:");
            System.out.println(consulta);
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
    
    private void atualizarConsulta() {
        System.out.println("Digite o ID da consulta:");
        int idConsulta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        System.out.println("A consulta foi realizada? (true/false):");
        boolean realizada = scanner.nextBoolean();
        
        consultaController.atualizarConsulta(idConsulta, realizada);
    }
    
    private void excluirConsulta() {
        System.out.println("Digite o ID da consulta:");
        int idConsulta = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        
        consultaController.excluirConsulta(idConsulta);
    }

    public void fecharScanner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }
}
