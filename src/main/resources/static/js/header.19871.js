// 최근 본 상품
jQuery(document).ready(function() {
	// 최근 본 상품 카운트
	var count = 2;


	if (jQuery('.productrecent > ul > li').length) {

		jQuery('.productrecent > ul > li').each(function(i) {
			if (i+1 > count) {
				jQuery(this).addClass('displaynone');
			}
		});

		jQuery('.productrecent .prev').unbind('click').click(function()
		{
			var jQueryfirst = jQuery('.productrecent > ul > li:not(.displaynone)').first().prev();

			if (typeof(jQueryfirst.html()) != 'undefined' && jQueryfirst.html() != null) {
				jQueryfirst.removeClass('displaynone').fadeIn('fast');
			} else {
				alert('최근 본 첫번째 상품입니다.');
				return;
			}

			var jQuerylast = jQuery('.productrecent > ul > li:not(.displaynone)').last();
			if (typeof(jQuerylast.html()) != 'undefined') {
				jQuerylast.addClass('displaynone').hide();
			}		
			
		}).css(
		{
			cursor : 'pointer'
		});

		jQuery('.productrecent .next').unbind('click').click(function()
		{
			var jQuerylast = jQuery('.productrecent > ul > li:not(.displaynone)').last().next();
			if (typeof(jQuerylast.html()) != 'undefined' && jQuerylast.html() != null) {
				jQuerylast.removeClass('displaynone').fadeIn('fast');
			} else {
				alert('최근 본 마지막 상품입니다.');
				return;
			}

			var jQueryfirst = jQuery('.productrecent > ul > li:not(.displaynone)').first();
			if (typeof(jQueryfirst.html()) != 'undefined') {
				jQueryfirst.addClass('displaynone').hide();
			}		

		}).css(
		{
			cursor : 'pointer'
		});

	
	} else {
		jQuery('.productrecent').css('display', 'none');
	}
    

    //상단으로 이동
    jQuery(".fix_rt_btm").on('click',function(){
        jQuery("body,html").animate({scrollTop:0},200);
        return false;
    });
});








jQuery(document).ready(function(){
    //상단 메뉴
    jQuery(".lnb_depth1").mouseenter(function(){
       jQuery(this).find("a").addClass("active");
       jQuery(this).find(".lnb_depth2").stop().slideDown("fast");
    }).mouseleave(function(){
       jQuery(this).find("a").removeClass("active");
       jQuery(this).find(".lnb_depth2").stop().slideUp("fast");
    });

    //상단 전체보기 메뉴 열기/닫기
    jQuery("#btn_allMenu").click(function(){
        if (jQuery(this).attr("action") == "off")
        {
            jQuery(this).attr("action","on");
            jQuery(this).addClass("active");
            jQuery(".lnb_wrap").addClass("active");
            jQuery("#allMenuView").addClass("active");
            jQuery("#allMenuView").slideDown("fast");
            jQuery("#header .headerBottom .navWrap .lnb_wrap ul.menu_ico").hide();
            
            
        } else {
            jQuery(this).attr("action","off");
            jQuery(this).removeClass("active");
            jQuery(".lnb_wrap").removeClass("active");
            jQuery("#allMenuView").removeClass("active");
            jQuery("#allMenuView").slideUp("fast");
            jQuery("#header .headerBottom .navWrap .lnb_wrap ul.menu_ico").show();
        }
    });
    
    
    
    var _rbtz = jQuery('#quick_ico');
    jQuery(_rbtz).on('click',function(){
        var _posir = jQuery('#scroll-right').css('right');
        if(_posir == '0px'){
            jQuery('#scroll-right').stop(true,true).animate({'right':'-208px'}).find('#quick_ico').attr("src","/design/wmdk/daylight/pc/img/side_all.png");

        }else if(_posir == '-208px'){
            jQuery('#scroll-right').stop(true,true).animate({'right':'0px'}).find('#quick_ico').attr("src","/design/wmdk/daylight/pc/img/side_on.png")
        }
    });
    
    jQuery(window).ready(function() {
        function loop() {
            jQuery('.point').animate ({ top: '+=4' }, 200) 
                .animate({ top: '-=4' }, 200)
                .animate({ top: '+=4' }, 200)
                .animate({ top: '-=4' }, 200)
                .animate({top:35}, 1600, function() {
                loop();
            });
        }
        loop();
    });


});

