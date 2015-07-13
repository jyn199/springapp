package com.app.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.app.utils.EncodingUtils;

@Controller
@RequestMapping("/")
@SessionAttributes({"demo"})
public class AppController {

	@RequestMapping(value = "app")
	public ModelAndView appIndex(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/app/index");
		return mav;
	}

	@RequestMapping(value = "")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}

	@RequestMapping(value = "getstring")
	public @ResponseBody
	String getString(@ModelAttribute("demo") String demo,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/plain; charset=UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		return demo;
//		return new String(demo.getBytes("UTF-8"), "ISO-8859-1");
	}

	@RequestMapping("/retvoid")
	public void retvoid() {
		System.out.println("retvoid");
	}

	@RequestMapping(value = "retModelMap")
	public ModelMap retModelMap(@RequestParam String test,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelMap map = new ModelMap();
//		map.put("demo",
//				new String(test.getBytes(EncodingUtils.getEncoding(test)),
//						"UTF-8"));
		map.put("demo", test);
		return map;
	}

	@RequestMapping(value = "test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		String result = null;

		result = "中文！";

		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			out = response.getWriter();
			out.write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
