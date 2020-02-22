//导航选择器
var url = window.location.href;
if (url.indexOf("smsSend") > 0) {
	$("#sms").addClass("active");
	$("#smsSend").addClass("active");
} else if (url.indexOf("smsStatus") > 0 ) {
	$("#sms").addClass("active");
	$("#smsStatus").addClass("active");
} else if (url.indexOf("smsReply")>0){
	$("#sms").addClass("active");
	$("#smsReply").addClass("active");
} else if (url.indexOf("userManage")>0){
    $("#user").addClass("active");
	$("#userManage").addClass("active");
} else if (url.indexOf("tunnelManage")>0){
	$("#tunnel").addClass("active");
	$("#tunnelManage").addClass("active");
} else if (url.indexOf("groupManage")>0){
	$("#address").addClass("active");
	$("#addressManage").addClass("active");
}



// 提示条配置
toastr.options = {
	"closeButton" : true,
	"debug" : false,
	"progressBar" : true,
	"preventDuplicates" : false,
	"positionClass" : "toast-top-right",
	"onclick" : null,
	"showDuration" : "400",
	"hideDuration" : "1000",
	"timeOut" : "7000",
	"extendedTimeOut" : "1000",
	"showEasing" : "swing",
	"hideEasing" : "linear",
	"showMethod" : "fadeIn",
	"hideMethod" : "fadeOut"
}