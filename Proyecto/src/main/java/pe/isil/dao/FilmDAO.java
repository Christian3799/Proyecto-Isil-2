package pe.isil.dao;

import pe.isil.model.Actor;
import pe.isil.model.Film;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {
    public void create(Film film) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "INSERT INTO film (film_id, title, description, release_year, rental_duration, rental_rate, length, replacement_cost, rating, special_features) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, film.getId());
            statement.setString(2, film.getTitle());
            statement.setString(3, film.getDescription());
            statement.setString(4, film.getRelease_year());
            statement.setTimestamp(5, film.getRentalDuration());
            statement.setDouble(6, film.getRentalRate());
            statement.setDouble(6, film.getLength());
            statement.setDouble(6, film.getReplacementCost());
            statement.setInt(6, film.getRating());
            statement.setString(6, film.getSpecialFeatures());
            statement.executeUpdate();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    public void update(Film film) {
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "UPDATE film SET title=?, release_year=?, rental_duration=?, length=?, rating=? WHERE film_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, film.getId());
            statement.setString(2, film.getTitle());
            statement.setString(3, film.getRelease_year());
            statement.setTimestamp(3, film.getRentalDuration());
            statement.setDouble(3, film.getLength());
            statement.setDouble(3, film.getRating());
            statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void delete(Film film) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "DELETE FROM film  WHERE film_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, film.getId());
            statement.executeUpdate();

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Film> findAll() {
        List<Film> films = new ArrayList<Film>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM film";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("Title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("release"),
                        resultSet.getString("duration"),
                        resultSet.getDouble("rate"),
                        resultSet.getInt("length"),
                        resultSet.getDouble("replacement"),
                        resultSet.getInt("rating"),
                        resultSet.getString("special_features")
                );
                films.add(film);
            }


        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return films;
    }

    public Film findById(Integer id) {
        Film film = null;
        try  {
            Connection connection = DatabaseUtil.getConnection();
            final String sql = "SELECT * FROM film where film_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                film = new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("Title"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("release"),
                        resultSet.getString("duration"),
                        resultSet.getDouble("rate"),
                        resultSet.getInt("length"),
                        resultSet.getDouble("replacement"),
                        resultSet.getInt("rating"),
                        resultSet.getString("special_features")
                );


            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return film;
    }
}
