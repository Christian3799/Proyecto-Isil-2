package pe.isil.dao;

import pe.isil.model.Actor;
import pe.isil.model.FilmActor;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmActorDAO {
    public void create(FilmActor filmActor) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "INSERT INTO film_actor (actor_id, film_id) values (?, ?) ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filmActor.getActorid());
            statement.setString(2, filmActor.getFilmid());
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    public void update(FilmActor filmActor) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "UPDATE film_actor SET film_id=? WHERE actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filmActor.getActorid());
            statement.setString(2, filmActor.getFilmid());
            statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void delete(FilmActor filmActor) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "DELETE FROM film_actor  WHERE actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filmActor.getActorid());
            statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<FilmActor> findAll() {
        List<FilmActor> filmactors = new ArrayList<FilmActor>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM film_actor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FilmActor filmActor = new FilmActor(
                        resultSet.getString("id"),
                        resultSet.getString("login")
                );
                filmactors.add(filmActor);
            }


        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return filmactors;
    }

    public FilmActor findById(Integer id) {
        FilmActor filmActor = null;
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM film_actor where actor_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                filmActor= new FilmActor(
                        resultSet.getString("id"),
                        resultSet.getString("login")
                );


            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return filmActor;
    }

}
