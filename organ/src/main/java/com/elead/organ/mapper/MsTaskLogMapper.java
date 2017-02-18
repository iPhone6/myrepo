package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.elead.organ.model.MsTaskLog;

@Mapper
public interface MsTaskLogMapper {
	
	// 根据任务日志id查询日志信息
	MsTaskLog queryMsTaskLogById(Integer id);
	
	// 增加一条任务日志
	int addMsTaskLog(MsTaskLog mt);
	
	// 根据任务日志类型查询日志信息
	List<MsTaskLog> findMsTaskLogByLogType(String log_type);
	
}
