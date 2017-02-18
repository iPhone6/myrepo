package com.elead.organ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elead.organ.mapper.MsTaskLogMapper;
import com.elead.organ.model.MsTaskLog;

@Service
public class MsTaskLogService {
	
	@Autowired
	private MsTaskLogMapper msTaskLogMapper;
	
	// 根据任务日志id查询日志信息
	public MsTaskLog queryMsTaskLogById(Integer id) {
		return msTaskLogMapper.queryMsTaskLogById(id);
	}
	
	// 增加一条任务日志
	public int addMsTaskLog(MsTaskLog mt) {
		return msTaskLogMapper.addMsTaskLog(mt);
	}
	
	// 根据任务日志类型查询日志信息
	public List<MsTaskLog> findMsTaskLogByLogType(String log_type) {
		return msTaskLogMapper.findMsTaskLogByLogType(log_type);
	}
	
	
}
