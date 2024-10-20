package br.com.carstore.servlet.servlet;

import br.com.carstore.servlet.dao.CarDao;
import br.com.carstore.servlet.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String color = req.getParameter("color");

        Car car = new Car(name, color);

        CarDao carDao = new CarDao();
        carDao.createCar(car);

        resp.sendRedirect("/find-all-cars");

    }

}
