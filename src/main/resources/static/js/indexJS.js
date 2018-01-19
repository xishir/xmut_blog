$(function(){
  var Archives;                             //文章
  var currentPages=1;                       //当前文章页面
  var PageNum;
  init();
  function init(){
    getPages();
    getArchives(currentPages);
    getTags();
  }

  //得到文章内容
  function getArchives(page){
    $.ajax({
      url:"/api/article/list/"+page,
      type:"Get",
      success:function(data){
        Archives=data.data;
        putArchives();
      }
    });
  }
  
  //得到页数
  function getPages(){
		$.ajax({
      url: "/api/article/pageNum",
      type: "GET",
      async: false,
      success: function(msg) {
        if (msg.code == "200") {
          PageNum=msg.data;
          for(var i=0,j=1;i<PageNum;i++,j++){
            $(".pagination li:eq("+i+")").after('<li><a href="#" class="pagesIndex">'+j+'</a></li>');
          }
          bind();
        }
      },
    });
  }

  //绑定事件
  function bind(){
    $(".pagesIndex").click(function(){
      currentPages=this.innerHTML;
      getArchives(currentPages);
      // return false;
    });
    $(".pagination li:first").click(function(){
      if(currentPages>1)getArchives(--currentPages);
    })
    $(".pagination li:last").click(function(){
      if(currentPages<PageNum)getArchives(++currentPages);
    })
  }

  //将文章列表显示
  function putArchives(){
    $(".list-group").text("");
    for(var i=0;i<Archives.length;i++){
      $(".list-group").append('<a href="/Archive/'+Archives[i].id+'" class="list-group-item bod"></a>');
      $(".list-group a:eq("+i+")").append('<h3 class="list-group-item-heading"><b>'+Archives[i].title+'</b></h3>');
      $(".list-group a:eq("+i+")").append('<p class="list-group-item-text">'+marked(Archives[i].content)+'</p>');
    }
  }
})

