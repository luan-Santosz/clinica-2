package View;

import java.util.Scanner;
import Controller.AnimalController;
import Model.Animal;

public class AnimalView {

    private final AnimalController animalController;
    private final Scanner scanner;

    public AnimalView(AnimalController animalController) {
        this.animalController = animalController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("### Menu de Animais ###");
            System.out.println("1. Cadastrar animal");
            System.out.println("2. Buscar animal");
            System.out.println("3. Atualizar animal");
            System.out.println("4. Excluir animal");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    cadastrarAnimal();
                    break;
                case 2:
                    buscarAnimal();
                    break;
                case 3:
                    atualizarAnimal();
                    break;
                case 4:
                    excluirAnimal();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void cadastrarAnimal() {
        System.out.println("### Cadastro de Animal ###");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        animalController.cadastrarAnimal(id, nome, especie, idade);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private void buscarAnimal() {
        System.out.println("### Busca de Animal ###");
        System.out.print("ID do animal a ser buscado: ");
        int id = scanner.nextInt();

        Animal animal = animalController.buscarAnimal(id);
        if (animal != null) {
            System.out.println("Animal encontrado:");
            System.out.println(animal);
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }

    private void atualizarAnimal() {
        System.out.println("### Atualização de Animal ###");
        System.out.print("ID do animal a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova espécie: ");
        String especie = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        animalController.atualizarAnimal(id, nome, especie, idade);
        System.out.println("Animal atualizado com sucesso!");
    }

    private void excluirAnimal() {
        System.out.println("### Exclusão de Animal ###");
        System.out.print("ID do animal a ser excluído: ");
        int id = scanner.nextInt();

        animalController.excluirAnimal(id);
        System.out.println("Animal excluído com sucesso!");
    }

    public void fecharScanner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }
}
