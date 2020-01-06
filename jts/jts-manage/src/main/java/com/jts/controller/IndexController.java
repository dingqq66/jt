package com.jts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**实现页面跳转
	 * url:/page/item-add
	 *      /page/item-list
	 *      /page/item-param-list
	 *      
	 * 分析:
	 * 1 page访问前后缀相同
	 * 2 请求路径名称.与跳转页面名称一致
	 * 实现步骤:
	 * 1将变量使用/方法进行分割     
	 * 2 使用{}方式包裹数据
	 * 3实现数据的转化 参数+注解
	 * 
	 * 
	 * */
	
	
@RequestMapping("/page/{moduleName}")
public String itemAdd(@PathVariable String moduleName) {
	return moduleName;
}

}
