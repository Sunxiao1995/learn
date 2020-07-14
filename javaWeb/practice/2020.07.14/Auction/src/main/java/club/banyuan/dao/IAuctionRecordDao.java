package club.banyuan.dao;

import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.AuctionRecord;
import java.util.List;

public interface IAuctionRecordDao{
  public List<AuctionRecord> getAuctionRecordByAuctionItem_id(int AuctionItem_id);

  public int getHighPrice(AuctionItem auctionItem);

  public int addAuctionRecord(AuctionRecord auctionRecord);


}
