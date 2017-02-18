package com.elead.organ.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.elead.organ.model.User;

/**
 * 用户mapper文件
 */
@Mapper
public interface UserMapper {
	
	/**
	 * 根据用户id查找用户信息
	 * @param id 用户id
	 * @return 用户实体
	 */
	@Select("select  u.*,org.name organizationName FROM ms_user  u,ms_organization  org,ms_orguserlink uo WHERE u.id = uo.userid AND uo.orgid = org.id and u.id = #{id}")
	public User findUserById(@Param("id") Long id);
	
	/**
	 * 查找出所有的有效用户
	 * @return 有效用户实体集合
	 */
	public List<User> findAllEnabledUsers();
	
	/**
	 * 新增用户
	 * @param user 实体对象
	 * @return
	 */
//	@Insert("insert into ms_user (name, orderInDepts, position, mobile, tel, workPlace, remark, email, jobnumber, isHide, isSenior, extattr)"
//			+ "values(#{user.name}, #{user.orderInDepts}, #{user.position}, #{user.mobile}, #{user.tel}, #{user.workPlace}, #{user.remark}, #{user.email}, "
//			+ "#{user.jobnumber}, #{user.isHide}, #{user.isSenior}, #{user.extattr})")
	public int addUser(User user);
	
	/**
	 * 更新对应的用户信息
	 * @param user 要更新的用户实体
	 * @return
	 */
	@Update("update ms_user set name = #{user.name}, orderInDepts = #{user.orderInDepts}, position = #{user.position}, mobile = #{user.mobile}, tel = #{user.tel}, "
			+ "workPlace = #{user.workPlace}, remark = #{user.remark}, email = #{user.email}, jobnumber = #{user.jobnumber}, isHide = #{user.isHide}, "
			+ "isSenior = #{user.isSenior}, extattr = #{user.extattr} "
			+ "where id = #{user.id}")
	public int updateUserById(@Param("user") User user);
	
	/**
	 * 根据id删除对应的用户信息（实际只是修改状态）
	 * @param id 要删除的数据id
	 * @return
	 */
	@Update("update ms_user set enabled = false where id = #{id}")
	public int deleteUserById(Long id);
}
