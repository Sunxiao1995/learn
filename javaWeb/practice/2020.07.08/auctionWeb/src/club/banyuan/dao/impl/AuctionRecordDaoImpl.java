package club.banyuan.dao.impl;

import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.dao.IAuctionRecordDao;
import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.AuctionRecord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionRecordDaoImpl extends BaseDaoImpl implements IAuctionRecordDao {

  public AuctionRecordDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public List<AuctionRecord> getAuctionRecordByAuctionItem_id(int AuctionItem_id) {
    String sql = "select a.*,u.userName from auctionRecord a inner join user u on a.userId = u.id where auctionItem_id = ? order by price desc limit 0,4";
    Object[] params = new Object[]{AuctionItem_id};
    ResultSet rs = executeQuery(sql,params);
    List<AuctionRecord> list = new ArrayList<>();

    try {
      list = tableToClass(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }


  @Override
  public int getHighPrice(AuctionItem auctionItem) {
    String sql = "select max(price) from auctionRecord where auctionItem_id = ? ";
    Object[] params = new Object[]{auctionItem.getId()};

    ResultSet rs = executeQuery(sql,params);
    int a = 0;
    try {
      if(rs.next()){
        a=rs.getInt(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return a;
  }


  @Override
  public int addAuctionRecord(AuctionRecord auctionRecord) {
    String sql = "insert into auctionRecord values (null,?,?,?,?)";
    Object [] params = new Object[]{
        auctionRecord.getUserId(),new java.sql.Timestamp(auctionRecord.getTime().getTime())
        ,auctionRecord.getPrice(),auctionRecord.getAuctionItem_id()
    };


    int i = executeInsert(sql,params);
    return i;
  }

  @Override
  public List<AuctionRecord> tableToClass(ResultSet rs) throws Exception {
    List<AuctionRecord> list = new ArrayList<>();
    while (rs.next()){
      AuctionRecord auctionRecord = new AuctionRecord();
      auctionRecord.setId(rs.getInt(1));
      auctionRecord.setUserId(rs.getInt(2));
      auctionRecord.setTime(rs.getTimestamp(3));
      auctionRecord.setPrice(rs.getInt(4));
      auctionRecord.setAuctionItem_id(rs.getInt(5));
      auctionRecord.setUserName(rs.getString(6));
      list.add(auctionRecord);
    }
    return list;
  }
}
