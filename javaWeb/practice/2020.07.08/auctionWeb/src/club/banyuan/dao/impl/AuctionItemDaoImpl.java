package club.banyuan.dao.impl;

import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.entity.AuctionItem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionItemDaoImpl extends BaseDaoImpl implements IAuctionItemDao {

  public AuctionItemDaoImpl(Connection connection) {
    super(connection);
  }

  @Override
  public String getAuctionItemCount() {
    //0表示已被拍卖 1表示还未拍卖或者正在拍卖中
    String sql = "select count(*) from auctionItem where state=?";
    Object [] params = new Object[]{1};
    ResultSet rs = executeQuery(sql,params);
    String count = "0";
    try {
      if(rs.next()){
        count = rs.getString(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return count ;
  }

  @Override
  public List<AuctionItem> getAuctionItemByPageNum(int pageNum) {
    int AuctionItemPos = (pageNum-1)*10;
    String sql = "select * from auctionItem where state=1 limit ?,10";
    Object [] params = new Object[]{AuctionItemPos};
    ResultSet rs = executeQuery(sql,params);
    List<AuctionItem> list = new ArrayList<>();
    try{
      list = tableToClass(rs);
    }catch (Exception e){
      e.printStackTrace();
    }
    return list;
  }


  @Override
  public List<AuctionItem> getAuctionItemBySearch(AuctionItem auctionItem,Integer pageNum) {
    int AuctionItemPos = (pageNum-1)*10;
    String sql = "select * from auctionItem where name like if(? is null, name, ?) "
        + "and description like if(? is null, description,?)"
        + "and start_time >= if(? is null,'1000-01-01',?)"
        + "and end_time <= if(? is null,'2999-01-01',?)"
        + "and starting_price >= if(? is null,0,?)"
        + "and state = 1 limit ?,10";
    Object [] params = new Object[]{auctionItem.getName(),"%"+auctionItem.getName()+"%",
    auctionItem.getDescription(),"%"+auctionItem.getDescription()+"%"
        ,auctionItem.getStart_time(),new java.sql.Date(auctionItem.getStart_time().getTime())
        ,auctionItem.getEnd_time(),new java.sql.Date(auctionItem.getEnd_time().getTime()),
        auctionItem.getStarting_price(),auctionItem.getStarting_price(),AuctionItemPos};

    ResultSet rs = executeQuery(sql,params);
    List<AuctionItem> list = new ArrayList<>();
    try{
      list = tableToClass(rs);
    }catch (Exception e){
      e.printStackTrace();
    }
    return list;
  }

  @Override
  public boolean changeAuctionItem(AuctionItem auctionItem) {
    String sql = "update auctionItem set name=?,starting_price=?,base_price=?,start_time=?,end_time=?,description=? where id=?";
    Object[] params = new Object[]{auctionItem.getName(),auctionItem.getStarting_price(),
    auctionItem.getBase_price(),new java.sql.Date(auctionItem.getStart_time().getTime()),
        new java.sql.Date(auctionItem.getEnd_time().getTime()),auctionItem.getDescription()
    ,auctionItem.getId()};

    int i = executeUpdate(sql,params);
    return i > 0;
  }

  @Override
  public boolean deleteAuctionItem(int id) {
    String sql = "delete from auctionItem where id = ?";
    Object[] params = new Object[]{id};
    int i = executeUpdate(sql,params);

    return i>0;
  }

  @Override
  public List<AuctionItem> tableToClass(ResultSet rs) throws Exception {
    List<AuctionItem> list = new ArrayList<>();
    while (rs.next()){
      AuctionItem auctionItem = new AuctionItem();
      auctionItem.setId(rs.getInt(1));
      auctionItem.setName(rs.getString(2));
      auctionItem.setStarting_price(rs.getInt(3));
      auctionItem.setBase_price(rs.getInt(4));
      auctionItem.setStart_time(rs.getTimestamp(5));
      auctionItem.setEnd_time(rs.getTimestamp(6));
      auctionItem.setDescription(rs.getString(7));
      auctionItem.setState(rs.getInt(8));
      list.add(auctionItem);
      System.out.println(auctionItem.getId());
    }
    return list;
  }
}
