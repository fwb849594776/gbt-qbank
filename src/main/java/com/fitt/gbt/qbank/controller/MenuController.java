package com.fitt.gbt.qbank.controller;

import com.alibaba.fastjson.JSONObject;
import com.fitt.gbt.qbank.common.model.Menu;
import com.fitt.gbt.qbank.job.AccessTokenThread;
import com.fitt.gbt.qbank.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>@Description: 对订阅号的菜单的操作</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-01</p>
 * <p>@version: 1.0</p>
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	private static Logger log = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	//查询全部菜单
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		JSONObject jsonObject = null;
		if (at != null) {
			// 调用接口查询菜单
			jsonObject = menuService.getMenu(at);
			// 判断菜单创建结果
			return String.valueOf(jsonObject);
		}
		log.info("token为" + at);
		return "无数据";
	}

	//创建菜单
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int createMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		int result = 0;
		if (at != null) {

			// 调用接口创建菜单
			result = menuService.createMenu(getFirstMenu(), at);
			// 判断菜单创建结果
			if (0 == result) {
				log.info("菜单创建成功！");
			} else {
				log.info("菜单创建失败，错误码：" + result);
			}
		}
		return result;
	}

	//删除菜单
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public int deleteMenu() {
		// 调用接口获取access_token
		String at = AccessTokenThread.accessToken.getToken();
		int result = 0;
		if (at != null) {
			// 删除菜单
			result = menuService.deleteMenu(at);
			// 判断菜单删除结果
			if (0 == result) {
				log.info("菜单删除成功！");
			} else {
				log.info("菜单删除失败，错误码：" + result);
			}
		}
		return result;
	}


	/**
	 * 组装菜单数据
	 */
	public static Map<String, Object> getFirstMenu() {
		//第一栏菜单：劳协考证(教材习题、练习题库、历年真题)
		Menu menu1 = new Menu();
		menu1.setId("1");
		menu1.setName("劳协考证");
		menu1.setType("click");
		menu1.setKey("1");

		Menu menu11 = new Menu();
		menu11.setId("11");
		menu11.setName("教材习题");
		menu11.setType("click");
		menu11.setKey("11");

		Menu menu12 = new Menu();
		menu12.setId("12");
		menu12.setName("练习题库");
		menu12.setType("click");
		menu12.setKey("12");

		Menu menu13 = new Menu();
		menu13.setId("13");
		menu13.setName("历年真题");
		menu13.setType("click");
		menu13.setKey("13");

		//第二栏菜单：入户指南(积分、学历、技能)
		Menu menu2 = new Menu();
		menu2.setId("2");
		menu2.setName("入户指南");
		menu2.setType("click");
		menu2.setKey("2");

		Menu menu21 = new Menu();
		menu21.setId("21");
		menu21.setName("积分入户");
		menu21.setType("click");
		menu21.setKey("21");

		Menu menu22 = new Menu();
		menu22.setId("22");
		menu22.setName("学历入户");
		menu22.setType("click");
		menu22.setKey("22");

		Menu menu23 = new Menu();
		menu23.setId("23");
		menu23.setName("技能入户");
		menu23.setType("click");
		menu23.setKey("23");

		// 第三栏菜单：谷粑糖(关于我、联系我)
		Menu menu3 = new Menu();
		menu3.setId("3");
		menu3.setName("谷粑糖");
//		menu3.setType("view");
//		menu3.setUrl("http://chunpig.github.io/");
//		menu3.setKey("3");

		Menu menu31 = new Menu();
		menu31.setId("31");
		menu31.setName("关于我");
		menu31.setType("view");
		menu31.setUrl("http://chunpig.github.io/");
		menu31.setKey("31");

		Menu menu32 = new Menu();
		menu32.setId("32");
		menu32.setName("联系我");
		menu32.setType("view");
		menu32.setUrl("http://chunpig.github.io/");
		menu32.setKey("32");

		//最外一层大括号
		Map<String, Object> wechatMenuMap = new HashMap<String, Object>();

		//包装button的List
		List<Map<String, Object>> wechatMenuMapList = new ArrayList<Map<String, Object>>();

		//包装第一栏
		Map<String, Object> menuMap1 = new HashMap<String, Object>();
		Map<String, Object> menuMap11 = new HashMap<String, Object>();
		Map<String, Object> menuMap12 = new HashMap<String, Object>();
		Map<String, Object> menuMap13 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList1 = new ArrayList<Map<String, Object>>();


		//第一栏第一个: 教材习题
		menuMap11.put("name", menu11.getName());
		menuMap11.put("type", menu11.getType());
		menuMap11.put("key", menu11.getKey());
		subMenuMapList1.add(menuMap11);

		//第一栏第二个：练习题库
		menuMap12.put("name", menu12.getName());
		menuMap12.put("type", menu12.getType());
		menuMap12.put("key", menu12.getKey());
		subMenuMapList1.add(menuMap12);

		//第一栏第三个：历年真题
		menuMap13.put("name", menu13.getName());
		menuMap13.put("type", menu13.getType());
		menuMap13.put("key", menu13.getKey());
		subMenuMapList1.add(menuMap13);

		menuMap1.put("name", menu1.getName());
		menuMap1.put("sub_button", subMenuMapList1);

		//包装第二栏
		Map<String, Object> menuMap2 = new HashMap<String, Object>();
		Map<String, Object> menuMap21 = new HashMap<String, Object>();
		Map<String, Object> menuMap22 = new HashMap<String, Object>();
		Map<String, Object> menuMap23 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList2 = new ArrayList<Map<String, Object>>();

		//第二栏第一个：积分入户
		menuMap21.put("name", menu21.getName());
		menuMap21.put("type", menu21.getType());
		menuMap21.put("key", menu21.getKey());
		subMenuMapList2.add(menuMap21);

		//第二栏第二个：学历入户
		menuMap22.put("name", menu22.getName());
		menuMap22.put("type", menu22.getType());
		menuMap22.put("key", menu22.getKey());
		subMenuMapList2.add(menuMap22);

		//第二栏第三个：技能入户
		menuMap23.put("name", menu23.getName());
		menuMap23.put("type", menu23.getType());
		menuMap23.put("key", menu23.getKey());
		subMenuMapList2.add(menuMap23);

		menuMap2.put("name", menu2.getName());
		menuMap2.put("sub_button", subMenuMapList2);

		//包装第三栏
		Map<String, Object> menuMap3 = new HashMap<String, Object>();
		Map<String, Object> menuMap31 = new HashMap<String, Object>();
		Map<String, Object> menuMap32 = new HashMap<String, Object>();
		List<Map<String, Object>> subMenuMapList3 = new ArrayList<Map<String, Object>>();

		//第三栏第一个：关于我
		menuMap31.put("name", menu31.getName());
		menuMap31.put("type", menu31.getType());
		menuMap31.put("key", menu31.getKey());
		menuMap31.put("url", menu31.getUrl());
		subMenuMapList3.add(menuMap31);

		//第三栏第二个：联系我
		menuMap32.put("name", menu32.getName());
		menuMap32.put("type", menu32.getType());
		menuMap32.put("key", menu32.getKey());
		menuMap32.put("url", menu32.getUrl());
		subMenuMapList3.add(menuMap22);

		menuMap3.put("name", menu3.getName());
//		menuMap3.put("type", menu3.getType());
//		menuMap3.put("url", menu3.getUrl());
		menuMap3.put("sub_button", subMenuMapList3);


		wechatMenuMapList.add(menuMap1);
		wechatMenuMapList.add(menuMap2);
		wechatMenuMapList.add(menuMap3);
		wechatMenuMap.put("button", wechatMenuMapList);
		return wechatMenuMap;
	}
}
