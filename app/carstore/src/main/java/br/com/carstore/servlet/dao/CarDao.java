package br.com.carstore.servlet.dao;

import br.com.carstore.servlet.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDao {

    public void createCar(Car car){


    String SQL = "INSERT INTO CAR (NAME, COLOR) VALUES (?, ?)";

        try {

        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

        System.out.println("Sucesso ao se conector ao banco de dados:");

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);

        preparedStatement.setString(1, car.getName());
        preparedStatement.setString(2, car.getColor());
        preparedStatement.execute();

        System.out.println("Sucesso ao inserir o carro no banco de dados");

        connection.close();

        } catch (Exception e) {

        System.out.println("Falha ao gravar o carro no banco de dados" + e.getMessage());

    }
    }
}
