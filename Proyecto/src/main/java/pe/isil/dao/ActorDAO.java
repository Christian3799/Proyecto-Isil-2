package pe.isil.dao;

import pe.isil.model.Actor;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    public void create(Actor actor) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "INSERT INTO actor (actor_id, first_name, last_name) values (?, ?, ?) ";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, actor.getId());
                statement.setString(2, actor.getFirstName());
                statement.setString(3, actor.getLastName());
                statement.executeUpdate();
                 } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    public void update(Actor actor) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, actor.getId());
                statement.setString(2, actor.getFirstName());
                statement.setString(3, actor.getFirstName());
                statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void delete(Actor actor) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "DELETE FROM actor  WHERE actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, actor.getId());
                statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Actor> findAll() {
        List<Actor> actors = new ArrayList<Actor>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM actor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        Actor actor = new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );
                        actors.add(actor);
                    }


        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return actors;
    }

    public Actor findById(Integer id) {
        Actor actor = null;
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM actor where actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                        actor = new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );


            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return actor;
    }

}
