package br.com.carstore.servlet.dao;

import br.com.carstore.servlet.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());

            preparedStatement.execute();

            System.out.println("Sucesso ao inserir o carro no DB!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falha ao gravar o carro no DB: " + e.getMessage());

        }

    }

    public List<Car> findAllCars(){

        String SQL  = "SELECT * FROM CAR";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> allCars = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String name = resultSet.getString("NAME");

                Car car = new Car(id, name);

                allCars.add(car);

            }

            System.out.println("Sucesso ao consultar os dados na tabela CAR");

            connection.close();

            return allCars;

        } catch (Exception e) {

            System.out.println("Falha ao consultar os carros na tabela CAR: " + e.getMessage());

        }


        return Collections.emptyList();

    }

    public void deleteCarById(String carId) {

        String SQL = "DELETE CAR WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carId);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + carId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public void updateCar(Car car) {

        String SQL = "UPDATE CAR SET NAME = ? WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getId());
            preparedStatement.execute();

            System.out.println("success in update car");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }

    }

}


