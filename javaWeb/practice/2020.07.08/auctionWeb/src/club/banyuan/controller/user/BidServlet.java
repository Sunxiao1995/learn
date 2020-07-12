package club.banyuan.controller.user;

import club.banyuan.entity.AuctionRecord;
import club.banyuan.service.RecordService;
import club.banyuan.service.impl.RecordServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BidServlet" ,urlPatterns = "/bids.do")
public class BidServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      int id = Integer.parseInt(request.getParameter("auctionItem_id"));

      RecordService recordService = new RecordServiceImpl();
      List<AuctionRecord> list = new ArrayList<>();
      String orderListJson = "";
    try {
      list = recordService.getAuctionRecordByAuctionItem_id(id);
      orderListJson = JSONArray
          .toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteNullStringAsEmpty);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    PrintWriter writer = response.getWriter();
    writer.print(orderListJson);
    writer.flush();
    writer.close();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
