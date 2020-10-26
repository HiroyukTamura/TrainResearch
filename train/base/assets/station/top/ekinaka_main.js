//screen.widthで取得される値は
//iPhoneの場合、Androidの半分
function setViewport() {
	var content = "";
	var userAgent = navigator.userAgent;
	if (userAgent.indexOf('Android') > 0) {
		var width = screen.width;
		if (userAgent.indexOf('Android 2.3') > 0) {
			width = window.outerWidth;
		}
		if (width < 640) {
			content = 'target-densitydpi=device-dpi,width=' + width + ', initial-scale=0.5,minimum-scale=0.5,maximum-scale=0.5,user-scalable=no';
		} else {
			content = 'target-densitydpi=device-dpi,width=640, initial-scale=0.5,minimum-scale=0.5,maximum-scale=0.5,user-scalable=no';
		}
	} else {
		content = 'target-densitydpi=device-dpi,width=640, initial-scale=0.5,minimum-scale=0.5,maximum-scale=0.5,user-scalable=no';
	}

	var meta = document.createElement('meta');
	meta.setAttribute('name', 'viewport');
	meta.setAttribute('content', content);
	document.getElementsByTagName('head')[0].appendChild(meta);
}

//工事のお知らせ詳細画面
function setViewportUserScalableOn() {
	var width = screen.width;
	var content = "";
	if (navigator.userAgent.indexOf('Android') > 0 && width < 640) {
		content = 'target-densitydpi=device-dpi,width=' + width + ', initial-scale=0.5,minimum-scale=0.5,maximum-scale=2.5,user-scalable=yes';
	} else {
		content = 'target-densitydpi=device-dpi,width=640, initial-scale=0.5,minimum-scale=0.5,maximum-scale=2.5,user-scalable=yes';
	}

	var meta = document.createElement('meta');
	meta.setAttribute('name', 'viewport');
	meta.setAttribute('content', content);
	document.getElementsByTagName('head')[0].appendChild(meta);
}

//天気簡易、天気簡易メンテナンス画面
function setViewportWeatherSimple() {
	
	var content = "";
	if (navigator.userAgent.indexOf('Android') > 0 ) {
		var width = screen.width / 2;
		if (navigator.userAgent.indexOf('Android 2.3') > 0) {
			width = window.outerWidth / 2;
		}
		
		if (width <= 240) {
			content = 'target-densitydpi=device-dpi,width=240,height=285,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no';
		} else if (240 < width && width <= 270) {
			content = 'target-densitydpi=device-dpi,width=270,height=320,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no';
		} else {
			content = 'target-densitydpi=device-dpi,width=320,height=380,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no';
		}
	} else {
		content = 'target-densitydpi=device-dpi,width=320,height=380,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no';
	}

	var meta = document.createElement('meta');
	meta.setAttribute('name', 'viewport');
	meta.setAttribute('content', content);
	document.getElementsByTagName('head')[0].appendChild(meta);
}

//路線一覧画面
function setViewportRailslist(){
	content = 'target-densitydpi=medium-dpi,width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no';
	var meta = document.createElement('meta');
	meta.setAttribute('name', 'viewport');
	meta.setAttribute('content', content);
	document.getElementsByTagName('head')[0].appendChild(meta);
	
	var headelem = document.getElementsByClassName("raillist_head")[0];
	var mainelem = document.getElementsByClassName("raillist_main")[0];
	mainelem.style.paddingTop = headelem.offsetHeight + "px";
}