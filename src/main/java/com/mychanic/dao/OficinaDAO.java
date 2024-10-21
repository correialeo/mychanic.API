package com.mychanic.dao;

import com.mychanic.models.Oficina;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class OficinaDAO {

    static ConnectionFactory connectionFactory = new ConnectionFactory();

    public static String insert(Oficina oficina){
        try{
            PreparedStatement statement = connectionFactory.getConnection().prepareStatement("INSERT INTO OFICINA (NOME, ENDERECO, EMAIL, HORARIO_FUNC, AVALIACAO, CATEGORIA) VALUES (?,?,?,?,?,?)");
            statement.setString(1, oficina.getNome());
            statement.setString(2, oficina.getEndereco());
            statement.setString(3, oficina.getEmail());
            statement.setString(4, oficina.getHorarioFunc());
            statement.setInt(5, oficina.getAvaliacao());
            statement.setInt(6, oficina.getCategoria());
            statement.execute();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return "Oficina criada com sucesso!";
    }

    public List<Oficina> read(){
        List<Oficina> listWorkshops = new ArrayList<>();
        try{
            PreparedStatement statement = connectionFactory.getConnection().prepareStatement("SELECT * FROM OFICINA");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String nameRs = resultSet.getString("NOME");
                String endereco = resultSet.getString("ENDERECO");
                String email = resultSet.getString("EMAIL");
                String horarioFunc = resultSet.getString("HORARIO_FUNC");
                int aval = resultSet.getInt("AVALIACAO");
                int cat = resultSet.getInt("CATEGORIA");

                listWorkshops.add(new Oficina(nameRs,endereco, email,horarioFunc,aval, cat));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        Collections.sort(listWorkshops, Comparator.comparing(Oficina::getNome));
        return listWorkshops;
    }

    public void update(Time horarioNovo, String nome){
        try {
            PreparedStatement statement = connectionFactory.getConnection().prepareStatement("UPDATE OFICINA SET HORARIO_FUNC = ? WHERE NOME = ?");
            statement.setTime(1, horarioNovo);
            statement.setString(2,nome);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id){
        try{
            PreparedStatement statement = connectionFactory.getConnection().prepareStatement("DELETE FROM OFICINA WHERE ID = ?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Oficina> getByCat(int categoria) {

        List<Oficina> listWorkshops = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            statement = connectionFactory.getConnection().prepareStatement("SELECT * FROM OFICINA WHERE CATEGORIA = ?");
            statement.setInt(1, categoria);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NOME");
                String endereco = resultSet.getString("ENDERECO");
                String email = resultSet.getString("EMAIL");
                String horarioFunc = resultSet.getString("HORARIO_FUNC");
                Integer aval = (Integer) resultSet.getInt("AVALIACAO");
                Integer cat = (Integer) resultSet.getInt("CATEGORIA");

                listWorkshops.add(new Oficina(name, endereco, email, horarioFunc, aval, cat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Collections.sort(listWorkshops, Comparator.comparing(Oficina::getNome));
        return listWorkshops;
    }

}
