package com.elead.organ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elead.organ.mapper.OrgUserLinkMapper;
import com.elead.organ.mapper.UserMapper;
import com.elead.organ.model.OrgUserLink;
import com.elead.organ.model.User;

/**
 * 用户service
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrgUserLinkMapper orgUserLinkMapper;
	
	/**
	 * 根据用户id查找用户信息
	 * @param id 用户id
	 * @return 用户实体
	 */
	public User findUserById(Long id) {
		return userMapper.findUserById(id);
	}
	
	/**
	 * 新增用户
	 * @param user 实体对象
	 * @return
	 */
	@Transactional
	public int addUser(User user) {
		int ret = userMapper.addUser(user);
		OrgUserLink orgUserLink = new OrgUserLink();
		orgUserLink.setUserid(user.getId());
		//TODO:需要添加根据组织名称查找组织id
		orgUserLink.setOrgid(1);
		orgUserLinkMapper.addOrgUserLink(orgUserLink);
		return ret;
	}
	
	/**
	 * 更新对应的用户信息
	 * @param user 要更新的用户实体
	 * @return
	 */
	@Transactional
	public int updateUserById(User user) {
		return userMapper.updateUserById(user);
	}
	
	/**
	 * 根据id删除对应的用户信息（实际只是修改状态）
	 * @param id 要删除的数据id
	 * @return
	 */
	@Transactional
	public int deleteUserById(Long id) {
		return userMapper.deleteUserById(id);
	}
	
	/**
	 * 查找出所有的有效用户
	 * @return 有效用户实体集合
	 */
	public List<User> findAllEnabledUsers(){
		return userMapper.findAllEnabledUsers();
	}
}
