package com.wt.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wt.test.dao.JsonDataDao;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCtest {
	@RequestMapping(value="/testJsonParams",method=RequestMethod.POST)
	public String testJsonParams(@RequestParam(value="jsonStr") String json,Map<String, Object> map) throws Exception{
		JsonDataDao jdd=new JsonDataDao();
		String id=jdd.saveData(json.toString());
		map.put("id", id);
		System.out.println("id="+id);
		return "success";
	}

}
