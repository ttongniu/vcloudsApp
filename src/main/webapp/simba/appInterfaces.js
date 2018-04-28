$(document).ready(function () {
    AJAX_URL = '/appcenterapi/';
    checkMainfest();
    load();
});

window.onload = function () {
    winLoaded();
}

/**
 * IOS全局接口注入
 */
function connectWebViewJavascriptBridge(callback) {
    if (window.WebViewJavascriptBridge) {
        callback(WebViewJavascriptBridge);
    } else {
        document.addEventListener('WebViewJavascriptBridgeReady', function () {
            callback(WebViewJavascriptBridge);
        }, false);
    }
};

/**
 * 新窗口打开
 */
function openUrl(url, title) {
    if (!url || !title)return;
    try {
        uc.loadUrl(url);
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('openURL', {'URL': url, 'title': title}, '');
    }
}

/**
 * 通过服务端key,打开链接
 */
function openUrlByKey(urltype, title) {
    if (!urltype)return;
    try {
        uc.loadUrlByKey(urltype);
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('getUrlByKey', {'key': urltype}, function (data) {
            window.WebViewJavascriptBridge.callHandler('openURL', {'URL': data, 'title': title}, '');
        });
    }
}

/**
 * 打开通知公告
 */
function openNotice() {
    try {
        uc.openNotices();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('showProclaim', '', '');
    }
}

/**
 * 打开我的文件
 */
function openMyFiles() {
    try {
        uc.openMyFiles();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('showOfflineFilesView', '', '');
    }
}

/**
 * 打开全球呼叫
 */
function openCallPhone() {
    try {
        uc.openCallPhone();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('showTelephoneView', '', '');
    }
}

/**
 * 打开电话会议
 */
function openTeleconference() {
    try {
        uc.openTeleconference();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('showTeleconferenceView', '', '');
    }
}

/**
 * 打开会议记录
 */
function openTeleHistory() {
    try {
        uc.openTmHistory();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('showHistoryConfView', '', '');
    }
}

/**
 * 关闭当前窗口
 */
function closeWin() {
    try {
        uc.closeActivity();
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('dismissWebView', '', '');
    }
}

/**
 * 定制导航条
 */
function setNavBar() {
    //var obj = {'title':'','color':'','rightTitle':'','showClose':'','enableGoBack':''}
    var obj = {'enableGoBack': '0'};
    try {
        uc.setNavigationBarInfo(JSON.stringify(obj));
    } catch (e) {
        window.WebViewJavascriptBridge.callHandler('setNavigationBarInfo', obj, '');
        window.WebViewJavascriptBridge.registerHandler('onBnClickedReturn', function (data, responseCallback) {
            closeWin();
        });
    }
}

/**
 * 自定义返回按钮操作
 */
function onBnClickedReturn() {
    closeWin();
}

/**
 * 获取手机应用中心当前选择的企业
 */
function getCurrentEnter() {
    var enterInfo = '';
    try {
        enterInfo = uc.getCurrentEnterId();
        enterInfo = JSON.parse(enterInfo);
        getCustomPage(enterInfo.enterId, enterInfo.sid);
    } catch (e) {
        try {
            window.WebViewJavascriptBridge.callHandler('getCurrentEnterId', '', function (data) {
                enterInfo = data;
                enterInfo = JSON.parse(enterInfo);
                getCustomPage(enterInfo.enterId, enterInfo.sid);
            });
        } catch (e) {
            load(100);
            alert('请使用手机客户端进行访问！');
        }
    }
}

/**
 * 获取定制的应用界面
 */
function getCustomPage(enterId, sid) {
    if (!enterId || !sid) {
        console.error('enterId或sid不能为空');
        load(100);
        return;
    }
    var urltype = 'mb_application_url';
    $.ajax({
        cache: false,
        url: AJAX_URL + 'apply/querys.html',
        data: {'urltype': urltype, 'enterId': enterId, 'sid': sid},
        timeout: 3000,
        type: 'GET',
        dataType: 'json',
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            load(100);
            console.error('链接超时！');
        },
        beforeSend: function (XMLHttpRequest) {
            load();
        },
        success: function (data) {
            if (data.msgCode == 200) {
                loadPage(data.result);
            } else {
                load(100);
                console.error(data.msgCode + '：' + data.msgDesc);
            }
        }
    });
}

/**
 * 加载页面url地址
 */
function loadPage_bf(url) {
    if (!url) {
        console.error('loadPage url not found!');
        return;
    }
    var currentPageUrl = window.location.href + '';
    if (currentPageUrl.indexOf(url) >= 0) {
        load(100);
        return;
    }
    window.location.href = url;
}
function loadPage(url) {
    load(100);
    if (!url) {
        console.error('loadPage url not found!');
        return;
    }
    var currentPageUrl = window.location.href + '';
    if (currentPageUrl.indexOf(url) >= 0) {
        return;
    }
    window.location.href = url;
}

/**
 * 监控mainfest缓存
 */
function checkMainfest() {
    /*code2，缓存公用方法*/
    var EventUtil = {
        addHandler: function (element, type, handler) {
            if (element.addEventListener) {
                element.addEventListener(type, handler, false);
            } else if (element.attachEvent) {
                element.attachEvent("on" + type, handler);
            } else {
                element["on" + type] = handler;
            }
        }
    };
    EventUtil.addHandler(applicationCache, "updateready", function () {
        //缓存更新并已下载，要在下次进入页面生效
        applicationCache.update();//检查缓存manifest文件是否更新，ps:页面加载默认检查一次。
        applicationCache.swapCache();//交换到新的缓存项中，交换了要下次进入页面才生效
        location.reload();              //重新载入页面
    });
}

/**
 * 构造加载动画
 */
function load(type) {
    if (type == 'delete') {
        $('.loading').remove();
        return;
    }
    if (type) {
        setLoadWidth(type);
        return;
    }
    var html = '<div class="loading" style="position: absolute;top: 0;left: 0;width: 0.5%;height: 3px;background-color: #00bf12;z-index: 1;transition: width  .05s;-moz-transition: width .05s;-webkit-transition: width .05s;-o-transition: width .05s;"></div>';
    $('body').append(html);
    var random = Math.floor(Math.random() * (50 - 0 + 1)) + 0;
    setLoadWidth(random);
    //setTimeout(function(){setLoadWidth(random);},10);

    function setLoadWidth(width) {
        var _width = $('.loading').attr('data-width');
        if (!_width)_width = 0;
        var time = (Math.abs(width - _width)) / 100;
        $('.loading').css({"width": width + "%", "transition-duration": time + "s", "-moz-transition-duration": time + "s", "-webkit-transition-duration": time + "s", "-o-transition-duration": time + "s"});
        $('.loading').attr('data-width', width);
        if (width == 100) {
            setTimeout(function () {
                load('delete');
            }, time * 1000);
        }
    }
}

/**
 * 页面资源加载完成后
 */
function winLoaded() {
    load(100);
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