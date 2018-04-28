var VCloudClient={
  getInstance:function(){//获取实例
    var url1="v5cloud://launchplatform/?appkey={0}&userid={1}&session={2}&action={3}";
    var url2="intent://launchplatform/#Intent;scheme=v5cloud;package=me.chatgame.generic;S.appkey={0};S.userid={1};S.session={2};S.action={3};";
    var notSurpport=["weibo","micromessager","baidubrowser","huohoubrowser","crosswalk"];//变量（不支持）
    var supportTypeIntent=[""];
    String.format = function() {
        if( arguments.length == 0 )
            return null;
 //arguments对象是比较特别的一个对象，实际上是当前函数的一个内置属性。arguments非常类似Array，但实际上又不是一个Array实例。
        var str = arguments[0];   
        for(var i=1;i<arguments.length;i++) {
            var re = new RegExp('\\{' + (i-1) + '\\}','gm');
            str = str.replace(re, arguments[i]);
        }
        return str;
    }
    //得到用户代理人
    // Navigator 对象包含有关浏览器的信息，返回由客户机发送服务器的 user-agent 头部的值。
    function getUserAgent(){
      return navigator.userAgent.toLowerCase();
    }
    //得到支持设备（Android、iPhone、iPad）
    function getSupport(){
      var userAgent=getUserAgent();
      if(userAgent.indexOf("android")<0 && userAgent.indexOf("iphone")<0 && userAgent.indexOf("ipad")<0){
        return -1;
      }
      if(userAgent.indexOf("ios")>0){
        return 0;
      }
      for(var i=0;i<notSurpport.length;i++){
          if(userAgent.indexOf(notSurpport[i])>0){
            return -1;
          }
      }
      for(var i=0;i<supportTypeIntent.length;i++){
          if(userAgent.indexOf(supportTypeIntent[i])>0){
            return 1;
          }
      }
      return 0;
    }
    //作用？？     生成URL路径
    function getUrl1(appId,userId,sessionId,action,args){
      var ret= String.format(url1,appId,userId,sessionId,action);
      for(var i=0;i<args.length;i++){
        var arg=args[i];
        ret+=String.format("&{0}={1}",arg.name,encodeURI(arg.value));
      }
      return ret;
    }
    //作用？？     生成URL路径
    function getUrl2(appId,userId,sessionId,action,args){
      var ret= String.format(url2,appId,userId,sessionId,action);
      for(var i=0;i<args.length;i++){
        var arg=args[i];
        ret+=String.format("S.{0}={1};",arg.name,arg.value);
      }
      return ret+"end;";
    }
    //跳转到URL中
    function gotoUrl(appId,userId,sessionId,action,args){
      var supportType=getSupport();
      var url="";
      switch(supportType){
        case -1:
          break;
        case 0:
          url=getUrl1(appId,userId,sessionId,action,args);
          break;
        case 1:
          url=getUrl2(appId,userId,sessionId,action,args);
          break;
        default:
          break;
      }
      if(url==""){
        return false;
      }else{
       /* window.location.href=url;
       */
    	 // alert("*********"+url);
    	uc.openApp("me.chatgame.generic","me.chatgame.generic.SplashActivity",url,"");
        return true;
      }
    }
    //传入相应的参数      通过方法跳转到云端的相关的url中
    var vcloudClient={};
    vcloudClient.userLogin=
    function userLogin(appId,userId,sessionId){
      return gotoUrl(appId,userId,sessionId,"login",[]);
    };
    vcloudClient.callUser=
    function callUser(appId,userId,sessionId,targetUserId){
      return gotoUrl(appId,userId,sessionId,"call",[{name:"peer_userid",value:targetUserId}]);
    };
    vcloudClient.enterUserChat=
    function enterUserChat(appId,userId,sessionId,targetUserId){
      return gotoUrl(appId,userId,sessionId,"single_chat",[{name:"peer_userid",value:targetUserId}]);
    };
    vcloudClient.enterGroupChat=
    function enterGroupChat(appId,userId,sessionId,targetGroupId){
    	//alert("进入方法！！！");
      return gotoUrl(appId,userId,sessionId,"group_chat",[{name:"groupid",value:targetGroupId}]);
    };
    vcloudClient.startLive=
    function startLive(appId,userId,sessionId,roomId){
      return gotoUrl(appId,userId,sessionId,"start_live",[{name:"roomid",value:roomId}]);
    };
    vcloudClient.watchLive=
    function watchLive(appId,userId,sessionId,roomId){
      return gotoUrl(appId,userId,sessionId,"watch_live",[{name:"roomid",value:roomId}]);
    };
    return vcloudClient;
  }
};