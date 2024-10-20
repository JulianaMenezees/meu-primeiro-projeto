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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        CarDao carDao = new CarDao();
        Car car = new Car(id, name);

        if (id.isBlank()) {

            carDao.createCar(car);

        } else {

            carDao.updateCar(car);
        }


        resp.sendRedirect("/find-all-cars");


    }
}
