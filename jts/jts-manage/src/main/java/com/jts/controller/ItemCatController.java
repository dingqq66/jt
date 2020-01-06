package com.jts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jts.pojo.ItemCat;
import com.jts.service.ItemCatService;
import com.jts.vo.EasyUITree;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
   @Autowired
   private ItemCatService itemCatService ;
   
	/**
	 * 1 url:"/item/cat/queryItemName"
	 * 2 参数:itemCatId:560
	 * 3返回值:name商品分类名称String
	 * 
	 * */
   @RequestMapping("/queryItemName")
   public  String findItemCatNameById(String itemCatId) {
	   ItemCat itemCat =itemCatService.findItemCatById(itemCatId);
	  return itemCat.getName(); 
   }
   
   @RequestMapping("/list")
    public List<EasyUITree> findItemCatparentId (@RequestParam(defaultValue ="0", name ="id") Long  parentId){
	  
	   return itemCatService.findItemCatByParentId(parentId);
   }
   
	
}
