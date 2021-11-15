package com.thunderscore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunderscore.entity.Brand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/displayAll"}
)
public class DisplayAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/Th__war/brand/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Brand> brands = (List<Brand>) mapper.readValue(response,Brand.class);
        request.setAttribute("data",response);
        request.setAttribute("title", "demo page");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request,resp);
    }
}
