package club.banyuan.controller;

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

@WebServlet(name = "ChangeAuctionItemServlet")
public class ChangeAuctionItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    AuctionItem auctionItem = new AuctionItem();
    AuctionItemService auctionItemService = new AuctionItemServiceImpl();

    String manage =  request.getParameter("manage");
    if("change".equals(manage)){
      auctionItem.setId(Integer.parseInt(request.getParameter("id")));
      auctionItem.setName(request.getParameter("name"));
      auctionItem.setStarting_price(Integer.parseInt(request.getParameter("starting_price")));
      auctionItem.setBase_price(Integer.parseInt(request.getParameter("base_price")));
      auctionItem.setStart_time(Date.valueOf(request.getParameter("start_time")));
      auctionItem.setEnd_time(Date.valueOf(request.getParameter("end_time")));
      auctionItem.setDescription(request.getParameter("description"));
      boolean i =false;
      try {
        i = auctionItemService.changeAuctionItem(auctionItem);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      if(i){
        request.setAttribute();
        request.getRequestDispatcher("manageAuctionItem.do").forward(request,response);
      }else {
        request.setAttribute();
        request.getRequestDispatcher("alterProduct.jsp").forward(request,response);
      }

    }

    if("delete".equals(manage)){
      int id = Integer.parseInt(request.getParameter("id")) ;
      boolean i =false;
      try {
        i = auctionItemService.deleteAuctionItem(id);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      if(i){
        request.setAttribute();
        request.getRequestDispatcher("manageAuctionItem.do").forward(request,response);
      }else {
        //TODO
      }
    }

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

  }
}
