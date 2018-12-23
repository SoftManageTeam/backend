package com.bieezhe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bieezhe.domain.customer;
import com.bieezhe.domain.food;
import com.bieezhe.domain.orderdetail;
import com.bieezhe.domain.orders;
import com.bieezhe.domain.seller;
import com.bieezhe.repository.customerRepository;
import com.bieezhe.repository.foodRepository;
import com.bieezhe.repository.ordersRepository;
import com.bieezhe.repository.orderdetailRepository;
import com.bieezhe.repository.sellerRepository;
import com.bieezhe.service.IndexService;

@Controller
public class indexController {

	@Autowired
	private sellerRepository sellerRepository;

	@Autowired
	private customerRepository customerRepository;

	@Autowired
	private foodRepository foodRepository;

	@Autowired
	private IndexService indexService;

	@Autowired
	private orderdetailRepository orderdetailRespository;

	@Autowired
	private ordersRepository ordersRespository;

	/**
	 * index跳转到index.html
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/index.html")
	public String helloHtml(HashMap<String, Object> map) {
		// map.put("hello", "欢迎进入HTML页面");
		return "/index.html";
	}

	/**
	 * foodlist.html跳转到/foodlist.html
	 * 
	 * @return
	 */
	@GetMapping("/foodlist.html")
	public String foodlistHtml() {
		return "/foodlist.html";
	}

	/**
	 * login.html请求跳转到/login.html
	 * 
	 * @return
	 */
	@GetMapping("/login.html")
	public String loginHtml() {
		return "/login.html";
	}

	/**
	 * register.html请求跳转到register.html
	 * 
	 * @return
	 */
	@GetMapping("/register.html")
	public String registerHtml() {
		return "/register.html";
	}

	/**
	 * shop.html请求跳转到shop.html
	 * 
	 * @return
	 */
	@GetMapping("/shop.html")
	public String shopHtml() {
		return "/shop.html";
	}

	/**
	 * order.html请求跳转到order.html
	 * 
	 * @return
	 */
	@GetMapping("/order.html")
	public String orderHtml() {
		return "/order.html";
	}

	/**
	 * ordering.html请求跳转到ordering.html
	 * 
	 * @return
	 */
	@GetMapping("/ordering.html")
	public String ordeingrHtml() {
		return "/ordering.html";
	}
	
	
	/**
	 * jifenhuodong.html请求跳转到jifenhuodong.html
	 * 
	 * @return
	 */
	@GetMapping("/jifenhuodong.html")
	public String jifenhuodongHtml() {
		return "/jifenhuodong.html";
	}
	

	/**
	 * 用户登录
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	@PostMapping("/getuser")
	@ResponseBody
	public int getuser(@RequestParam Map<String, Object> params) {
		System.out.println(params);
		JSONObject data = (JSONObject) JSONObject.parse((String) params.get("data"));
		String name = data.getString("name");
		String password = data.getString("password");
		int statusCode = indexService.login(name, password);
		return statusCode;
	}

	/**
	 * 用户注册 注意：requestmapping,默认为get请求，若为post请求的话，必须注明！！
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/postuser", method = RequestMethod.POST)
	@ResponseBody
	public int postuser(@RequestParam Map<String, Object> params) {
		// 访问json数据
		JSONObject user = (JSONObject) JSONObject.parse((String) params.get("user"));
		int statusCode = indexService.addCustomer(user);
		return statusCode;
	}

	/**
	 * 发起订单，返回请求结果
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/postorder", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject postorder(@RequestParam Map<String, Object> params) {
		JSONObject order = (JSONObject) JSONObject.parse((String) params.get("order"));
		// System.out.println(username+address+phone+food+totalPrice);
		JSONObject data = indexService.addOrder(order);

		return data;
	} 

	/**
	 * 返回所有商家
	 * 
	 * @return
	 */
	@GetMapping(value = "/index/index")
	public List<seller> getShops() {
		return sellerRepository.findAll();
	}

	/**
	 * 添加一个用户
	 * 
	 * @param cus
	 * @return
	 */
	@PostMapping(value = "/login/signup")
	@ResponseBody
	public Object addCustomer(customer cus) {
		return customerRepository.save(cus);
	}

	/**
	 * 根据商家id返回该商家所有菜品
	 * 
	 * @param sellerid
	 * @return
	 */
	@GetMapping(value = "/index/sellerid/{sellerid}")
	@ResponseBody
	public ArrayList<food> showFoodsById(@PathVariable("sellerid") int sellerid) throws Exception {
		ArrayList<food> foods = null;
		try {
			foods = indexService.getFoodsById(sellerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}

	/**
	 * 通过顾客id返回顾客订单情况
	 * 
	 * @param customerid
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getorder")
	@ResponseBody
	public ArrayList<orders> showOrdersById(@RequestParam Map<String, Object> params) throws Exception {
		ArrayList<orders> orders = null;
		JSONObject data = (JSONObject) JSONObject.parse((String) params.get("data"));
		String Custname = data.getString("Custname");
		try {
			orders = ordersRespository.findAllByCustname(Custname);
			System.out.println(orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	/**
	 * 通过订单id返回订单详细情况
	 * 
	 * @param customerid
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/getorderdetail")
	@ResponseBody
	public orderdetail showDetailorderById(@RequestParam Map<String, Object> params) throws Exception {
		orderdetail orderdetail = null;
		JSONObject data = (JSONObject) JSONObject.parse((String) params.get("data"));
		int orderid = Integer.parseInt(data.getString("orderid"));
		System.out.println(orderid);
		try {
			orderdetail = orderdetailRespository.findAllByOrderid(orderid);
			System.out.println(orderdetail.getFoods());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderdetail;
	}
	/*
	 * @GetMapping(value="") public List<seller>
	 * getShops(@RequestParam("position") String position){
	 * 
	 * return shopList; }
	 */
}
