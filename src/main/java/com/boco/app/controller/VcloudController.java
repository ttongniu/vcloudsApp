package com.boco.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boco.app.model.AccessToken;
import com.boco.app.model.MeetingGroup;
import com.boco.app.model.User;
import com.boco.app.service.MeetingGroupService;
import com.boco.app.service.SimbaService;
import com.boco.app.service.UserService;
import com.boco.app.service.VCloudService;
import com.boco.app.util.GetUrlUtil;
import com.boco.app.util.ReadProperties;
import com.boco.app.util.StringUtil;

@Controller
public class VcloudController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MeetingGroupService meetingGroupService;
	ReadProperties readProperties = new ReadProperties("paramConfigure.properties");

	/**
	 * 进入我的会议 个人会议组列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/meetingGroupList")
	public String meetingGroupList(User activeuser,  HttpSession session, Model model) {
		User user = new User();
		// 调用获取Simba的Url
		String url =GetUrlUtil.getUrl(request);
		logger.info("url*************：" + url);
		if(url.contains("token")){
			// 调用获取Simba的token值
			//String token = StringUtil.getTokenString(url);
			String token="944d4e29cd1333a26d733b1c9a397cb5";
			logger.info("simba的token*************：" + token);
			session.setAttribute("token", token);
			// 获取当前登录id 和昵称
			String simbaAPPId=readProperties.GetPara("simbaAPPId");
	        String  loginResult = SimbaService.loginByCheckedToken(simbaAPPId, token);
			logger.info("loginresult************"+loginResult);
			JSONObject loginResultObject=JSON.parseObject(loginResult);
			
			// 调用获取露脸toten的值（时间过期会失效）
			String tokenUrl = readProperties.GetPara("tokenUrl");
			String client_id = readProperties.GetPara("client_id");
			String client_secret = readProperties.GetPara("client_secret");
			String grant_type = readProperties.GetPara("grant_type");
			String result = VCloudService.token(tokenUrl, client_id, client_secret, grant_type);
			logger.info("result************" + result);
			AccessToken accessToken = JSON.parseObject(result, AccessToken.class);
			String vToken = accessToken.getAccess_token();
			logger.info("露脸的token值***********" + vToken);
			session.setAttribute("vToken", vToken);
			logger.info("露脸的APPId*******"+client_id);
			session.setAttribute("appId", client_id);
			// 调用创建用户的方法
			String create_if_absentUrl = readProperties.GetPara("create_if_absentUrl");
			String app_user_id = loginResultObject.getString("acc_nbr");
			String app_user_nick_name = loginResultObject.getString("nick_name");	
			String appuser = VCloudService.create_if_absent(create_if_absentUrl, app_user_id, app_user_nick_name,  vToken);
			// 把返回的sessionid 放入session中使用
			logger.info("appuser*********:"+appuser);
			JSONObject appuserObject = JSON.parseObject(appuser);
			String session_id = appuserObject.getJSONObject("user").getString("session_id");
			logger.info("sessionId**************:" + session_id);
			
			//判断本地中有该用户  无用户的话保存该用户
		    //todo
			User  userBase=  userService.findUserById(app_user_id);
			user.setId(app_user_id);
			user.setNickname(app_user_nick_name);
			user.setsessionid(session_id);
			//当前用户存入session
			session.setAttribute("activeUser", user);
			if(userBase==null){
				// 保存user		
		        userService.saveUser(user);	
		        logger.info("****************"+"用户信息保存成功！！！");
			}			
			// 调用获取个人组信息列表的方法
			/*User userInfo = userService.findUser(user);
			List<MeetingGroup> meetingGroupList = userInfo.getMeetingGroupList();
			for (MeetingGroup meetingGroup : meetingGroupList) {
				logger.debug("userWithGroup*************id：" + meetingGroup.getId());
				logger.debug("userWithGroup*************name：" + meetingGroup.getName());
			}
			model.addAttribute("userInfo", userInfo);*/
			//调用查找个人创建会议组列表
			List<MeetingGroup> meetingGroupList=meetingGroupService.findGroupListByCreator(user.getId());
			model.addAttribute("meetingGroupList", meetingGroupList);
		}else{
			            //重定向路径
			           /* user.setId(activeuser.getId());
			            // 调用获取个人组信息列表的方法
						User activeuserInfo = userService.findUser(user);
						List<MeetingGroup> meetingGroupList = activeuserInfo.getMeetingGroupList();
						for (MeetingGroup meetingGroup : meetingGroupList) {
							logger.debug("userWithGroup*************id：" + meetingGroup.getId());
							logger.debug("userWithGroup*************name：" + meetingGroup.getName());
						}
						model.addAttribute("userInfo", activeuserInfo);*/
			List<MeetingGroup> meetingGroupList=meetingGroupService.findGroupListByCreator(activeuser.getId());
			model.addAttribute("meetingGroupList", meetingGroupList);
		}		
		return "meetingGroupList";
	}
	/**
	 * 跳转创建会议组界面
	 * 
	 * @return
	 */
	@RequestMapping("/toAddMeetingGroupPage")
	public String toAddMeetingGroupPage() {
		return "createMeetingGroup";
	}
	/**
	 * 跳转添加成员界面
	 * 
	 * @param meetingGroup
	 * @return
	 */
	@RequestMapping("/toAddUserPage")
	public String toAddUserPage(MeetingGroup meetingGroup, Model model) {
		logger.info("meetingGroup*************+name" + meetingGroup.getName());
		model.addAttribute("meetingGroup", meetingGroup);
		//查找组织成员列表		
        List<User>	userList=userService.findAllUser();
        logger.info("userList人数信息："+userList.size());
		model.addAttribute("userList", userList);
		return "addUserToGroup";
	}

	/**
	 * 创建新的会议组
	 * 
	 * @param meetingGroup
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/addMeetingGroup")
	public String addMeetingGroup(  String name, User user, Model model) {
		logger.info("meetingGroup的名称******："+name);
		logger.info("user的id*********:"+user.getId());			
	    //调用露脸云的创建群组的方法
		String createGroupUrl = readProperties.GetPara("createGroupUrl");
		String member = user.getId();
		String groupname = name;
		String token = (String) request.getSession().getAttribute("vToken");
		User activeUser=   (User) request.getSession().getAttribute("activeUser");
		String clientSession = activeUser.getsessionid();
		String appid = readProperties.GetPara("client_id");
		logger.info("member:"+member+"groupname:"+groupname+"token:"+token+"clientSession:"+clientSession+"appid:"+appid);
		String groupInfo = VCloudService.createGroup(createGroupUrl, member, groupname,  token, clientSession, appid);
		logger.info("groupInfo*************" + groupInfo);
		JSONObject groupInfoObject = JSON.parseObject(groupInfo);
		if(("2000").equals(groupInfoObject.getString("error_code"))){
		// 保存群组信息在本地
		MeetingGroup group = new MeetingGroup();
		group.setId(groupInfoObject.getString("id"));
		group.setName(name);
		group.setNum(groupInfoObject.getString("number"));
		group.setupdatetime(groupInfoObject.getString("update_time"));
		group.setcreatetime(groupInfoObject.getString("create_time"));
		group.setConversation(groupInfoObject.getString("conversation")==null?"0":groupInfoObject.getString("conversation"));
		group.setCreator(groupInfoObject.getString("creator"));
		group.setGroupdesc(groupInfoObject.getString("desc")==null?"":groupInfoObject.getString("desc"));
		meetingGroupService.saveMeetingGroup(group);
		// 保存关联关系(本地)
		String memberids=activeUser.getId()+","+user.getId();
		userService.addUserToGroup(group.getId(), memberids);
		}
		return "redirect:/meetingGroupList.do?id="+activeUser.getId();

	}

	/**
	 * 跳转移除成员界面
	 */
	@RequestMapping("/removeUserPage")
	public String removeUserPage(Model model) {
		MeetingGroup meetingGroup = new MeetingGroup();
		meetingGroup.setId("9a5750509fd611e6a5240d90a228d8b2");
		MeetingGroup group = meetingGroupService.findMeetingGroup(meetingGroup.getId());
		List<User> userList = group.getUserList();
		for (User user : userList) {
			logger.info("user***************" + user.getId());
			logger.info("user*************name" + user.getNickname());
		}
		model.addAttribute("group", group);
		return "removeUserFromGroup";
	}

	/**
	 * 移除成员
	 * 
	 * @return
	 */
	@RequestMapping("/removeUser")
	public String removeUser(String groupId, User  user) {
		// 调用露脸云上群组移除成员的接口
		if(user.getId()!=null){
		String removeUrl = readProperties.GetPara("removeUrl");
		String group_id = groupId;
		String member = user.getId();
		String token = (String) request.getSession().getAttribute("vToken");
		User activeUser=   (User) request.getSession().getAttribute("activeUser");
		String clientSession = activeUser.getsessionid();
		String appId = readProperties.GetPara("client_id");
		logger.info("********group_id："+group_id+"member："+member+"token:"+token+"clientSession:"+clientSession+"appId:"+appId);
		String removeResult = VCloudService.removeGroup(removeUrl, group_id, member, token, clientSession, appId);
		logger.info("removeResult*********" + removeResult);
		JSONObject removeResultObject = JSON.parseObject(removeResult);
		logger.info("error_code*********" + removeResultObject.getString("error_code"));
		if (("2000").equals(removeResultObject.getString("error_code"))) {
			// 删除关联关系
			meetingGroupService.removeUserFromGroup(groupId, member);
		}
		}
		return "redirect:/groupInfo.do?id="+groupId;
	}

	/**
	 * 删除会议组
	 * 
	 * @return
	 */
	@RequestMapping("/deleteMeetingGroup")
	public String deleteMeetingGroup(MeetingGroup meetingGroup) {
		// 调用露脸的删除会议群组
		String exitGroupUrl = readProperties.GetPara("exitGroupUrl");
		String group_id = meetingGroup.getId();
		String token = (String) request.getSession().getAttribute("vToken");
		User activeUser=   (User) request.getSession().getAttribute("activeUser");
		String clientSession = activeUser.getsessionid();
		String appId = readProperties.GetPara("client_id");
		
		logger.info("****group_id:"+group_id+"token:"+token+"clientSession:"+clientSession+"appId:"+appId);
		String exitResult = VCloudService.exitGroup(exitGroupUrl, group_id, token, clientSession, appId);
		logger.info("exitResult**************" + exitResult);
		JSONObject exitResultObject = JSON.parseObject(exitResult);
		logger.info("exitresult  error_code********" + exitResultObject.getString("error_code"));
		if ("2000".equals(exitResultObject.getString(""))) {
	   
	    MeetingGroup meetingGroupObject=meetingGroupService.findGroupByCreatorID(activeUser.getId(), meetingGroup.getId());
			
	  if(meetingGroupObject!=null){//判断当前用户是否为会议的创建者  是、删除会议组  否 、退出会议组
			
			// 本地删除group
			meetingGroupService.deleteGroup(meetingGroup.getId());
			logger.info("会议组删除成功！！！");
			}else{
			//退出群组
		    meetingGroupService.quitGroup(meetingGroup.getId(), activeUser.getId());	
		    logger.info("退出会议组成功！！！");
			}		
		}
		return "redirect:/meetingGroupList.do？id="+activeUser.getId();
	}

	/**
	 * 会议组详情
	 * 
	 * @return
	 */
	@RequestMapping("/groupInfo")
	public String groupInfo(String id, Model model) {
	    MeetingGroup meetingGroup = new MeetingGroup();
		meetingGroup.setId("9a5750509fd611e6a5240d90a228d8b2");
		MeetingGroup group = meetingGroupService.findMeetingGroup(meetingGroup.getId());
		List<User> userList = group.getUserList();
		for (User user : userList) {
			logger.info("user***************" + user.getId());
			logger.info("user*************name" + user.getNickname());
		}
		model.addAttribute("group", group);

		return "groupInfo";
	}

	/*@RequestMapping("saveUser")
	public String saveUser() {
		User user = new User();
		user.setId("262626");
		user.setNickname("xiaoxiao");
		user.setsessionid("1151316544");
		userService.saveUser(user);
		return "redirect:/view/success.jsp";
	}

	@RequestMapping("saveGroup")
	public String saveGroup() {
		MeetingGroup group = new MeetingGroup();
		group.setId("123457");
		group.setName("小小牛会议");
		group.setNum("1");
		group.setCreator("262626");
		group.setcreatetime("235621525");
		group.setupdatetime("3265154556");
		group.setConversation("0");
		group.setGroupdesc("");
		meetingGroupService.saveMeetingGroup(group);
		return "redirect:/view/success.jsp";
	}
*/
}
