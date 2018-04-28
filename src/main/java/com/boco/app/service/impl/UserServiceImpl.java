package com.boco.app.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boco.app.dao.UserDao;
import com.boco.app.model.MeetingGroup;
import com.boco.app.model.User;
import com.boco.app.model.User1;
import com.boco.app.service.UserService;
import com.boco.app.util.StringUtil;
@Service("userService")
public class UserServiceImpl implements UserService{
	 @Autowired
     private UserDao userDao;
	 
     public User1 login(User1 user){
     	return userDao.login(user);
     }
     
    
	public User findUserMeetingGroup(String id) {
		
		return userDao.findUserMeetingGroup(id);
	}


	public User findUser(User user) {
		
		return userDao.findUser(user);
	}

	/*public void addUserToGroup( meetingGroup, List<User> userList) {
		 Map<String ,Object>  param= null;
		for(User user:userList){
			   param=new HashMap<String, Object>();  
			   param.put("groupId",meetingGroup.getId() );
			   param.put("userId",user.getId() );
			   userDao.saveRelativity(param);//保存关联
		   }
	}*/
	public void saveUser(User user) {
	          userDao.saveUser(user);
	}

	public User findUserById(String id) {
		return userDao.findUserById(id);
	}


	public List<User> findAllUser() {
		
		return userDao.findAllUser();
	}


	public void addUserToGroup(String groupId, String member) {	
		 Map<String ,Object>  param= null;
		 List<String> userList=StringUtil.splitString(member);
			for(String user:userList){
				   param=new HashMap<String, Object>();  
				   param.put("groupId",groupId);
				   param.put("userId",user);
				   userDao.saveRelativity(param);//保存关联
			   }
	    }


/*	public List<MeetingGroup> findGroupListByUserId(String user_id) {
		// TODO Auto-generated method stub
		return userDao.findGroupListByUserId(user_id);
	}*/
}
