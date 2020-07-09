package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;
import java.util.List;

public interface IAuctionItemDao extends IBaseDao{
  public String getAuctionItemCount();

  public List<AuctionItem> getAuctionItemByPageNum(int pageNum);


  public List<AuctionItem> getAuctionItemBySearch(AuctionItem auctionItem,Integer pageNum);

  public boolean changeAuctionItem(AuctionItem auctionItem);

  public boolean deleteAuctionItem(int id);

}
