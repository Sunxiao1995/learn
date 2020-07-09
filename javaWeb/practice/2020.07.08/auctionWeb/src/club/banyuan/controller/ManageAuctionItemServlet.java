package club.banyuan.controller;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManageAuctionItemServlet",urlPatterns = "/manageAuctionItem.do")
public class ManageAuctionItemServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    AuctionItemService auctionItemService = new AuctionItemServiceImpl();
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    HttpSession session = request.getSession();
    //前端获取当前想要获取的页面
    int pageNowNum;
    if(request.getParameter("pageNowNum") == null){
      pageNowNum = 1;
    } else {
      pageNowNum = Integer.parseInt(request.getParameter("pageNowNum"));
    }

    String pageAllNum = "0";
    try {
      //数据库获取总页面数量
      pageAllNum = String.valueOf(Integer.parseInt(auctionItemService.getAuctionItemCount())/10 + 1)  ;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

//      根据想要获取的页面查询到页面数据
    String orderListJson = "";
    List<AuctionItem> list = null;
    try {
      list = auctionItemService.getAuctionItemByPageNum(pageNowNum);
      orderListJson = JSONArray
          .toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteNullStringAsEmpty);

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    if(request.getParameter("pageNowNum") == null) {
      request.setAttribute("pageAllNum",pageAllNum);
      session.setAttribute("homePage",list);
      request.getRequestDispatcher("searchAuctionItem.jsp").forward(request,response);
    }else {
      PrintWriter writer = response.getWriter();
      writer.print(orderListJson);
      writer.flush();
      writer.close();
    }


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }
}
