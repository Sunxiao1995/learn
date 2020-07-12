package club.banyuan.service;

import club.banyuan.entity.AuctionItem;
import java.sql.SQLException;
import java.util.List;

public interface AuctionItemService {
  public String getAuctionItemCount() throws SQLException;

  public List<AuctionItem> getAuctionItemByPageNum(int pageNum) throws SQLException;

  public List<AuctionItem> getAuctionItemBySearch(AuctionItem auctionItem,Integer pageNum) throws SQLException;

  public boolean changeAuctionItem(AuctionItem auctionItem) throws SQLException;

  public boolean deleteAuctionItem(int id) throws SQLException;

  public int getAuctionItemPageCountBySearch(AuctionItem auctionItem) throws SQLException;

  public AuctionItem getAuctionItemById(int id) throws SQLException;

}
