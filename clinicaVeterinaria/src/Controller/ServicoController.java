package Controller;

import Model.Servico;
import Service.ServicoService;

public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }
    
    public void cadastrarServico(String nome, double preco) {
        Servico novoServico = new Servico(0, nome, preco); // ID será atribuído pelo serviço
        servicoService.cadastrarServico(novoServico);
    }

    public Servico buscarServico(int id) {
        return servicoService.buscarServico(id);
    }

    public void atualizarServico(int id, String nome, double preco) {
        Servico servico = servicoService.buscarServico(id);
        if (servico != null) {
            servico.setNome(nome);
            servico.setPreco(preco);
            servicoService.atualizarServico(servico);
        } else {
            System.out.println("Serviço com ID " + id + " não encontrado.");
        }
    }

    public void excluirServico(int id) {
        Servico servico = servicoService.buscarServico(id);
        if (servico != null) {
            servicoService.excluirServico(id);
            System.out.println("Serviço com ID " + id + " excluído com sucesso.");
        } else {
            System.out.println("Serviço com ID " + id + " não encontrado.");
        }
    }
}
