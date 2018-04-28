package com.boco.app.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
     
	private static final long serialVersionUID = -6263368094363176544L;
	private    String id;
      private  String nickname;
      private  String sessionid;
      private  List<MeetingGroup> meetingGroupList;
      
	public User() {
		super();
	}
	public User(String id, String nickname, String sessionid, List<MeetingGroup> meetingGroupList) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.sessionid = sessionid;
		this.meetingGroupList = meetingGroupList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getsessionid() {
		return sessionid;
	}

	public void setsessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public List<MeetingGroup> getMeetingGroupList() {
		return meetingGroupList;
	}

	public void setMeetingGroupList(List<MeetingGroup> meetingGroupList) {
		this.meetingGroupList = meetingGroupList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((meetingGroupList == null) ? 0 : meetingGroupList.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((sessionid == null) ? 0 : sessionid.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (meetingGroupList == null) {
			if (other.meetingGroupList != null)
				return false;
		} else if (!meetingGroupList.equals(other.meetingGroupList))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (sessionid == null) {
			if (other.sessionid != null)
				return false;
		} else if (!sessionid.equals(other.sessionid))
			return false;
		return true;
	}     
}
