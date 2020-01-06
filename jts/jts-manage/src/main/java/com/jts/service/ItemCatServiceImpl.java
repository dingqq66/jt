package com.jts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.jts.mapper.ItemCatMapper;
import com.jts.pojo.ItemCat;
import com.jts.vo.EasyUITree;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private  ItemCatMapper itemCatMapper;

	@Override
	public ItemCat findItemCatById(String itemCatId) {
		return itemCatMapper.selectById(itemCatId);
	}

	@Override
	public List<EasyUITree> findItemCatByParentId(Long parentId) {
	List<EasyUITree>  treeList =  new ArrayList<>();
	List<ItemCat> itemList	= findItemCatListByParentId(parentId);
		for (ItemCat a:itemList) {
			Long id = a.getId();
			String text = a.getName();
		String state=a.getIsParent()?"closed":"open";
		EasyUITree uiTree = 	new EasyUITree(id,text,state);
		  treeList.add(uiTree);
		}
		
		
		
		return treeList;
	}

	private List<ItemCat> findItemCatListByParentId(Long parentId) {
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<ItemCat>();
         queryWrapper.eq("parent_id", parentId);
		return itemCatMapper.selectList(queryWrapper);
	}

	
	
	

}
