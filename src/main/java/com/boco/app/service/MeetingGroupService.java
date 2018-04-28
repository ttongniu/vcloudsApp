package com.boco.app.service;

import java.util.List;

import com.boco.app.model.MeetingGroup;
public interface MeetingGroupService {
       
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
	 * 会议组中移除成员
	 * @param groupId  
	 *             会议组ID
	 * @param member
	 *          移除成员ID 23423,234534,243422
	 */
     public   void  removeUserFromGroup(String groupId,String member);
    /**
     *  删除会议组
     * @param id
     */
     public void  deleteGroup(String id);
     /**
      * 退出群组
      * @param groupId
      * @param userId
      */
     public void  quitGroup(String groupId,String userId);
     
     /**
      * 根据创建者和组id 查找组
      * @param creator
      * @param id
      * @param 
      * @return
      */
      public MeetingGroup  findGroupByCreatorID(String creator,String id);
      
      /**
 	  * 根据创建者 查找组列表
 	  * @param creatorId
 	  * @return
 	  */
      public List<MeetingGroup>  findGroupListByCreator(String  creatorId);
     
}
