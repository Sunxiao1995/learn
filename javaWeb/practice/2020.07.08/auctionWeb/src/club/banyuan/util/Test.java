package club.banyuan.util;

import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.service.impl.AuctionItemServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

  public static void main(String[] args) throws SQLException {
//    AuctionItemService auctionItemService = new AuctionItemServiceImpl();
//
//    List<AuctionItem> b = auctionItemService.getAuctionItemBySearch(new AuctionItem(1,"9",null,null,null,null,null,null),1);
//    String orderListJson = JSONArray
//        .toJSONStringWithDateFormat(b, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteNullStringAsEmpty);
//
//    System.out.println(orderListJson);
//
//
//    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  Date date = new Date();
    System.out.println(date);
    System.out.println(new java.sql.Timestamp(date.getTime()));

  }

}