//jqcloud
(function($) {
	"use strict";
	$.fn.jQCloud = function(word_array, options) {
		// 容器元素的引用
		var $this = this;
		// 都已ID命名 避免多个标签之间的碰撞
		var cloud_namespace = $this.attr('id') || Math.floor((Math.random() * 1000000)).toString(36);

		// 默认选项值
		var default_options = {
			width: $this.width(),
			height: $this.height(),
			center: {
				x: ((options && options.width) ? options.width : $this.width()) / 2.0,
				y: ((options && options.height) ? options.height : $this.height()) / 2.0
			},
			delayedMode: word_array.length > 50,
			shape: false, // 默认为椭圆形状
			encodeURI: true,
			removeOverflowing: true
		};

		options = $.extend(default_options, options || {});

		// “jqcloud”类添加到容器简单的CSS样式,设置容器宽度/高度
		$this.addClass("jqcloud").width(options.width).height(options.height);

		// 容器的CSS位置不能为“静态”
		if ($this.css("position") === "static") {
			$this.css("position", "relative");
		}

		var drawWordCloud = function() {
			//Helper函数来测试如果一个元素重叠
			var hitTest = function(elem, other_elems) {
				// 两两重叠检测
				var overlapping = function(a, b) {
					if (Math.abs(2.0 * a.offsetLeft + a.offsetWidth - 2.0 * b.offsetLeft - b.offsetWidth) < a.offsetWidth + b.offsetWidth) {
						if (Math.abs(2.0 * a.offsetTop + a.offsetHeight - 2.0 * b.offsetTop - b.offsetHeight) < a.offsetHeight + b.offsetHeight) {
							return true;
						}
					}
					return false;
				};
				var i = 0;
				// 检查元素重叠一个接一个,停止并返回false一旦发现重叠
				for (i = 0; i < other_elems.length; i++) {
					if (overlapping(elem, other_elems[i])) {
						return true;
					}
				}
				return false;
			};

			// 确保每一个重量之前是一个数字排序
			for (var i = 0; i < word_array.length; i++) {
				word_array[i].weight = parseFloat(word_array[i].weight, 10);
			}

			// 排序word_array从最高的词体重最低的一个
			word_array.sort(function(a, b) {
				if (a.weight < b.weight) {
					return 1;
				} else if (a.weight > b.weight) {
					return -1;
				} else {
					return 0;
				}
			});

			var step = (options.shape === "rectangular") ? 18.0 : 2.0,
				already_placed_words = [],
				aspect_ratio = options.width / options.height;

			// 函数画一词,在螺旋通过移动它,直到找到一个合适的空地方。这将是迭代每个单词。
			var drawOneWord = function(index, word) {
				// 定义跨越的ID属性,将这个词,和相关的jQuery选择器字符串
				var word_id = cloud_namespace + "_word_" + index,
					word_selector = "#" + word_id,
					angle = 6.28 * Math.random(),
					radius = 0.0,

					// Only used if option.shape == 'rectangular'
					steps_in_direction = 0.0,
					quarter_turns = 0.0,

					weight = 5,
					custom_class = "",
					inner_html = "",
					word_span;
	

				// 扩展词html选项默认值
				word.html = $.extend(word.html, {
					id: word_id
				});

				// 如果指定的自定义类,把它们放在一个变量并将它从html attrs,避免由jQCloud覆盖类
				if (word.html && word.html["class"]) {
					custom_class = word.html["class"];
					delete word.html["class"];
				}

				// 检查是否min(重量)> max(重量)否则使用默认
				if (word_array[0].weight > word_array[word_array.length - 1].weight) {
					// 线性映射原体重一个离散的规模从1到10
					weight = Math.round((word.weight - word_array[word_array.length - 1].weight) /
						(word_array[0].weight - word_array[word_array.length - 1].weight) * 9.0) + 1;
				}
				word_span = $('<span>').attr(word.html).addClass('w' + weight + " " + custom_class);

				// 如果单词添加链接。url属性设置
				if (word.link) {
					//如果链接是一个字符串,然后使用它作为href链接
					if (typeof word.link === "string") {
						word.link = {
							href: word.link
						};
					}

					// 扩展链接的html选项默认值
					if (options.encodeURI) {
						word.link = $.extend(word.link, {
							href: encodeURI(word.link.href).replace(/'/g, "%27")
						});
					}

					inner_html = $('<a>').attr(word.link).text(word.text);
				} else {
					inner_html = word.text;
				}
				word_span.append(inner_html);

				// 将处理程序绑定到单词
				if (!!word.handlers) {
					for (var prop in word.handlers) {
						if (word.handlers.hasOwnProperty(prop) && typeof word.handlers[prop] === 'function') {
							$(word_span).bind(prop, word.handlers[prop]);
						}
					}
				}

				$this.append(word_span);

				var width = word_span.width(),
					height = word_span.height(),
					left = options.center.x - width / 2.0,
					top = options.center.y - height / 2.0;

				// 保存样式属性的引用,获得更好的性能
				var word_style = word_span[0].style;
				word_style.position = "absolute";
				word_style.left = left + "px";
				word_style.top = top + "px";

				while (hitTest(word_span[0], already_placed_words)) {
					// 选择形状是矩形的移动这个词在一个矩形螺旋
					if (options.shape === "rectangular") {
						steps_in_direction++;
						if (steps_in_direction * step > (1 + Math.floor(quarter_turns / 2.0)) * step * ((quarter_turns % 4 % 2) === 0 ? 1 : aspect_ratio)) {
							steps_in_direction = 0.0;
							quarter_turns++;
						}
						switch (quarter_turns % 4) {
							case 1:
								left += step * aspect_ratio + Math.random() * 2.0;
								break;
							case 2:
								top -= step + Math.random() * 2.0;
								break;
							case 3:
								left -= step * aspect_ratio + Math.random() * 2.0;
								break;
							case 0:
								top += step + Math.random() * 2.0;
								break;
						}
					} else { // 默认设置:椭圆螺旋形状
						radius += step;
						angle += (index % 2 === 0 ? 1 : -1) * step;

						left = options.center.x - (width / 2.0) + (radius * Math.cos(angle)) * aspect_ratio;
						top = options.center.y + radius * Math.sin(angle) - (height / 2.0);
					}
					word_style.left = left + "px";
					word_style.top = top + "px";
				}

				// 不呈现词如果外面将容器的一部分
				if (options.removeOverflowing && (left < 0 || top < 0 || (left + width) > options.width || (top + height) > options.height)) {
					word_span.remove()
					return;
				}


				already_placed_words.push(word_span[0]);

				// 如果现有调用回调
				if ($.isFunction(word.afterWordRender)) {
					word.afterWordRender.call(word_span);
				}
			};

			var drawOneWordDelayed = function(index) {
				index = index || 0;
				if (!$this.is(':visible')) { // 如果不可见，那么不要试图拉
					setTimeout(function() {
						drawOneWordDelayed(index);
					}, 10);
					return;
				}
				if (index < word_array.length) {
					drawOneWord(index, word_array[index]);
					setTimeout(function() {
						drawOneWordDelayed(index + 1);
					}, 10);
				} else {
					if ($.isFunction(options.afterCloudRender)) {
						options.afterCloudRender.call($this);
					}
				}
			};

			// 迭代drawOneWord上每一个字。迭代的方式完成取决于绘图模式(delayedMode是真或假的)
			if (options.delayedMode) {
				drawOneWordDelayed();
			} else {
				$.each(word_array, drawOneWord);
				if ($.isFunction(options.afterCloudRender)) {
					options.afterCloudRender.call($this);
				}
			}
		};

		// 延迟执行,以便在浏览器可以渲染云画推算的强化词前的页面
		setTimeout(function() {
			drawWordCloud();
		}, 10);
		return $this;
	};
})(jQuery);