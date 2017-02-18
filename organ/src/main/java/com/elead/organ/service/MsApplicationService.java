package com.elead.organ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.MsApplicationMapper;
import com.elead.organ.model.MsApplication;

/**
 * 应用Service类
 * @author Administrator
 *
 */
@Service
public class MsApplicationService {
	
	@Autowired
	private MsApplicationMapper msApplicationMapper;
	
	// 添加一个应用
	public int addMsApplication(MsApplication ma) {
		return msApplicationMapper.addMsApplication(ma);
	}
	
	// 根据id删除一个应用
	public int deleteMsApplicationById(Integer id) {
		return msApplicationMapper.deleteMsApplicationById(id);
	}
	
	// 根据id修改一个应用
	public int updateMsApplicationById(MsApplication ma) {
		return msApplicationMapper.updateMsApplicationById(ma);
	}
	
	// 根据id查询一个应用
	public MsApplication findMsApplicationById(Integer id) {
		return msApplicationMapper.findMsApplicationById(id);
	}
	
	
	
}
