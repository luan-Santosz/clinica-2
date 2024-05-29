package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Animal;

public class AnimalService {

    private static final String URL = "jdbc:postgresql://localhost:5432/clinica_veterinaria";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public void cadastrarAnimal(Animal animal) {
        String sql = "INSERT INTO animais (id, nome, especie, idade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, animal.getId());
            pstmt.setString(2, animal.getNome());
            pstmt.setString(3, animal.getEspecie());
            pstmt.setInt(4, animal.getIdade());

            pstmt.executeUpdate();
            System.out.println("Animal cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o animal: " + e.getMessage());
        }
    }

    public Animal buscarAnimal(int id) {
        String sql = "SELECT * FROM animais WHERE id = ?";
        Animal animal = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especie"),
                        rs.getInt("idade")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o animal: " + e.getMessage());
        }

        return animal;
    }

    
    public void atualizarAnimal(Animal animal) {
        String sql = "UPDATE animais SET nome = ?, especie = ?, idade = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, animal.getNome());
            pstmt.setString(2, animal.getEspecie());
            pstmt.setInt(3, animal.getIdade());
            pstmt.setInt(4, animal.getId());

            pstmt.executeUpdate();
            System.out.println("Animal atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o animal: " + e.getMessage());
        }
    }

    public void excluirAnimal(int id) {
        String sql = "DELETE FROM animais WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Animal excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir o animal: " + e.getMessage());
        }
    }
}
