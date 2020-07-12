package club.banyuan.controller.admin;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ChangeAuctionItemServlet",urlPatterns = "/changeAuctionItem.do")
public class ChangeAuctionItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    AuctionItem auctionItem = new AuctionItem();
    AuctionItemService auctionItemService = new AuctionItemServiceImpl();

    String manage =  request.getParameter("manage");


    if("change".equals(manage)){

      int id = Integer.parseInt(request.getParameter("id"));
      try {
        auctionItem = auctionItemService.getAuctionItemById(id);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }

      request.setAttribute("alter",auctionItem);
      request.getRequestDispatcher("alterProduct.jsp").forward(request,response);

    }

    if("delete".equals(manage)){
      int id = Integer.parseInt(request.getParameter("id")) ;
      System.out.println(id);
      boolean i =false;
      try {
        i = auctionItemService.deleteAuctionItem(id);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      if(i){
        request.setAttribute("response","success");
        request.getRequestDispatcher("manageAuctionItem.do").forward(request,response);
      }else {
        request.setAttribute("response","error");
        request.getRequestDispatcher("manageAuctionItem.do").forward(request,response);
      }
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
