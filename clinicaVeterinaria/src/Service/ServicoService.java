package Service;

import Model.Servico;

import java.util.HashMap;
import java.util.Map;

public class ServicoService {
    private Map<Integer, Servico> servicos = new HashMap<>();
    private int currentId = 1;

    public void cadastrarServico(Servico servico) {
        servico.setId(currentId++);
        servicos.put(servico.getId(), servico);
    }

    public Servico buscarServico(int id) {
        return servicos.get(id);
    }

    public void atualizarServico(Servico servico) {
        if (servicos.containsKey(servico.getId())) {
            servicos.put(servico.getId(), servico);
        } else {
            System.out.println("Serviço com ID " + servico.getId() + " não encontrado.");
        }
    }
    

    public void excluirServico(int id) {
        servicos.remove(id);
    }
}
