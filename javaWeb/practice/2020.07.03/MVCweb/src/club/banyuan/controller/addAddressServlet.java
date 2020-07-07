package club.banyuan.controller;

import club.banyuan.entity.Address;
import club.banyuan.service.AddressService;
import club.banyuan.service.impl.AddressServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "addAddressServlet",urlPatterns = "/addAddress.do")
public class addAddressServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String[] address = request.getParameterValues("address");
    AddressService addressService = new AddressServiceImpl();
    Address address1 = addressService.getAddressByRequest(address);
    try {
     int i = addressService.saveAddress(address1);
     if (i>0){
       request.setAttribute("success","success");
     }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    request.getRequestDispatcher("Member_Address.jsp").forward(request,response);

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
