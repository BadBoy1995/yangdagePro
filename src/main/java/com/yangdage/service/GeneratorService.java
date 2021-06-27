package com.yangdage.service;

import com.yangdage.dao.GeneratorMapper;
import com.yangdage.model.BeanColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 自动生成代码Service
* @Title: GeneratorService.java
* @Package com.fc.v2.service
* @author fuce 
* @date 2019年5月9日 上午12:24:47
* @version V1.0 
 */
@Service
public class GeneratorService {
	@Autowired
	private GeneratorMapper generatorMapper;

	/**
	  * 查询表详情
	  * @param tableName
	  * @return
	  */
	public List<BeanColumn> queryColumns2(String tableName){
		return generatorMapper.queryColumns2(tableName);
	 }
	
}
