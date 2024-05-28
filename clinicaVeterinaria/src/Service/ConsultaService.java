package Service;

import Model.Consulta;
import java.util.HashMap;
import java.util.Map;

public class ConsultaService {
    
    private Map<Integer, Consulta> consultaMap = new HashMap<>();
    
    public void marcarConsulta(Consulta consulta) {
        consultaMap.put(consulta.getId(), consulta);
        System.out.println("Consulta marcada com sucesso.");
    }
    
    public Consulta buscarConsulta(int id) {
        return consultaMap.get(id);
    }
    
    public void atualizarConsulta(Consulta consulta) {
        if (consultaMap.containsKey(consulta.getId())) {
            consultaMap.put(consulta.getId(), consulta);
            System.out.println("Consulta atualizada com sucesso.");
        } else {
            System.out.println("Consulta com ID " + consulta.getId() + " não encontrada.");
        }
    }
    
    public void excluirConsulta(int id) {
        if (consultaMap.containsKey(id)) {
            consultaMap.remove(id);
            System.out.println("Consulta excluída com sucesso.");
        } else {
            System.out.println("Consulta com ID " + id + " não encontrada.");
        }
    }
}
