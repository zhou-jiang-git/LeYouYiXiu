//图片显示
var arr = new Array();
for (var i = 0; i < 3; i++) {
	arr[i] = new Array();
}

// 图片 base64 url 转 blob
function dataURLtoBlob(dataurl) {
	var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
		bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
	while (n--) {
		u8arr[n] = bstr.charCodeAt(n);
	}
	return new Blob([u8arr], {type: mime});
}



//图片显示
function showPics(url,name,i){
	//根据路径读取到文件
	plus.io.resolveLocalFileSystemURL(url,function(entry){
		entry.file( function(file){
			var fileReader = new plus.io.FileReader();
			fileReader.readAsDataURL(file);
			fileReader.onloadend = function(e) {
				var picUrl = e.target.result.toString();
				var idpicIndex = "#picIndex"+i;
				var picIndex = $(idpicIndex).val();
				var nowIndex = parseInt(picIndex)+1;
				$(idpicIndex).val(nowIndex);
				var html = '';
				var idname = "#image-list"+i;
				var divname = i+''+nowIndex;
				html += $(idname).html();
				html += '<div class="image-item picturediv space col-xs-3" id="'+divname+'">';
				html += '<div class="image-close" onclick="delPic('+divname+');">X</div>';
				html += '<div><img src="'+picUrl+'" class="upload_img" style="width:75px;height:80px;"/></div>';
				html += '</div>';
				$(idname).html(html);
			}
		});
	});
}
//压缩图片
function compressImage(url,filename,i){
	var name="_doc/upload/"+filename;
	plus.zip.compressImage({
			src:url,//src: (String 类型 )压缩转换原始图片的路径
			dst:name,//压缩转换目标图片的路径
			quality:40,//quality: (Number 类型 )压缩图片的质量.取值范围为1-100
			overwrite:true//overwrite: (Boolean 类型 )覆盖生成新文件
		},
		function(zip) {
			//页面显示图片
			showPics(zip.target,name,i);
		},function(error) {
			plus.nativeUI.toast("压缩图片失败，请稍候再试");
		});
}

//调用手机摄像头并拍照
function getImage(i) {
	var cmr = plus.camera.getCamera();
	cmr.captureImage(function(p) {
		plus.io.resolveLocalFileSystemURL(p, function(entry) {
			compressImage(entry.toLocalURL(),entry.name,i);
		}, function(e) {
			plus.nativeUI.toast("读取拍照文件错误：" + e.message);
		});
	}, function(e) {
	}, {
		filter: 'image'
	});
}
//从相册选择照片
function galleryImgs(i) {
	plus.gallery.pick(function(e) {
		var name = e.substr(e.lastIndexOf('/') + 1);
		compressImage(e,name,i);
	}, function(e) {
	}, {
		filter: "image"
	});
}

//点击事件，弹出选择摄像头和相册的选项
function showActionSheet(i) {
	var bts = [{
		title: "拍照"
	}, {
		title: "从相册选择"
	}];
	plus.nativeUI.actionSheet({
			cancel: "取消",
			buttons: bts
		},
		function(e) {
			if (e.index == 1) {
				getImage(i);
			} else if (e.index == 2) {
				galleryImgs(i);
			}
		}
	);
}

function showActionSheet1() {
	alert(1)
}


function delPic(i){
	var canshu = "#"+i
	$(canshu).remove()
}
    	
