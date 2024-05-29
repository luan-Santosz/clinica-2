package Controller;

import Model.Consulta;
import Service.ConsultaService;
import java.sql.Date;

public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    public void marcarConsulta(int idAnimal, int idVeterinario, Date data) {
        // Gera um novo ID para a consulta. Pode ser melhorado com um gerador de ID mais sofisticado.
        int id = consultaService.gerarNovoId();
        Consulta novaConsulta = new Consulta(id, idAnimal, idVeterinario, data, false);
        consultaService.marcarConsulta(novaConsulta);
    }

    public Consulta buscarConsulta(int id) {
        return consultaService.buscarConsulta(id);
    }

    public void atualizarConsulta(int id, boolean realizada) {
        Consulta consulta = consultaService.buscarConsulta(id);
        if (consulta != null) {
            consulta.setRealizada(realizada);
            consultaService.atualizarConsulta(consulta);
        } else {
            System.out.println("Consulta com ID " + id + " não encontrada.");
        }
    }

    public void excluirConsulta(int id) {
        Consulta consulta = consultaService.buscarConsulta(id);
        if (consulta != null) {
            consultaService.excluirConsulta(id);
            System.out.println("Consulta com ID " + id + " excluída com sucesso.");
        } else {
            System.out.println("Consulta com ID " + id + " não encontrada.");
        }
    }
}
