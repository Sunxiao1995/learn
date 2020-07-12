package club.banyuan.dao.impl;

import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.entity.AuctionItem;
import java.sql.Connection;
import java.sql.Date;
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
    Object[] params = getObjects_two(auctionItem,AuctionItemPos);

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
  public int getAuctionItemPageCountBySearch(AuctionItem auctionItem) {
    String sql = "select count(*) from auctionItem where name like if(? is null, name, ?) "
        + "and description like if(? is null, description,?)"
        + "and start_time >= if(? is null,'1000-01-01',?)"
        + "and end_time <= if(? is null,'2999-01-01',?)"
        + "and starting_price >= if(? is null,0,?)"
        + "and state = 1 ";
    Object[] params = getObjects(auctionItem);

    ResultSet rs = executeQuery(sql,params);
    int count = 0;
    try {
      if(rs.next()) {
       count = rs.getInt(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    return count==0?0:count/10+1;
  }

  private Object[] getObjects(AuctionItem auctionItem) {
    Date start_time = null;
    Date end_time = null;
    if(auctionItem.getStart_time() != null){
      start_time = new Date(auctionItem.getStart_time().getTime());
    }

    if(auctionItem.getEnd_time() != null){
      end_time = new Date(auctionItem.getEnd_time().getTime());
    }

    return new Object[]{auctionItem.getName(),"%"+auctionItem.getName()+"%",
        auctionItem.getDescription(),"%"+auctionItem.getDescription()+"%"
        ,auctionItem.getStart_time(),start_time
        ,auctionItem.getEnd_time(),end_time,
        auctionItem.getStarting_price(),auctionItem.getStarting_price()};
  }

  private Object[] getObjects_two(AuctionItem auctionItem ,int AuctionItemPos){
    Object[] objects = getObjects(auctionItem);
    Object[] objects_two = new Object[11];
    System.arraycopy(objects ,0,objects_two,0,10);
    objects_two[10] = AuctionItemPos;
    return objects_two;
  }

  @Override
  public boolean changeAuctionItem(AuctionItem auctionItem) {
    String sql = "update auctionItem set name=?,starting_price=?,base_price=?,start_time=?,end_time=?,description=? where id=?";
    Object[] params = new Object[]{auctionItem.getName(),auctionItem.getStarting_price(),
    auctionItem.getBase_price(),new java.sql.Timestamp(auctionItem.getStart_time().getTime()),
        new java.sql.Timestamp(auctionItem.getEnd_time().getTime()),auctionItem.getDescription()
    ,auctionItem.getId()};

    int i = executeUpdate(sql,params);
    return i > 0;
  }


  @Override
  public AuctionItem getAuctionItemById(int id) {
    String sql = "select * from auctionItem where id = ?";
    Object[] params = new Object[]{id};
    ResultSet rs = executeQuery(sql,params);
    List<AuctionItem> list = new ArrayList<>();
    try{
      list = tableToClass(rs);
    }catch (Exception e){
      e.printStackTrace();
    }
    return list.get(0);

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
    }
    return list;
  }
}
