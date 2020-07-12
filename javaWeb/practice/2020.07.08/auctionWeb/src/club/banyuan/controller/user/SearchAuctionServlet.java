package club.banyuan.controller.user;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SearchAuctionServlet",urlPatterns = "/search.do")
public class SearchAuctionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    AuctionItemService auctionItemService = new AuctionItemServiceImpl();
    AuctionItem auctionItem = translation(request);
    HttpSession session = request.getSession();

    String pageNum = request.getParameter("pageNum");
    List<AuctionItem> list = null;
    int pageAllNumBySearch=0;

    if(pageNum == null) {
      try {
        list = auctionItemService.getAuctionItemBySearch(auctionItem, 1);
        pageAllNumBySearch = auctionItemService.getAuctionItemPageCountBySearch(auctionItem);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      session.setAttribute("pageAllNumBySearch",pageAllNumBySearch);
      session.setAttribute("searchAuctionItem",list);
      request.getRequestDispatcher("searchAuctionItem_list.jsp").forward(request,response);

    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  //处理查询传过来的值 如果为空则返回null 不为空生成对应类型的值
  private AuctionItem translation(HttpServletRequest request) {
    String name = null;
    String description = null;
    Date start_time = null;
    Date end_time = null;
    Integer starting_price = null;

    if (!"".equals(request.getParameter("name"))) {
      name = request.getParameter("name");
    }

    if(!"".equals(request.getParameter("description"))){
      description = request.getParameter("description");
    }

    if(!"".equals(request.getParameter("start_time"))){
      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        start_time = sf.parse(request.getParameter("start_time"));
      } catch (ParseException e) {
        e.printStackTrace();
      }

    }
    if(!"".equals(request.getParameter("end_time"))){
      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        start_time = sf.parse(request.getParameter("end_time"));
      } catch (ParseException e) {
        e.printStackTrace();
      }


    }
    if(!"".equals(request.getParameter("starting_price"))){
      starting_price = Integer.parseInt(request.getParameter("starting_price"));
    }

    AuctionItem auctionItem = new AuctionItem(0, name, starting_price, null, start_time, end_time,
        description, null);

     return auctionItem;
  }
}
