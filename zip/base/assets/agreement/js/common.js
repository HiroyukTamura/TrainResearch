function area(areaId) {
	$("#kanto").css("display", "none");
	$("#shinetsu").css("display", "none");
	$("#tohoku").css("display", "none");
	$("#shinkansen").css("display", "none");
	$("#private_railway").css("display", "none");
	switch (areaId) {
		case "tab1":
			$("#tohoku").css("display", "block");
			break;
		case "tab2":
			$("#kanto").css("display", "block");
			break;
		case "tab3":
			$("#shinetsu").css("display", "block");
			break;
		case "tab4":
			$("#shinkansen").css("display", "block");
			break;
		case "tab5":
			$("#private_railway").css("display", "block");
			break;
		default:
			$("#kanto").css("display", "block");
	}
}

function xua_unique(orgArray) {
	var storage = {};
	var uniqueArray = [];
	var i, value;

	for (i = 0; i < orgArray.length; i++) {
		value = orgArray[i];
		if (!(value in storage)) {
			storage[value] = true;
			uniqueArray.push(value);
		}
	}
	return uniqueArray;
}

function goNext(cls, _url) {
	id = $(this).attr("id");
	var agent = navigator.userAgent;
	if (agent.search(/Mac OS/) != -1) {
		document.location = "iphone://get" + cls + "?url=" + _url;
	} else if (agent.search(/Android/) != -1) {
		strngCall = "return android.go" + cls + "('" + _url + "')";
		f = new Function(strngCall);
		f();
	} else {
		document.location = _url;
	}
}

function tap(tag) {
	$(tag).toggleClass('sel');
	setTimeout(function () {
		$(tag).toggleClass('sel');
	}, 200);
}

function rmStrs(strs, key) {
	strs = strs.replace(key, "");
	strs = strs.replace(",,", ",");
	if (strs.lastIndexOf(",") == strs.length - 1) {
		strs = strs.substr(0, strs.length - 1);
	} else if (strs.indexOf(",") == 0) {
		strs = strs.substr(1, strs.length);
	}
	return strs;
}

function setBgColor(uid, bg) {
	if (uid.val() != null && uid.val() != "") {
		bg.css('background-color', '#e6e6e6');
	} else {
		bg.css('background-color', '#46c878');
	}
}

function touchstartEvnt(tag) {
	(tag).attr("moved", "no");
	(tag).toggleClass("sel");
}

function touchmoveEvnt(tag) {
	(tag).attr("moved", "yes");
	(tag).removeClass("sel");
}

function touchendEvnt(tag) {
	(tag).removeClass("sel");
	return (tag).attr("moved");
}

function getHeaderParam() {
	text = '{"at_train":' + $("#at_train").val() + ',"self_id":' + $("#self_id").val() + ',"dest_code":' + $("#dest_code").val() + ',"station_now":"' + $("#stationCd").val() + '","station_next":"' + $("#stationCdNext").val() + '","train_status":' + $("#train_status").val() + '}';
	return text;
}


var jsonData;
var executeType;

function setJsonData(data, type) {
	if (type == "3" || type == "4") {
		setTimeout(function () {
			callImage(data, type)
		}, 50);
	} else {
		callImage(data, type)
	}
}

function callImage(data, type) {
	jsonData = data;
	executeType = type;
	var agent = navigator.userAgent;
	if (agent.search(/Mac OS/) != -1) {
		document.location = "iphone://createImage";
	} else if (agent.search(/Android/) != -1) {
		android.createImage();
	}
}


function setImage(value) {
	var key = CryptoJS.enc.Base64.parse(value);
	var train = jsonData.jsonString;
	var datas = train.split(":");

	var iv_b64 = datas[0];
	var encrypted_b64 = datas[1];

	var iv = CryptoJS.enc.Base64.parse(iv_b64);
	var encrypted_data = CryptoJS.enc.Base64.parse(encrypted_b64);

	var encrypted = {
		iv: iv,
		ciphertext: encrypted_data
	};
	var decryptData = CryptoJS.AES.decrypt(encrypted, key, {
		mode: CryptoJS.mode.CBC,
		padding: CryptoJS.pad.Pkcs7,
		iv: iv
	});

	var txt_dexrypted = decryptData.toString(CryptoJS.enc.Utf8);
	var jsonObj = JSON.parse(txt_dexrypted);
	nextMethod(jsonObj);
}


function nextMethod(jsonObj) {
	if (executeType == "1") {
		displayArrow(jsonObj);
	} else if (executeType == "2") {
		updateDisplay(jsonObj);
	} else if (executeType == "3") {
		setLoopData(jsonObj);
	} else if (executeType == "4") {
		setLoopCommonData(jsonObj);
	}
}
