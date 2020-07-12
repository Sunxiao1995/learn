package club.banyuan.service.impl;

import club.banyuan.dao.IAuctionItemDao;
import club.banyuan.dao.impl.AuctionItemDaoImpl;
import club.banyuan.entity.AuctionItem;
import club.banyuan.service.AuctionItemService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;

public class AuctionItemServiceImpl implements AuctionItemService {

  @Override
  public String getAuctionItemCount() throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.getAuctionItemCount();
  }

  @Override
  public List<AuctionItem> getAuctionItemByPageNum(int pageNum) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.getAuctionItemByPageNum(pageNum);
  }

  @Override
  public List<AuctionItem> getAuctionItemBySearch(AuctionItem auctionItem,Integer pageNum) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.getAuctionItemBySearch(auctionItem ,pageNum);
  }

  @Override
  public int getAuctionItemPageCountBySearch(AuctionItem auctionItem) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.getAuctionItemPageCountBySearch(auctionItem);
  }

  @Override
  public boolean changeAuctionItem(AuctionItem auctionItem) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.changeAuctionItem(auctionItem);
  }

  @Override
  public boolean deleteAuctionItem(int id) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.deleteAuctionItem(id);
  }

  @Override
  public AuctionItem getAuctionItemById(int id) throws SQLException {
    IAuctionItemDao auctionItemDao = new AuctionItemDaoImpl(JdbcUtils.getConnection());
    return auctionItemDao.getAuctionItemById(id);
  }
}
