package com.elead.organ.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.elead.organ.model.MsEnclosure;

/**
 * 附件Mapper类型
 * @author Administrator
 *
 */
@Mapper
public interface MsEnclosureMapper {
	
	// 增加一个附件
	int addMsEnclosure(MsEnclosure me);
	
	// 删除一个附件（根据id）
	int deleteMsEnclosureById(Integer id);
	
	// 修改一个附件（根据id）
	int updateMsEnclosureById(MsEnclosure me);
	
	// 查询一个附件（根据id）
	MsEnclosure findMsEnclosureById(Integer id);
	
	
}
