package com.tq.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.tq.dao.FamilyItemDao;
import com.tq.entity.FamilyItem;
import com.tq.entity.HousePuraseTicket;
import com.tq.entity.SocialsecurityInfo;
import com.tq.entity.TransferHouseholdInfo;
import com.tq.utils.DbContext;
import com.tq.utils.Serialization;

public class FmlItemQueryTest
{
  SqlSession session;

  @Before
  public void init()
  {
    this.session = DbContext.dbContext().openSession();
  }

  @Test
  public void query() {
    List<FamilyItem> list = this.session.selectList("selectByFmlId", "c68111a4-fa60-4bd5-94cb-112438562372");
    System.out.println(Serialization.toJson(list));
    for (FamilyItem familyItem : list)
      System.out.println(familyItem.getOnlyChildNumber());
  }

  @Test
  public void queryTransfer()
  {
    TransferHouseholdInfo info = (TransferHouseholdInfo)this.session.selectOne("selectTransferByItemId", "b86c81ee-e89f-4d67-89fb-138ab7169b53");
    System.out.println(info.getAddress());
  }

  @Test
  public void querySS() {
    SocialsecurityInfo info = (SocialsecurityInfo)this.session.selectOne("selectSocialsecurityByItemId", "b86c81ee-e89f-4d67-89fb-138ab7169b53");
    System.out.println(info.toString());
  }

  @Test
  public void queryHpt() {
    HousePuraseTicket ticket = (HousePuraseTicket)this.session.selectOne("selectHptByItemId", "e8444b8a-df1e-409b-83e0-9c9547d8c3c3");
    System.out.println(ticket.getName());
  }

  @Test
  public void dao() {
    String json = new FamilyItemDao().getFmlItems("08c785aa-2db4-4a5c-96e4-48e4e57078a8");
    System.out.println(json);
  }

  @Test
  public void exists() {
    String json = new FamilyItemDao().existsByIdNumber(null);
    System.out.println(json);
  }
}