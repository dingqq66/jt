package com.jts.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_item")
public class Item  extends BasePojo {
  @TableId(type = IdType.AUTO)
  private  Long id;
  private  String title;
  private String sellPoint ;
  private Long price;
  private Integer num;
  private String barcode;
  private String image;
  private Long cid;
  private Integer status;
}
