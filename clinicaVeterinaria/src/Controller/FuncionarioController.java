package Controller;

import Model.Funcionario;
import Service.FuncionarioService;

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    
    public void cadastrarFuncionario(String nome, String cargo) {
        Funcionario novoFuncionario = new Funcionario(0, nome, cargo); // ID será atribuído pelo serviço
        funcionarioService.cadastrarFuncionario(novoFuncionario);
    }
    
    public Funcionario buscarFuncionario(int id) {
        return funcionarioService.buscarFuncionario(id);
    }
    
    public void atualizarFuncionario(int id, String nome, String cargo) {
        Funcionario funcionario = funcionarioService.buscarFuncionario(id);
        if (funcionario != null) {
            funcionario.setNome(nome);
            funcionario.setCargo(cargo);
            funcionarioService.atualizarFuncionario(funcionario);
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }

    
    public void excluirFuncionario(int id) {
        Funcionario funcionario = funcionarioService.buscarFuncionario(id);
        if (funcionario != null) {
            funcionarioService.excluirFuncionario(id);
            System.out.println("Funcionário com ID " + id + " excluído com sucesso.");
        } else {
            System.out.println("Funcionário com ID " + id + " não encontrado.");
        }
    }
}
