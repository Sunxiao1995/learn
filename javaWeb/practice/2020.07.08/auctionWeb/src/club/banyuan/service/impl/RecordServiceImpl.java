package club.banyuan.service.impl;

import club.banyuan.dao.IAuctionRecordDao;
import club.banyuan.dao.impl.AuctionRecordDaoImpl;
import club.banyuan.entity.AuctionItem;
import club.banyuan.entity.AuctionRecord;
import club.banyuan.service.RecordService;
import club.banyuan.util.JdbcUtils;
import java.sql.SQLException;
import java.util.List;

public class RecordServiceImpl implements RecordService {

  @Override
  public List<AuctionRecord> getAuctionRecordByAuctionItem_id(int AuctionItem_id)
      throws SQLException {
    IAuctionRecordDao auctionRecordDao = new AuctionRecordDaoImpl(JdbcUtils.getConnection());

    return auctionRecordDao.getAuctionRecordByAuctionItem_id(AuctionItem_id);
  }

  @Override
  public int getHighPrice(AuctionItem auctionItem) throws SQLException {
    IAuctionRecordDao auctionRecordDao = new AuctionRecordDaoImpl(JdbcUtils.getConnection());
    return auctionRecordDao.getHighPrice(auctionItem);
  }

  @Override
  public int addAuctionRecord(AuctionRecord auctionRecord) throws SQLException {
    IAuctionRecordDao auctionRecordDao = new AuctionRecordDaoImpl(JdbcUtils.getConnection());
    return auctionRecordDao.addAuctionRecord(auctionRecord);
  }
}
