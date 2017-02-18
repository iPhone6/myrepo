package com.elead.organ.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.elead.organ.model.MsApplication;

/**
 * 应用Mapper类
 * @author Administrator
 *
 */
@Mapper
public interface MsApplicationMapper {
	
	// 添加一个应用
	int addMsApplication(MsApplication ma);
	
	// 根据id删除一个应用
	int deleteMsApplicationById(Integer id);
	
	// 根据id修改一个应用
	int updateMsApplicationById(MsApplication ma);
	
	// 根据id查询一个应用
	MsApplication findMsApplicationById(Integer id);
	
	
}
