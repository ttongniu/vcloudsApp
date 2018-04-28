/**
 * 控制器-执行页面事件的响应
 */
$(document).on('click','#simbaAdd>section.share',function(){
    var eventSource = event.srcElement || event.target;//事件源
    if($(eventSource).parents('footer').length==0){
        shareMoving('hide');
    }
});