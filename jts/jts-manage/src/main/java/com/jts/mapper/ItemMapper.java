package com.jts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jts.pojo.Item;

public interface ItemMapper extends BaseMapper<Item>{
   @Select ("SELECT * FROM tb_item ORDER BY updated desc limit #{start} ,#{rows}")
	List <Item> findItemByPage(int start,int rows);
}
