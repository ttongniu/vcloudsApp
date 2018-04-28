package com.boco.app.service;

import java.util.List;

import com.boco.app.model.MeetingGroup;
import com.boco.app.model.User;
import com.boco.app.model.User1;
public interface UserService {
	public User1 login (User1 user);
	/**
	 * 通过用户id来获取用户信息及会议组列表
	 * @param id
	 * @return
	 */
	public  User  findUserMeetingGroup(String id);
	
	/**
	 * 通过用户id来获取用户基本信息
	 * @param user
	 * @return
	 */
	public User findUser(User user);
	
	/**
	 * 添加成员
	 * @param groupId
	 * @param member
	 *       1344,12324,14325,1231
	 */
	public  void addUserToGroup(String groupId,String member);
	/**
	 * 保存用户信息
	 * @param user
	 */
	public void saveUser(User user);
	
	 /**
	   * 根据id 查询用户基本信息
	   * @param id
	   * @return
	   */
    public User findUserById(String id);
	/*
	  public List<MeetingGroup>  findGroupListByUserId(String user_id);*/
    /**
     * 查找所有的user
     * @return
     */
     List<User> findAllUser();  
    
	
}
