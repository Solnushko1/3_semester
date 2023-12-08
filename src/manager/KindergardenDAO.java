package manager;

import domain.Kindergarden;
import repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindergardenDAO {
    private static final String SELECT_ALL_KINDERGARDEN = "SELECT * FROM kindergarten.public.peoplegroup";
    private static final String INSERT_KINDERGARDEN = "INSERT INTO kindergarten.public.peoplegroup (name, gender, age, group_name, group_number) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_KINDERGARDEN = "UPDATE kindergarten.public.peoplegroup SET name = ?, gender = ?, age = ?, group_name = ?, group_number = ? WHERE id = ?";
    private static final String DELETE_KINDERGARDEN = "DELETE FROM kindergarten.public.peoplegroup WHERE id = ?";

    public List<Kindergarden> getAllPrograms() {
        List<Kindergarden> programs = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_KINDERGARDEN);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Kindergarden program = new Kindergarden();
                program.setId(resultSet.getInt("id"));
                program.setName(resultSet.getString("name"));
                program.setGender(resultSet.getString("gender"));
                program.setAge(resultSet.getInt("age"));
                program.setGroup_name(resultSet.getString("group_name"));
                program.setGroup_number(resultSet.getInt("group_number"));

                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return programs;
    }

    public void addProgram(Kindergarden program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_KINDERGARDEN)) {

            statement.setString(1, program.getName());
            statement.setString(2, program.getGender());
            statement.setInt(3, program.getAge());
            statement.setString(4, program.getGroup_name());
            statement.setInt(5, program.getGroup_number());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgram(Kindergarden program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_KINDERGARDEN)) {

            statement.setString(1, program.getName());
            statement.setString(2, program.getGender());
            statement.setInt(3, program.getAge());
            statement.setString(4, program.getGroup_name());
            statement.setInt(5, program.getGroup_number());
            statement.setInt(6, program.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgram(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_KINDERGARDEN)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Другие методы для обновления, удаления и редактирования программ
}
