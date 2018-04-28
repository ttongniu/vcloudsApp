/*-----------------------------------------------【扩展】-----------------------------------------------*/
/*屏蔽脚本错误*/
window.onerror = function () {return true;};
/*去除左右空格*/
String.prototype.trim = function(){return this.replace(/(^\s*)|(\s*$)/g, "");}
/*中文转码*/
String.prototype.encodeChinese = function(){if(this) return encodeURIComponent(encodeURIComponent(this));else return "";}
/*中文解码*/
String.prototype.decodeChinese = function(){if(this) return decodeURIComponent(decodeURIComponent(this));else return "";}
/*截取指定字节长度的字符串*/
String.prototype.cutLength = function(length){
    var result = '',strlen = this.length, // 字符串长度
        chrlen = this.replace(/[^\x00-\xff]/g,'**').length; // 字节长度
    if(chrlen<=length){return this;}
    for(var i=0,j=0;i<strlen;i++){
        var chr = this.charAt(i);
        if(/[\x00-\xff]/.test(chr)){
            j++; // ascii码为0-255，一个字符就是一个字节的长度
        }else{
            j+=2; // ascii码为0-255以外，一个字符就是两个字节的长度
        }
        if(j<=length){ // 当加上当前字符以后，如果总字节长度小于等于length，则将当前字符真实的+在result后
            result += chr;
        }else{ // 反之则说明result已经是不拆分字符的情况下最接近length的值了，直接返回
            return result;
        }
    }
}
/*日期转为字符串*/
Date.prototype.format = function(fmt) {
    var o = {
        "M+" : this.getMonth()+1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "\u65e5",
        "1" : "\u4e00",
        "2" : "\u4e8c",
        "3" : "\u4e09",
        "4" : "\u56db",
        "5" : "\u4e94",
        "6" : "\u516d"
    };
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}


/*-----------------------------------------------【函数】-----------------------------------------------*/
/*清除HTML5中的本地缓存和session缓存*/
function clearStorage(){
    sessionStorage.clear();//清除所有
    localStorage.clear();//清除所有
}

/*时间对象转换成字符串【11月14日 11:22】或者【今天 11:22】或者【明天 11:22】或者【昨天 11:22】或者【前天 11:22】*/
function dateToString(timeLong){
    if(!timeLong)return;
    var onDayLong = 24*60*60*1000;
    var date = new Date(timeLong);
    var today = new Date();
    if(today.getFullYear()==date.getFullYear() && today.getMonth() == date.getMonth() && today.getDate() == date.getDate()){
        //今天
        return date.format("HH:mm");
    }else if(today.getFullYear()==date.getFullYear() && today.getMonth() == date.getMonth() && (today.getDate() + 1) == date.getDate()){
        //明天
        return "明天 " + date.format("HH:mm");
    }else if(today.getFullYear()==date.getFullYear() && today.getMonth() == date.getMonth() && (today.getDate() - 1) == date.getDate()){
        //昨天
        return "昨天 " + date.format("HH:mm");
    }else if(today.getFullYear()==date.getFullYear() && today.getMonth() == date.getMonth() && (today.getDate() - 2) == date.getDate()){
        //前天
        return "前天 " + date.format("HH:mm");
    }else if(today.getFullYear()==date.getFullYear()){
        //今年
        return date.format("MM-dd HH:mm");
    }
    return date.format("yyyy-MM-dd HH:mm");
}

/*根据文件名称，返回后缀，不识别的后缀返回other*/
function getFileSuffix(fileName){
    if(!fileName)return;
    var suffixes = ["doc","docx","ppt","pptx","png","jpg","jpeg","gif","txt","rar","zip"];
    var suffix = fileName.split(".")[fileName.split(".").length-1];
    suffix = suffix.toLowerCase();
    var a = suffixes.indexOf(suffix);
    if(a>=0) return suffix;
    else return "other";
}

/*获取地址栏参数*/
function getUrlParamt(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

/*去除html标签*/
function removeHTMLTag(str) {
    str = str.replace(/<\/?[^>]*>/g, ''); //去除HTML tag
    str = str.replace(/[ | ]*\n/g, ''); //去除行尾空白
    str = str.replace(/&nbsp;/ig, ''); //去掉尾部空格
    return str;
}

/*获取图片相对于外层元素的宽高*/
function countWidthHeightForDialog(sourceWidth,sourceHeight,dialogWidth,dialogHeight){
    if(sourceWidth <= dialogWidth && sourceHeight <= dialogHeight)
        return {"width":sourceWidth,"height":sourceHeight};
    var newWidth=3000,newHeight= 0;
    while(newWidth > dialogWidth || newHeight > dialogHeight){
        if(sourceWidth > dialogWidth){
            newWidth = dialogWidth;
            newHeight = sourceHeight/sourceWidth * newWidth;
        }else if(sourceHeight > dialogHeight){
            newHeight = dialogHeight;
            newWidth = sourceWidth/sourceHeight * newHeight;
        }
        sourceWidth = newWidth,sourceHeight = newHeight;
    }
    return {"width":parseInt(newWidth),"height":parseInt(newHeight)};
}

/*设置img的原始图片宽高
 * targ:img 元素节点*/
function setImgAttr(targ){
    var img = new Image();
    img.src = targ.attr("src");
    img.onload = function(){
        // 打印
        targ.attr("data-swidth",img.width);
        targ.attr("data-sheight",img.height);
    };
}

/* 容量单位转换
 * size:容量大小
 * initUnit:初始单位
 * decimals:保留小数点位数
 * targetUnit:转换后的单位*/
function parseFileSize(size, initUnit, decimals, targetUnit) {
    size = parseInt(size);
    var units = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB'];
    var initUnitIndex = units.indexOf(initUnit);
    while(size>=1024){
        size = size / 1024;
        ++initUnitIndex;
        if(units[initUnitIndex]==targetUnit)break;
    }
    return (size.toFixed(decimals)+" "+units[initUnitIndex]);
}

/*获取浏览器版本*/
function browerVersion(){
    var u = navigator.userAgent,app = navigator.appVersion;
    return {
        trident : u.indexOf('Trident') > -1, //IE内核
        presto : u.indexOf('Presto') > -1,//opera内核
        webKit : u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
        gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
        mobile : !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/),//是否为移动终端
        ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
        android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
        iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
        iPad : u.indexOf('iPad') > -1, //是否iPad
        webApp : u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
        linux : u.indexOf('linux') > -1, //加mobile和这个属性一起，可以判断uc浏览器
        wp7 : (u.indexOf('WP7') > -1) || (u.indexOf('Windows Phone OS') > -1)//trident IE内核 并且包含WP7标示 windows phone7手机
    };
}

/*随机获取颜色*/
function getRandomColor(){
    return  '#' +
        (function(color){
            return (color +=  '0123456789abcdef'[Math.floor(Math.random()*15)])
                && (color.length == 6) ?  color : arguments.callee(color);
        })('');
}

/*字符串 过滤小括号，中文括号、数字、下划线、减号、小数点号，并截取倒数2位*/
function cutName(name){
    name = name.replace(/[\d()（）._-]*/ig,'');
    return (name.substr(name.length - 2 , 2));
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