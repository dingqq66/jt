package com.jts.service;

import com.jts.pojo.Item;
import com.jts.pojo.ItemDesc;
import com.jts.vo.EasyUITable;

public interface ItemService {



	EasyUITable findItemByPage(int page, int rows) ;

	void  saveItem(Item item, ItemDesc itemDesc);

	ItemDesc findItemDescById(Long itemId);

	void updateItem(Item item, ItemDesc itemDesc);

	void deleteItems(Long[] ids);


}
