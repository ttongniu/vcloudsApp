package com.boco.app.dao;


import java.util.List;
import java.util.Map;

import com.boco.app.model.MeetingGroup;
import com.boco.app.model.User;
import com.boco.app.model.User1;

public interface UserDao {
	  public User1 login   (User1 user);	 
	  /**
	   * 添加用户
	   * @param user
	   */
	  public void saveUser(User user);
	  /**
	   * 根据id 查询用户基本信息
	   * @param id
	   * @return
	   */
	  public User findUserById(String id);
	  /**
	   * 根据id 查询用户信息及会议组信息 
	   * @param user
	   * @return
	   */
	 public User  findUser(User user);
	 /**
	  * 通过Userid 查找user信息以及会议组信息 
	  * @param id
	  * @return
	  */
	 public User findUserMeetingGroup(String id); 
	  
	/**
	 * 保存关联关系 
	 * @param param
	 */
	 public void saveRelativity (Map<String,Object> param);
	
	 /**
	  * 
	  * @param user_id
	  * @return
	  */
	  public List<MeetingGroup>  findGroupListByUserId(String user_id);
	  /**
	   * 查找所有的user
	   * @return
	   */
	  List<User> findAllUser();
	  
	  
	  
}
