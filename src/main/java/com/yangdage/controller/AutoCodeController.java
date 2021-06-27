package com.yangdage.controller;

import com.yangdage.model.AutoConfigModel;
import com.yangdage.model.BeanColumn;
import com.yangdage.model.TableInfo;
import com.yangdage.service.GeneratorService;
import com.yangdage.util.AutoCodeUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码自动生成
 * 
 * @ClassName: AutoCodeController
 */
@Controller
@RequestMapping("/autoCodeController")
public class AutoCodeController {

	private String prefix = "admin/autoCode";
	@Autowired
	private GeneratorService generatorService;


	/**
	 * 生成文件Zip
	 * 
	 * @author fuce
	 * @throws IOException
	 * @Date 2021年1月15日 下午2:21:55
	 */
	@GetMapping("/createAutoZip")
	@ResponseBody
	public void createAutoZip(AutoConfigModel autoConfigModel, HttpServletResponse response) throws IOException {
		byte[] b;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);
		// 根据表名查询表字段集合
		List<BeanColumn> list = generatorService.queryColumns2(autoConfigModel.getTableName());
		// 初始化表信息
		TableInfo tableInfo = new TableInfo(autoConfigModel.getTableName(), list, autoConfigModel.getTableComment());
		// 自动生成
		AutoCodeUtil.autoCodeOneModel(tableInfo, autoConfigModel, zip);
		IOUtils.closeQuietly(zip);
		b = outputStream.toByteArray();
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"v2.zip\"");
		response.addHeader("Content-Length", "" + b.length);
		response.setContentType("application/octet-stream; charset=UTF-8");
		IOUtils.write(b, response.getOutputStream());
	}

	/**
	 * 预览生成文件
	 * 
	 * @author fuce
	 * @Date 2021年1月15日 下午2:21:55
	 */
	@GetMapping("/viewAuto")
	public String viewAuto(AutoConfigModel autoConfigModel, ModelMap model) {
		List<BeanColumn> list = generatorService.queryColumns2(autoConfigModel.getTableName());
		TableInfo tableInfo = new TableInfo(autoConfigModel.getTableName(), list, autoConfigModel.getTableComment());
		Map<String, String> map = AutoCodeUtil.viewAuto(tableInfo,autoConfigModel);
		model.put("viewmap", map);
		return prefix + "/view";
	}

}