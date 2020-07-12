package club.banyuan.controller.user;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StartAuctionServlet" , urlPatterns = "/startAuction.do")
public class StartAuctionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    int id = Integer.parseInt(request.getParameter("id"));
    String type = request.getParameter("type");
    AuctionItemService auctionItemService = new AuctionItemServiceImpl();
    try {
      AuctionItem auctionItem = auctionItemService.getAuctionItemById(id);
      Date date = new Date();
      Date startTime = auctionItem.getStart_time();
      Date endTime = auctionItem.getEnd_time();
      int i = startTime.compareTo(date);
      int j = date.compareTo(endTime);

      if(i>0 || j>0){
        request.setAttribute("error","timeOut");
        if("search".equals(type))
        request.getRequestDispatcher("searchAuctionItem_list.jsp").forward(request,response);
        if("home".equals(type))
          request.getRequestDispatcher("auctionItem_list.jsp").forward(request,response);
      }else {
         session.setAttribute("startAuction",auctionItem);
         request.getRequestDispatcher("start_auction.jsp").forward(request,response);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      doPost(request,response);
  }
}
