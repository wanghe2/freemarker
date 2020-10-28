package com.wang.freemarker.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@RestController
@RequestMapping("/wang")
public class FreeController {
	
	private final static String Path="D:\\wh\\code\\workspace\\my_workspace\\freemarker\\Web-INF\\staticpage\\";
	
	@Resource(name="testbean")
	Map<String, Object> testbean;
	
	@RequestMapping("/free")
	public String getFree(HttpServletRequest request,HttpServletResponse response,@RequestParam String id) throws IOException, TemplateException {
		System.err.println("***********"+id+"**************");
		HttpClient s=new HttpClient();
		s.getClass();
		System.err.println("\n**************client调用结束");
		// 1.设置配置类
		Configuration configuration=new Configuration(Configuration.getVersion());
		//2. 设置模板所在的目录
		configuration.setDirectoryForTemplateLoading(new File("D:\\wh\\code\\workspace\\my_workspace\\freemarker\\Web-INF\\page"));
		//3.设置字符集
		configuration.setDefaultEncoding("utf-8");	
		//4.加载模板
		Template template=configuration.getTemplate("free.ftl");
		//5.创建数据模型
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("name","周杰伦");
		map.put("message","我是你的老歌迷了");
		//6.创建Writer对象
		File htmlFile=new File(Path+"free"+id+".html");
		FileWriter writer=new FileWriter(htmlFile);
		//7.输出数据模型到文件中
		template.process(map,writer);
		//8.关闭Writer对象
		writer.close();
		//6.把生产页面响应回页面
		String data= FileUtils.readFileToString(htmlFile, "utf-8");
		//设置response查询的码表
		response.setCharacterEncoding("UTF-8");
		//通过一个头"Content-type"告知客户端使用何种码表
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.getWriter().write(data);
        return null;
	}
	
	@RequestMapping("/getTestbean")
	public String getTestBean() {
		System.err.println("********第一个节点"+new Date()+"****************");
		return (String) testbean.get("name");
	}
	
}
