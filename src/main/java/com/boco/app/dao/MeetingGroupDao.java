package com.boco.app.dao;

import java.util.List;
import java.util.Map;

import com.boco.app.model.MeetingGroup;

public interface MeetingGroupDao {
	/**
	 * 添加会议组   
	 * @param meetingGroup
	 */
	 public  void saveMeetingGroup(MeetingGroup meetingGroup);
	/**
	 * 获取会议组信息及成员信息
	 * @param id
	 * @return
	 */
	 public  MeetingGroup  findMeetingGroupUser(String id);
	 
	 /**
		 * 获取会议组信息
		 * @param id
		 * @return
		 */
     public  MeetingGroup  findMeetingGroup(String id);
     /**
      * 删除组与组内成员之间的对应关系
      * @param userId  groupId
      */
     public  void  deleteGroupUser (Map<String,Object> param);
     /**
      * 删除会议组关联
      * @param groupId
      */
     public  void   deleteGroupRelativity(String groupId);
     /**
      * 删除会议组信息 
      * @param id
      */
     public  void  deleteGroupInfo(String id);
    /**
     * 根据创建者和组id 查找组
     * @param creator
     * @param id
     * @param param
     * @return
     */
     public MeetingGroup  findGroupByCreatorID(Map<String,Object> param);
	 /**
	  * 根据创建者 查找组列表
	  * @param creatorId
	  * @return
	  */
     public List<MeetingGroup>  findGroupListByCreator(String  creatorId);
     
}


