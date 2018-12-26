package com.palacios.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.palacios.demo.model.Product;

@Controller
public class EndPointController {

	public EndPointController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String getHomeJsp(Model model){
		 model.addAttribute("name", "Prueba Exitosa");
		 return "home";
	}
	
	@RequestMapping(value="/prueba",method = RequestMethod.GET)
	public ModelAndView getHomeJsp2(HttpServletRequest request,HttpServletResponse  response, HttpSession session){
		 ModelAndView model = new ModelAndView();
		 List<Product> productList = new ArrayList();
		 productList.add(new Product("Jabon",12.56));
		 productList.add(new Product("Shampoo",1.20));
		 productList.add(new Product("Jamon",0.56));
		 
		 model.setViewName("home");
		 model.addObject("productList", productList);
		 return model;
	}

}
