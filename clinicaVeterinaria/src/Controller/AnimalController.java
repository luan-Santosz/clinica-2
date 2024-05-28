package Controller;

import Model.Animal;
import Service.AnimalService;

public class AnimalController {
    
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    
    public void cadastrarAnimal(int id, String nome, String especie, int idade) {
        Animal novoAnimal = new Animal(id, nome, especie, idade);
        animalService.cadastrarAnimal(novoAnimal);
    }

    /**
     * @param id
     * @return
     */
    public Animal buscarAnimal(int id) {
        return animalService.buscarAnimal(id);
    }
        
    
    /**
     * @param id
     * @param nome
     * @param especie
     * @param idade
     */
    public void atualizarAnimal(int id, String nome, String especie, int idade) {
        Animal animal = animalService.buscarAnimal(id);
        if (animal != null) {
            animal.setNome(nome);
            animal.setEspecie(especie);
            animal.setIdade(idade);
            animalService.atualizarAnimal(animal);
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }
    
    public void excluirAnimal(int id) {
        Animal animal = animalService.buscarAnimal(id);
        if (animal != null) {
            animalService.excluirAnimal(id);
            System.out.println("Animal com ID " + id + " excluído com sucesso.");
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }
    
}
