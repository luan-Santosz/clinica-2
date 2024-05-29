package Controller;

import Model.Dono;
import Service.DonoService;

public class DonoController {
    
    private final DonoService donoService;

    public DonoController(DonoService donoService) {
        this.donoService = donoService;
    }

    public void cadastrarDono(String nome, String telefone, String endereco) {
        Dono novoDono = new Dono(0, nome, telefone, endereco); // ID será atribuído pelo serviço
        donoService.cadastrarDono(novoDono);
    }
    
    public Dono buscarDono(int id) {
        return donoService.buscarDono(id);
    }
    
    public void atualizarDono(int id, String nome, String telefone, String endereco) {
        Dono dono = donoService.buscarDono(id);
        if (dono != null) {
            dono.setNome(nome);
            dono.setTelefone(telefone);
            dono.setEndereco(endereco);
            donoService.atualizarDono(dono);
        } else {
            System.out.println("Dono com ID " + id + " não encontrado.");
        }
    }
    
    public void excluirDono(int id) {
        Dono dono = donoService.buscarDono(id);
        if (dono != null) {
            donoService.excluirDono(id);
            System.out.println("Dono com ID " + id + " excluído com sucesso.");
        } else {
            System.out.println("Dono com ID " + id + " não encontrado.");
        }
    }
    
} 
