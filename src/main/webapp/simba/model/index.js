/**
 * 模型层-处理业务逻辑，请求数据、处理返回数据
 */
//调用IOS客户端提供的接口需要定义如下函数
function connectWebViewJavascriptBridge(callback){
    if(window.WebViewJavascriptBridge) {
        callback(WebViewJavascriptBridge);
    }else{
        document.addEventListener('WebViewJavascriptBridgeReady',function(){
            callback(WebViewJavascriptBridge);
        },false);
    }
}

//执行connectWebViewJavascriptBridge函数，并注入需要回调的方法
connectWebViewJavascriptBridge(function(bridge){
    bridge.init(function(message,responseCallback) {
        var data={'Javascript Responds':'Wee!'};
        responseCallback(data);
    });
    //注入返回按钮事件 ，enableGoBack=0的时候生效
    bridge.registerHandler('onBnClickedReturn', function(data, responseCallback) {
        onBnClickedReturn();
    });
    //注入右测按钮事件
    bridge.registerHandler('onBnClickedMore', function(data, responseCallback) {
        onBnClickedMore();
    });
    //注入人员选择器回调方法
    bridge.registerHandler('selectSimbaMemberResult', function(data, responseCallback) {
        var temp = JSON.parse(data);
        var data = temp.selectMembers;
        selectSimbaMemberResult(JSON.stringify(data),temp.requstCode);
    });
});



