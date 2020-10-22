
var cityList = [
  
]  
  var hotCity = ['yx|宜秀', 'dg|大观', 'yj|迎江']
  
  $(function () {
  
      init();
  
      // 选择
      $('body').on('click', '.city-list p', function () {
          var data = $(this).text() + '|' + $(this).data('id');
          alert(data+"1")
      });
  
      $('.hot.hotCity').on('click', 'div', function () {
          var data = $(this).data('id');
          window.location.href = "index.html?diqu="+data;
      });
  
  })
  
  
  function init() {
      $('.city').html('');
      var hotHtml = '';
      hotHtml += '<div class="tips" id="热门1">热门</div>';
      hotHtml += '<div class="hot hotCity">';
      $.each(hotCity, function (i, item) {
          var split = item.split('|');
          hotHtml += '<div data-id="'+ split[0] +'">' + split[1] + '</div>'
      })
      hotHtml += '</div>';
      $('.city').append(hotHtml);
      
      var html = '';
      $.each(cityList, function (i, item) {
          html += '<div class="city-list"><span class="city-letter" id="' + item.key + '1">' + item.key + '</span>';
          $.each(item.data, function (j, data) {
            var split = data.split('|');
              html += '<p data-id="'+ split[0] +'">' + split[1] + '</p>';
          })
          html += '</div>';
      })
      $('.city').append(html);
  }
  
  
  ; (function ($) {
  
      $('.letter').bind("touchstart touchmove", function (e) {
          var top = $(window).scrollTop();
          e.preventDefault();//阻止默认滚动
          var touch = e.touches[0];
          var ele = document.elementFromPoint(touch.pageX, touch.pageY - top);
  
          if (ele.tagName === 'A') {
              var s = $(ele).text();
              $(window).scrollTop($('#' + s + '1').offset().top)
              $("#showLetter span").html(s.substring(0, 1));
              $("#showLetter").show().delay(500).hide(0);
          }
      });
  
      $('.letter').bind("touchend", function (e) {
          $("#showLetter").hide(0);
      });
  
  })(Zepto); 
  