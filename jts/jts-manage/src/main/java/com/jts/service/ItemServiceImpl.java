package com.jts.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jts.mapper.ItemDescMapper;
import com.jts.mapper.ItemMapper;
import com.jts.pojo.Item;
import com.jts.pojo.ItemDesc;
import com.jts.vo.EasyUITable;

@Service
public class ItemServiceImpl implements ItemService {
	/**
	 * select * from tb_item limit 起始位置:每页条数
	 * 第一页: 每页20条
	 *  select * from tb_item limit 0,20;  0-19
	 * 第二页:
	 * 	select * from tb_item limit 20,20; 20-39
	 * 第三页:
	 * 	select * from tb_item limit 40,20;
	 * 第N页:
	 * 	select * from tb_item limit (page-1)*rows  rows
	 *
	 */
	
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private  ItemDescMapper itemDescMapper;

	public EasyUITable findItemByPage(int page, int rows) {
		int tota = itemMapper.selectCount(null);
		int start =(page-1)*rows;
		List<Item> itemList = itemMapper.findItemByPage(start, rows);

//         IPage<Item> ipage = new Page<>(page,rows);
//		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
//		queryWrapper.orderByDesc("updated");
//		IPage<Item> itemPage = itemMapper.selectPage(ipage,queryWrapper);
//
//		 int total = (int) itemPage.getTotal();
//		 List<Item> records = itemPage.getRecords();
		return new EasyUITable (tota,itemList);
	}

	
	/**
	 * 关于主键自增赋值问题
	 * 说明:一般条件下,当数据入库之后,才会动态生成主键
	 * 如果在关联操作时,需要用主键信息是,一般id为null
	 * 需要动态查询
	 * 思路1 先入库 在查询 获取 主键id 98%正确
	 * 思路2 先入库 动态回传主键信息 mysql配合MP实现
	 * 一般解决思路:需要开启mysql数据的主键回传配置
		
	 * 
	 * */
	@Transactional
	public void saveItem(Item item, ItemDesc itemDesc) {
		item.setStatus(1)
		    .setCreated(new Date())
		    .setUpdated(item.getCreated());
		
		itemMapper.insert(item);//动态赋值id
		
		//实现数据封装
		//实现数据封装
		itemDesc.setItemId(item.getId()); //?????
		itemDesc.setCreated(item.getCreated());
		itemDesc.setUpdated(item.getCreated());
		itemDescMapper.insert(itemDesc);
		
		
	}


	@Override
	public ItemDesc findItemDescById(Long itemId) {
		// TODO Auto-generated method stub
		return itemDescMapper.selectById(itemId);
	}


	@Override
	public void updateItem(Item item, ItemDesc itemDesc) {
		item.setUpdated(new Date());
		itemMapper.updateById(item);
		
		itemDesc.setItemId(item.getId())
				.setUpdated(item.getUpdated());
		itemDescMapper.updateById(itemDesc);
		
	}


	@Override
	public void deleteItems(Long[] ids) {
		List<Long> idList = Arrays.asList(ids);
		itemMapper.deleteBatchIds(idList);
		itemDescMapper.deleteBatchIds(idList);
		
	}

}
