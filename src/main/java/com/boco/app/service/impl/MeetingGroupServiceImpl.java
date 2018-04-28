package com.boco.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boco.app.dao.MeetingGroupDao;
import com.boco.app.model.MeetingGroup;
import com.boco.app.service.MeetingGroupService;
import com.boco.app.util.StringUtil;
@Service("meetingGroupService")
public class MeetingGroupServiceImpl  implements MeetingGroupService {
     @Autowired
     private MeetingGroupDao meetingGroupDao;
     
	public void saveMeetingGroup(MeetingGroup meetingGroup) {
		meetingGroupDao.saveMeetingGroup(meetingGroup);
	}

	public MeetingGroup findMeetingGroupUser(String id) {
		return meetingGroupDao.findMeetingGroupUser(id);
	}

	public MeetingGroup findMeetingGroup(String id) {
		return meetingGroupDao.findMeetingGroup(id);
	}

	public void deleteGroup(String id) {
		meetingGroupDao.deleteGroupRelativity(id);
		meetingGroupDao.deleteGroupInfo(id);
	}
	public void quitGroup(String groupId, String userId) {
		Map<String,Object> param=new HashMap<String, Object>();
		param.put("groupId",groupId);
		param.put("userId", userId);
		meetingGroupDao.deleteGroupUser(param);
	}

	public MeetingGroup findGroupByCreatorID(String creator, String id) {
		Map<String,Object> param=new  HashMap<String, Object>();
		param.put("creator", creator);
		param.put("id", id);
		return meetingGroupDao.findGroupByCreatorID(param);
	}

	public void removeUserFromGroup(String groupId, String member) {
		Map<String,Object>  param=null;
		List<String> userList=StringUtil.splitString(member);
		for(String userId:userList){
			param=new HashMap<String, Object>();
			param.put("groupId", groupId);
			param.put("userId", userId);
			meetingGroupDao.deleteGroupUser(param);//删除组与成员的关联关系
		}
	}

	public List<MeetingGroup> findGroupListByCreator(String creatorId) {
		return meetingGroupDao.findGroupListByCreator(creatorId);
	}
}
