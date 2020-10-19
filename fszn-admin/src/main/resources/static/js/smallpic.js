function dealImage(path, obj, callback) {
				var img = new Image();
				img.src = path;
				img.onload = function() {
					var that = this;
					// 默认按比例压缩
					var w = that.width,
						h = that.height,
						scale = w / h;
					w = obj.width || w;
					h = obj.height || (w / scale);
					var quality = obj.quality || 0.7; // 默认图片质量为0.7
					//生成canvas
					var canvas = document.createElement('canvas');
					var ctx = canvas.getContext('2d');
					// 创建属性节点
					var anw = document.createAttribute("width");
					anw.nodeValue = w;
					var anh = document.createAttribute("height");
					anh.nodeValue = h;
					canvas.setAttributeNode(anw);
					canvas.setAttributeNode(anh);
					ctx.drawImage(that, 0, 0, w, h);
					// 图像质量
					if(obj.quality && obj.quality <= 1 && obj.quality > 0) {
						quality = obj.quality;
					}
					// quality值越小，所绘制出的图像越模糊
					var base64 = canvas.toDataURL('image/jpeg', quality);
					// 回调函数返回base64的值
					callback(base64);
				}
			}

			//将base64转换为blob
			function dataURLtoBlob(dataurl) {
				var arr = dataurl.split(','),
					mime = arr[0].match(/:(.*?);/)[1],
					bstr = atob(arr[1]),
					n = bstr.length,
					u8arr = new Uint8Array(n);
				while(n--) {
					u8arr[n] = bstr.charCodeAt(n);
				}
				return new Blob([u8arr], {
					type: mime
				});
			}

			function upload(file) {
				var that = this;
				// 创建form对象
				let param = new FormData();
				// 通过append向form对象添加数据
				param.append('img', file);
				// 文件大小
				param.append('size', file.size);
				for(var n in that.params) {
					param.append(n, that.params[n]);
				}
				// 创建ajax
				var xhr = new XMLHttpRequest();
				xhr.onload = function() {
					console.log(xhr.responseText)
				}
				xhr.open("POST", "yourapi", true);
				// 发送表单数据
				xhr.send(param);
			}