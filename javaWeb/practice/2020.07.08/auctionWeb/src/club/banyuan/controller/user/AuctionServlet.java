package club.banyuan.controller.user;

import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.AuctionRecord;
import club.banyuan.entity.User;
import club.banyuan.service.RecordService;
import club.banyuan.service.impl.RecordServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AuctionServlet",urlPatterns = "/auction.do")
public class AuctionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session =  request.getSession();
    response.setCharacterEncoding("utf-8");
    int priceNow = Integer.parseInt(request.getParameter("priceNow"));
    AuctionItem auctionItem = (AuctionItem) session.getAttribute("startAuction") ;
    User user = (User) session.getAttribute("user");

    RecordService recordService = new RecordServiceImpl();
    int highPrice=0;
    try {
      highPrice = recordService.getHighPrice(auctionItem);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    if(priceNow<=highPrice){
      String error = "不能低于最高竞拍价";
      PrintWriter writer = response.getWriter();
      writer.print(error);
      writer.flush();
      writer.close();
    }else {
      AuctionRecord auctionRecord = new AuctionRecord();
      auctionRecord.setUserId(user.getId());
      auctionRecord.setPrice(priceNow);
      auctionRecord.setAuctionItem_id(auctionItem.getId());
      Date date = new Date();
      System.out.println(date);
      auctionRecord.setTime(date);
      try {
        int i = recordService.addAuctionRecord(auctionRecord);
        if(i>0){
          String success = "竞拍成功";
          PrintWriter writer = response.getWriter();
          writer.print(success);
          writer.flush();
          writer.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }


    }



  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
