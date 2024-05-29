package Service;

import Model.Dono;

import java.util.HashMap;
import java.util.Map;

public class DonoService {
    private Map<Integer, Dono> donos = new HashMap<>();
    private int currentId = 1;

    public void cadastrarDono(Dono dono) {
        dono.setId(currentId++);
        donos.put(dono.getId(), dono);
    }

    public Dono buscarDono(int id) {
        return donos.get(id);
    }

    public void atualizarDono(Dono dono) {
        if (donos.containsKey(dono.getId())) {
            donos.put(dono.getId(), dono);
        } else {
            System.out.println("Dono com ID " + dono.getId() + " não encontrado.");
        }
    }
    

    public void excluirDono(int id) {
        donos.remove(id);
    }
}
