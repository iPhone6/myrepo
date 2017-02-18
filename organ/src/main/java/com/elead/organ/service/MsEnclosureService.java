package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.MsEnclosureMapper;
import com.elead.organ.model.MsEnclosure;

/**
 * 附件Service类
 * @author Administrator
 *
 */
@Service
public class MsEnclosureService {
	
	@Autowired
	private MsEnclosureMapper msEnclosureMapper;
	
	
	// 增加一个附件
	public int addMsEnclosure(MsEnclosure me) {
		return msEnclosureMapper.addMsEnclosure(me);
	}
	
	// 删除一个附件（根据id）
	public int deleteMsEnclosureById(Integer id) {
		return msEnclosureMapper.deleteMsEnclosureById(id);
	}
	
	// 修改一个附件（根据id）
	public int updateMsEnclosureById(MsEnclosure me) {
		return msEnclosureMapper.updateMsEnclosureById(me);
	}
	
	// 查询一个附件（根据id）
	public MsEnclosure findMsEnclosureById(Integer id) {
		return msEnclosureMapper.findMsEnclosureById(id);
	}
	
	
	
}
