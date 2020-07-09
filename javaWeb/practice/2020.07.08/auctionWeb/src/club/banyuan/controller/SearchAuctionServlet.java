package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchAuctionServlet",urlPatterns = "")
public class SearchAuctionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    AuctionItemService auctionItemService = new AuctionItemServiceImpl();

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date start_time = null;
    try {
      start_time = sf.parse(request.getParameter("start_time"));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    Date end_time = null;
    try {
      end_time = sf.parse(request.getParameter("end_time"));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Integer starting_price = Integer.parseInt(request.getParameter("starting_price")) ;

    AuctionItem auctionItem = new AuctionItem(0,name,starting_price,null,start_time,end_time,description,null);

    List<AuctionItem> list = null;
    try {
      list = auctionItemService.getAuctionItemBySearch(auctionItem,);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     doPost(request,response);
  }
}
