package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;
import java.util.List;

public interface IAuctionItemDao{
  public String getAuctionItemCount();

  public List<AuctionItem> getAuctionItemByPageNum(int pageNum);


  public List<AuctionItem> getAuctionItemBySearch(AuctionItem auctionItem);

  public AuctionItem getAuctionItemById(int id);

  public boolean changeAuctionItem(AuctionItem auctionItem);

  public boolean deleteAuctionItem(int id);


}
