package club.banyuan.service;

import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.AuctionRecord;
import java.sql.SQLException;
import java.util.List;

public interface RecordService {
  public List<AuctionRecord> getAuctionRecordByAuctionItem_id(int AuctionItem_id)
      throws SQLException;

  public int getHighPrice(AuctionItem auctionItem) throws SQLException;

  public int addAuctionRecord(AuctionRecord auctionRecord) throws SQLException;



}
