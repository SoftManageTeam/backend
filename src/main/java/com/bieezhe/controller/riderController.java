package com.bieezhe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bieezhe.domain.orders;
import com.bieezhe.domain.rider;
import com.bieezhe.repository.ordersRepository;
import com.bieezhe.repository.riderRepository;
import com.bieezhe.service.RiderService;

@Controller
public class riderController {
	
	@Autowired
	private ordersRepository orderRespository;
	
	@Autowired
	private RiderService RiderService;
	
	@Autowired
	private riderRepository riderRepository;
	
	/**
	 * riderindex跳转到riderindex.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/riderindex.html")
	public String riderindexHtml(HashMap<String, Object> map) {
		// map.put("hello", "欢迎进入HTML页面");
		return "riderindex.html";
	}
	
	/**
	 * riderlogin跳转到riderlogin.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/riderlogin.html")
	public String riderloginHtml(HashMap<String, Object> map) {
		return "riderlogin.html";
	}
	
	/**
	 * riderregister跳转到riderregister.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/riderregister.html")
	public String riderregisterHtml(HashMap<String, Object> map) {
		return "riderregister.html";
	}
	
	/**
	 * member跳转到member.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/member.html")
	public String memberHtml(HashMap<String, Object> map) {
		return "member.html";
	}
	
	/**
	 * shopping跳转到shopping.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/shopping.html")
	public String shoppingHtml(HashMap<String, Object> map) {
		return "shopping.html";
	}
	
	
	/**
	 * product跳转到product.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/product.html")
	public String productHtml(HashMap<String, Object> map) {
		return "product.html";
	}
	
	/**
	 * language跳转到language.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/language.html")
	public String languageHtml(HashMap<String, Object> map) {
		return "language.html";
	}
	
	/**
	 * 返回所有商家
	 * @return
	 */
	@GetMapping(value="/rider")
	public List<orders> getOrders(){
		return orderRespository.findAll();
	}
	
	/**
	 * 骑手注册 注意：requestmapping,默认为get请求，若为post请求的话，必须注明！！
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/postrider", method = RequestMethod.POST)
	@ResponseBody
	public int postrider(@RequestParam Map<String, Object> params) {
		JSONObject rider = (JSONObject) JSONObject.parse((String) params.get("rider"));
		//System.out.println(rider.getString("name"));
		int statusCode = RiderService.addRider(rider);
		return statusCode;
	}
	
	/**
	 * 骑手登录
	 * @param params
	 * @return
	 */
	@PostMapping(value = "/getrider")
	@ResponseBody
	public JSONObject getrider(@RequestParam Map<String ,Object> params)
	{
		JSONObject rider = (JSONObject) JSONObject.parse((String) params.get("data"));
		JSONObject result = RiderService.login(rider);
		return result;
	}
	
	/**
	 * 通过骑手exprname返回顾客订单情况
	 * 
	 * @param customerid
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/riderorder")
	@ResponseBody
	public ArrayList<orders> showOrdersById(@RequestParam Map<String, Object> params) throws Exception {
		ArrayList<orders> orders = new ArrayList<orders>();
		JSONObject data = (JSONObject) JSONObject.parse((String) params.get("Ridername"));
		orders = RiderService.showOrdersById(data);
		return orders;
	}
	

	/**
	 * 
	 */
	@PostMapping(value = "/finishorder")
	@ResponseBody
	public int finishorder(@RequestParam Map<String, Object> params) throws Exception {
		JSONObject data = (JSONObject) JSONObject.parse((String) params.get("data"));
		int statusCode = RiderService.finishorder(data);
		return statusCode;
	}
	
}
