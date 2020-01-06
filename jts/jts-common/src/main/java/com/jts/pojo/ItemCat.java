package com.jts.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@TableName("tb_item_cat")
@Setter
@Getter
public class ItemCat extends BasePojo {
   /**
	 * 
	 */
	private static final long serialVersionUID = 4809185165116840160L;
@TableId(type = IdType.AUTO)
   private Long id;
   private Long parentId;
   private String name;
   private Integer status;
   private Integer sortOrder;
   private Boolean isParent;
}
