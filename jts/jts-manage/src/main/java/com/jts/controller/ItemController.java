package com.jts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jts.pojo.Item;
import com.jts.pojo.ItemDesc;
import com.jts.service.ItemService;
import com.jts.vo.EasyUITable;
import com.jts.vo.SysResult;
@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	/**
	 * url:http://localhost:8091/item/query?page=1&rows20
	 *   参数page=1 第几页 $ rows=20 每条页数
	 *   返回值EasyUITable的Vo对象
	 * */
	
	@RequestMapping("/query")
	public EasyUITable findItemByPage(int page,int rows) {
		
		return itemService.findItemByPage(page,rows);
	}
	
	/**
	 * url:/item/query/item/desc/1231212
	 * 参数:
	 * 返回值类型: SysResult 必须包含商品详情信息
	 * JSON格式:{"status":200,"msg":"成功",
	 * 			data:{k1:v1,k2:v2,itemDesc:"html代码"
	 * 			}}
	 */
	@RequestMapping("/query/item/desc/{itemId}")
	public SysResult findItemDescById
				(@PathVariable Long itemId) {
		
		ItemDesc itemDesc = 
				itemService.findItemDescById(itemId);
		return SysResult.success(itemDesc);
	}
    
	
	@RequestMapping("/save")
	public SysResult saveItem(Item item,ItemDesc itemDesc) {
		
		itemService.saveItem(item,itemDesc);
		return SysResult.success();
	}
	
	@RequestMapping("/update")
	public SysResult updateItem(Item item,ItemDesc itemDesc) {
		
		itemService.updateItem(item,itemDesc);
		return SysResult.success();
	}
	
	
	@RequestMapping("/delete")
	public SysResult deleteItems(Long[] ids) {
		
		itemService.deleteItems(ids);
		return SysResult.success();
	}
}
