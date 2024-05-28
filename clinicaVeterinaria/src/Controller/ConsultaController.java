package Controller;

import java.sql.Date;

import Model.Consulta;
import Service.ConsultaService;

public class ConsultaController {

    private final ConsultaService ConsultaService;

    /**
     * @param consultaService
     */
    public ConsultaController(ConsultaService consultaService) {
        this.ConsultaService = consultaService;
    }

    public void marcarConsulta(int id, int idAnimal, int idVeterinario, Date data) {
        Consulta novaConsulta = new Consulta(id, idAnimal, idVeterinario, data, false);
        ConsultaService.marcarConsulta(novaConsulta);
    }

    public Consulta buscarConsulta(int id) {
        return ConsultaService.buscarConsulta(id);
    }

    public void atualizarConsulta(int id, boolean realizada) {
        Consulta consulta = ConsultaService.buscarConsulta(id);
        if (consulta != null) {
            consulta.setRealizada(realizada);
            ConsultaService.atualizarConsulta(consulta);
        } else {
            System.out.println("Consulta com ID " + id + " não encontrada.");
        }
    }

    public void excluirConsulta(int id) {
        Consulta consulta = ConsultaService.buscarConsulta(id);
        if (consulta != null) {
            ConsultaService.excluirConsulta(id);
            System.out.println("Consulta com ID " + id + " excluída com sucesso.");
        } else {
            System.out.println("Consulta com ID " + id + " não encontrada.");
        }
    }

    public static void MarcarConsulta(int idAnimal, int idVeterinario, Date data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MarcarConsulta'");
    }
}