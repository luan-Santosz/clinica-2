package Model;

import java.sql.Date;

public class Consulta {
    private int id;
    private int idAnimal;
    private int idVeterinario;
    private Date data;
    private boolean realizada;

    public Consulta(int id, int idAnimal, int idVeterinario, Date data, boolean realizada) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.idVeterinario = idVeterinario;
        this.data = data;
        this.realizada = realizada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}