function openNotice(){
    try{
        uc.openNotices();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showProclaim', '', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openTask(){
    var urltype = 'mb_task_url';
    try{
        uc.loadUrlByKey(urltype);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('getUrlByKey',{'key':urltype},function(data){
                window.WebViewJavascriptBridge.callHandler('openURL',{'URL':data,'title':'任务管理'},'');
            });
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openLog(){
    var urltype = 'mb_work_diary_url';
    try{
        uc.loadUrlByKey(urltype);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('getUrlByKey',{'key':urltype},function(data){
                window.WebViewJavascriptBridge.callHandler('openURL',{'URL':data,'title':'工作日志'},'');
            });
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openSchedule(){
    var urltype = 'mb_schedule_url';
    try{
        uc.loadUrlByKey(urltype);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('getUrlByKey',{'key':urltype},function(data){
                window.WebViewJavascriptBridge.callHandler('openURL',{'URL':data,'title':'日程安排'},'');
            });
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openWorkFlow(){
    var urltype = 'mb_workflow_url';
    try{
        uc.loadUrlByKey(urltype);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('getUrlByKey',{'key':urltype},function(data){
                window.WebViewJavascriptBridge.callHandler('openURL',{'URL':data,'title':'工作流'},'');
            });
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openShareSpace(){
    try{
        uc.openAllShareSpace();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showShareSpaceView', '','');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openFileRecord(){
    try{
        uc.openMyFiles();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showOfflineFilesView', '', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openQuestionFeedback(){
    var urltype = 'mb_bug_feedback_url';
    try{
        uc.loadUrlByKey(urltype);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('getUrlByKey',{'key':urltype},function(data){
                window.WebViewJavascriptBridge.callHandler('openURL',{'URL':data,'title':'问题反馈'},'');
            });
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openGlobalCall(){
    try{
        uc.openCallPhone();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showTelephoneView','', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openTelconference(){
    var human = '';//初始化电话会议的参会人员
    //human = [{"name":"lilei","number":"66061063"},{"name":"zhangsan","number":"135xxxxxxxx"}];
    try{
        uc.openTeleconference(human);//human参数可不传
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showTeleconferenceView', '', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openMeetingRecord(){
    try{
        uc.openTmHistory();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('showHistoryConfView', '', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openSimbaPoint(){
    var url = getLocalPageUrl('sib+.html');
    var title = 'Simba+';
    try{
        uc.loadUrl(url);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('openURL', {'URL': url, 'title':title}, '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openMobileInterface(){
    var url = 'http://clientweb.isimba.cn/mobileInterface/index.html';//新窗口中指向的URL地址
    var title = '开发者';
    try{
        uc.loadUrl(url);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('openURL', {'URL': url, 'title':title}, '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function chatWithUser(sibid){
    var b = window.location.protocol;
    var c = window.location.host;
    var e = window.location.pathname;
    var url = b + '//' + c + e;//新窗口中指向的URL地址
    var content = 'SIMBA+分享：' + url;//自定义聊天输入窗口内容
    if(!sibid){
        sibid = '66232657';//客服号码
        content = '';
    }
    try{
        uc.openChatByUser(sibid,content);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('chatWithUserId', {'userId':sibid,'content':content},'')
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function setNavigationBar(){
    var title = 'SIMBA+';//导航栏标题
    var color = '';//导航栏背景色r,g,b格式，例如 color = '255,255,255';
    var rightButton = '分享';//右边按钮名称
    var showClose = '0';//0：不显示返回按钮旁的关闭按钮，1：显示关闭按钮
    var enableGoBack = '0';//0 ：表示由网页来控制返回按钮的点击事件，1：表示客户端放弃控制导航栏返回按钮点击事件
    var paramt = {'title': title, 'color': color, 'rightTitle':rightButton, 'showClose':showClose,'enableGoBack':enableGoBack};
    try{
        uc.setNavigationBarInfo(JSON.stringify(paramt));
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('setNavigationBarInfo',paramt ,'');
        }catch(e){
            //alert('您调用的接口不存在');
        }
    }
}

//自定义返回按钮事件，enableGoBack=0的时候生效
function onBnClickedReturn(){
    dismissWebView();//关闭当前窗口
}

//自定义导航栏右测按钮事件
function onBnClickedMore(){
    //alert('点击了右测按钮');
    shareMoving();
}

function dismissWebView(){
    try{
        uc.closeActivity();
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('dismissWebView', '', '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function shareMoving(type){
    if(type=='show'){
        $('#simbaAdd>section.share').addClass('share-move');
    }else if(type=='hide'){
        $('#simbaAdd>section.share').removeClass('share-move');
    }else{
        $('#simbaAdd>section.share').toggleClass('share-move');
    }
}

function selectPeople(){
    var requstCode = 1;//自定义参数，只能是数字，将在回调函数中返回
    var existUserIds = '';//已存在的人员账号
    try{
        uc.selectSimbaMember(existUserIds,requstCode);
    }catch(e){
        var existUserIds = '';//已存在的人员账号，多个用英文逗号隔开
        var requstCode = 1;//自定义参数，只能是数字，将在回调函数中返回
        window.WebViewJavascriptBridge.callHandler('selectSimbaMember', {'existUserIds': existUserIds, 'requstCode':requstCode+''},'');
    }
}

function selectSimbaMemberResult(jsondata,requstCode){
    //返回的jsondata是一个json字符串，可以使用JSON.parse()转换成JSON对象
    var data = JSON.parse(jsondata);
    if(data.length==0)return;
    var sibidArray = [];
    for(var i=0;i<data.length;i++){
        sibidArray[sibidArray.length] = data[i].accNbr;
        //alert(data[i].accNbr + ":" + data[i].name);
    }
    if(sibidArray.length==1){
        chatWithUser(sibidArray[0]);
    }else{
        createDiscussion(sibidArray);
    }
}

/*simbaidArray = ['66061063','66061062'];//讨论组成员账号*/
function createDiscussion(sibidArray){
    var b = window.location.protocol;
    var c = window.location.host;
    var e = window.location.pathname;
    var url = b + '//' + c + e;//新窗口中指向的URL地址
    var title = 'SIMBA+分享';//讨论组标题
    var content = 'SIMBA+分享：' + url;//自定义聊天输入窗口内容
    try{
        uc.createDiscussion(sibidArray,title,content);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('createDiscussion', {'simbaIDs': sibidArray, 'title': title, 'content': content},'');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openCustom(){
    var url = 'http://client.dingdingpro.com/mapi/';//新窗口中指向的URL地址
    var title = '应用定制';
    try{
        uc.loadUrl(url);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('openURL', {'URL': url, 'title':title}, '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

function openWorkSpace(){
    var url = getLocalPageUrl('working-space.html');
    var title = '互联网+企业工作空间';
    try{
        uc.loadUrl(url);
    }catch(e){
        try{
            window.WebViewJavascriptBridge.callHandler('openURL', {'URL': url, 'title':title}, '');
        }catch(e){
            alert('您调用的接口不存在');
        }
    }
}

/*获取当前项目下的指定页面地址*/
function getLocalPageUrl(pageName){
    if(!pageName)return '';
    var url = '';
    var protocol = window.location.protocol + '//';
    var pathname = window.location.pathname;
    pathname = pathname.substr(0,pathname.lastIndexOf('/') + 1);
    pathname += pageName;
    url = protocol + window.location.host + pathname + window.location.search;
    return url;
}