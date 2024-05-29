package Service;

import Model.Funcionario;

import java.util.HashMap;
import java.util.Map;

public class FuncionarioService {
    private Map<Integer, Funcionario> funcionarios = new HashMap<>();
    private int currentId = 1;

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionario.setId(currentId++);
        funcionarios.put(funcionario.getId(), funcionario);
    }

    public Funcionario buscarFuncionario(int id) {
        return funcionarios.get(id);
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        if (funcionarios.containsKey(funcionario.getId())) {
            funcionarios.put(funcionario.getId(), funcionario);
        } else {
            System.out.println("Funcionário com ID " + funcionario.getId() + " não encontrado.");
        }
    }
    

    public void excluirFuncionario(int id) {
        funcionarios.remove(id);
    }
}
