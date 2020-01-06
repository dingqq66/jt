package com.jts.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@TableName("tb_item_desc")
@Data
@Accessors(chain = true)
public class ItemDesc extends BasePojo {
	
	@TableId
	private Long itemId;//id必须与商品id好一致
	private String itemDesc;//商品详情信息html
	

}
