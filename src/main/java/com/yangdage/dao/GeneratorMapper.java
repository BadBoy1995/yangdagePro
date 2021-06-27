package com.yangdage.dao;
import com.yangdage.model.BeanColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据库接口
* @Title: GeneratorMapper.java 
* @Package com.fc.v2.mapper.auto 
* @author fuce  
* @date 2019年5月9日 上午12:31:13 
* @version V1.0   
 */
@Mapper
public interface GeneratorMapper {
	 /**
	  * 查询表详情
	  * @param tableName
	  * @return
	  */
	 List<BeanColumn> queryColumns2(String tableName);
}
