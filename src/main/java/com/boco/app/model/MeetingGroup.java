package com.boco.app.model;

import java.io.Serializable;
import java.util.List;

public class MeetingGroup implements Serializable{
	private static final long serialVersionUID = -3093213331817805927L;
	 private   String id;
     private   String creator;
     private   String createtime;
     private   String updatetime;
     private   String groupdesc;
     private   String name;
     private   String num;
     private   String conversation;
     private   List<User> userList;
     
     
	public MeetingGroup() {
		super();
	}
	public MeetingGroup(String id, String creator, String createtime, String updatetime, String groupdesc,
			String name, String num, String conversation, List<User> userList) {
		super();
		this.id = id;
		this.creator = creator;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.groupdesc = groupdesc;
		this.name = name;
		this.num = num;
		this.conversation = conversation;
		this.userList = userList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getcreatetime() {
		return createtime;
	}
	public void setcreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getupdatetime() {
		return updatetime;
	}
	public void setupdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getGroupdesc() {
		return groupdesc;
	}
	public void setGroupdesc(String groupdesc) {
		this.groupdesc = groupdesc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getConversation() {
		return conversation;
	}
	public void setConversation(String conversation) {
		this.conversation = conversation;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversation == null) ? 0 : conversation.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((groupdesc == null) ? 0 : groupdesc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((updatetime == null) ? 0 : updatetime.hashCode());
		result = prime * result + ((userList == null) ? 0 : userList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingGroup other = (MeetingGroup) obj;
		if (conversation == null) {
			if (other.conversation != null)
				return false;
		} else if (!conversation.equals(other.conversation))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (groupdesc == null) {
			if (other.groupdesc != null)
				return false;
		} else if (!groupdesc.equals(other.groupdesc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (updatetime == null) {
			if (other.updatetime != null)
				return false;
		} else if (!updatetime.equals(other.updatetime))
			return false;
		if (userList == null) {
			if (other.userList != null)
				return false;
		} else if (!userList.equals(other.userList))
			return false;
		return true;
	}
	
	
     
}
