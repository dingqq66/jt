package com.jts.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jts.pojo.ItemCat;
import com.jts.vo.EasyUITree;


public interface ItemCatService {

	ItemCat findItemCatById(String itemId);

	List<EasyUITree> findItemCatByParentId(Long parentId);

}
