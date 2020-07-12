package club.banyuan.controller.admin;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterAuctionItemServlet" ,urlPatterns = "/alter.do")
public class AlterAuctionItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("utf-8");
    AuctionItem auctionItem = new AuctionItem();
    AuctionItemService auctionItemService = new AuctionItemServiceImpl();

    auctionItem.setId(Integer.parseInt(request.getParameter("id")));
      auctionItem.setName(request.getParameter("name"));
      auctionItem.setStarting_price(Integer.parseInt(request.getParameter("starting_price")));
      auctionItem.setBase_price(Integer.parseInt(request.getParameter("base_price")));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    java.util.Date date1 = new Date();
    java.util.Date date2 = new Date();
    try {
       date1 = simpleDateFormat.parse(request.getParameter("start_time"));
       date2 = simpleDateFormat.parse(request.getParameter("end_time"));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    auctionItem.setStart_time(date1);
      auctionItem.setEnd_time(date2);
      auctionItem.setDescription(request.getParameter("description"));
      boolean i =false;
      try {
        i = auctionItemService.changeAuctionItem(auctionItem);
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

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
doPost(request,response);
  }
}
