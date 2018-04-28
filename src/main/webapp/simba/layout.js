var swiper=new Swiper('._g_layout_banner',{
    autoplay:2500,
    loop:true,
    pagination:'.swiper-pagination',
    preventClicksPropagation:false
});

//客户端信息
function agent(){
    var u=navigator.userAgent;
    return {
        trident:	u.indexOf("Trident")>-1,/*IE内核*/
        presto:		u.indexOf("Presto")>-1,/*opera内核*/
        webkit:		u.indexOf("AppleWebKit")>-1,/*苹果、谷歌内核*/
        gecko:		u.indexOf("Gecko")>-1&&u.indexOf("KHTML")==-1, /*火狐内核*/
        mobile:		!!u.match(/AppleWebKit.*Mobile.*/),/*是否为移动终端*/
        ios:		!!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),/*ios终端*/
        android:	u.indexOf("Android")>-1||u.indexOf("Linux")>-1,/*android终端或者uc浏览器*/
        iphone:		u.indexOf("iPhone")>-1,/*是否为iPhone或者QQHD浏览器*/
        ipad:		u.indexOf("iPad")>-1,/*是否iPad*/
        webapp:		u.indexOf("Safari")==-1/*是否web应该程序，没有头部与底部*/
    };
}

if(!agent().iphone && !agent().android){
    alert('请使用移动版客户端打开此页面…');
}

$(function(){
    $(".lineli").on("touchstart",function(){
        if($(this).hasClass('waite'))return;
        $(this).addClass('open');
    });
    $(".lineli").on("touchend",function(){
        if($(this).hasClass('waite'))return;
        $(this).removeClass('open');
    });
});

//打开banner链接
function openBannerUrl(v){
    var url = '',title = '';
    if(v == 1){
        url=getLocalPageUrl('working-space.html');
        title = '互联网+企业工作空间';
    }else if(v == 2){
        url=getLocalPageUrl('sib+.html');
        title = 'APP工厂';
    }
    openUrl(url,title);
}

//通知公告
try{
    document.getElementById('app01').onclick=function(){
        openNotice();
    }
}catch(e){}

//任务管理
try{
    document.getElementById('app02').onclick=function(){
        var urltype='mb_task_url';
        openUrlByKey(urltype,'任务管理');
    }
}catch(e){}

//工作流
try{
    document.getElementById('app03').onclick=function(){
        var urltype='mb_workflow_url';
        openUrlByKey(urltype,'工作流');
    }
}catch(e){}

//工作日志
try{
    document.getElementById('app04').onclick=function(){
        var urltype='mb_work_diary_url';
        openUrlByKey(urltype,'工作日志');
    }
}catch(e){}

//日程安排
try{
    document.getElementById('app05').onclick=function(){
        var urltype='mb_schedule_url';
        openUrlByKey(urltype,'日程安排');
    }
}catch(e){}

//我的文件
try{
    document.getElementById('app07').onclick=function(){
        openMyFiles();
    }
}catch(e){}

//全球呼叫
try{
    document.getElementById('app08').onclick=function(){
        
        openCallPhone();
    }
}catch(e){}

//电话会议
try{
    document.getElementById('app09').onclick=function(){
        openTeleconference();
    }
}catch(e){}

//会议记录
try{
    document.getElementById('app11').onclick=function(){
        openTeleHistory();
    }
}catch(e){}

//考勤
try{
    document.getElementById('app13').onclick=function(){
        var urltype='mb_checkin_url';
        openUrlByKey(urltype,'考勤');
    }
}catch(e){}

//问题反馈
try{
    document.getElementById('app10').onclick=function(){
        var urltype='mb_bug_feedback_url';
        openUrlByKey(urltype,'问题反馈');
    }
}catch(e){}

//sib+
try{
    document.getElementById('app12').onclick=function(){
        var url=getLocalPageUrl('sib+.html');
        var title = 'APP工厂';
        openUrl(url,title);
    }
}catch(e){}

var locks = document.getElementsByClassName('lock');
if(locks && locks.length>0){
    for(var i=0;i<locks.length;i++){
        locks[i].onclick=function(){
            creatAsidTip("您需要创建或加入一个组织后，才能使用该功能。");
        }
    }
}