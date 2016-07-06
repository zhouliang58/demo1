$(function(){
	$(".base_left").mouseover(function(){
		$(this).css("background","#e6e6e6");
		$(this).find("span").css("background-position","-43px -82px");
	});
	$(".base_left").mouseout(function(){
		$(this).css("background","white");
		$(this).find("span").css("background-position","4px -82px");
	});
	$(".base_right").mouseover(function(){
		$(this).css("background","#e6e6e6");
		$(this).find("span").css("background-position","-40px 5px");
	});
	$(".base_right").mouseout(function(){
		$(this).css("background","white");
		$(this).find("span").css("background-position","5px 5px");
	});
	$(".list").mouseover(function(){
		$(this).css("background","#e6e6e6");
	});
	$(".list").mouseout(function(){
		$(this).css("background","white");
	});
	
	var flag=0;
	var toggleheight=$(".list").parent().offset().top;
	var h=625;
	$(".list").click(function(){
		
			if(flag==0){
			
				$(this).find("span").css("background-position","3px -58px");
				$(this).parent().animate({top:toggleheight-100});
				$(".bottle").animate({top:h-100,height:'100px'});
				$(".base_left").css("height",h-130);
				$(".base_right").css("height",h-130);
				$(".content").animate({height:h-130});
				flag=1;
			}else{
			
				$(this).find("span").css("background-position","-16px -58px");
				$(this).parent().animate({top:toggleheight});
				$(".bottle").animate({top:h,height:'0px'});
				$(".base_left").css("height",h-30);
				$(".base_right").css("height",h-30);
				$(".content").animate({height:h-30});
				flag=0;
				
			}
			});
	var indexlog=3;
	$(".bottle ul li").mouseover(function(){
		$(this).css("border","1px solid red");
		$(".bottle ul li").eq(indexlog).css("border","1px solid red");
	});
	$(".bottle ul li").mouseout(function(){
		$(this).css("border","1px solid #e6e6e6");
		$(".bottle ul li").eq(indexlog).css("border","1px solid red");
	});
	$(".bottle ul li").click(function(){
		var url=$(this).find("img").attr("src");
		url="url("+url+") no-repeat";
		$(".content").css("background",url).css("background-position","50%").css("background-size","contain");
		indexlog=$(this).index();
		var size=$(".bottle ul li").size();
		if(indexlog>=3){
			var left=(indexlog-3)*(-127);
			if((size-7)*(-127)<left){
				left=left+"px";
				$(".bottle ul li").animate({left:left},500);
			}else{
				left=(size-7)*(-127)+"px";
				$(".bottle ul li").animate({left:left},500);
			}
			
		}
		suan();
	});
	$(".bottle .r").click(function(){
		var size=$(".bottle ul li").size();
		var left=$(".bottle ul li").css("left");
		left=parseInt(left);
		left=left-381;
	if(left%127==0){
		if((size-7)*(-127)<left){
			left=left+"px";
			$(".bottle ul li").animate({left:left},500);	
		}else{
			left=(size-7)*(-127)+"px";
			$(".bottle ul li").animate({left:left},500);
		}
	}
		
	});
	$(".bottle .l").click(function(){
		var left=$(".bottle ul li").css("left");
		left=parseInt(left);
		left=left+381;
		if(left%127==0){
		if(left<0){
			left=left+"px";
			$(".bottle ul li").animate({left:left},500);
		}else{
			$(".bottle ul li").animate({left:"0px"},500);
		}
		}
	});
	
	$(".base_left").click(function(){
		if(indexlog>=1){
		var url=$(".bottle ul li").eq(indexlog-1).find("img").attr("src");
		url="url("+url+") no-repeat";
		$(".content").css("background",url).css("background-position","50%").css("background-size","contain");
		var size=$(".bottle ul li").size();
		if(indexlog>=4){
			var left=(indexlog-4)*(-127);
			if((size-7)*(-127)<left){
				left=left+"px";
				$(".bottle ul li").animate({left:left},500);
			}else{
				left=(size-7)*(-127)+"px";
				$(".bottle ul li").animate({left:left},500);
			}
			
		}
		indexlog--;
		suan();
		}else{
			alert("已经是第一张啦");
		}
		
		
	});
	$(".base_right").click(function(){
		var size=$(".bottle ul li").size();
		if(indexlog<size-1){
		var url=$(".bottle ul li").eq(indexlog+1).find("img").attr("src");
		url="url("+url+") no-repeat";
		$(".content").css("background",url).css("background-position","50%").css("background-size","contain");
		if(indexlog>=3){
			var left=(indexlog-2)*(-127);
			if((size-7)*(-127)<left){
				left=left+"px";
				$(".bottle ul li").animate({left:left},500);
			}else{
				left=(size-7)*(-127)+"px";
				$(".bottle ul li").animate({left:left},500);
			}
			
		}else{
			$(".bottle ul li").animate({left:"0px"},500);
		}
		indexlog++;
		suan();
		}else{
			alert("已经最后一张啦");
		}
	});
	function suan(){
		var size=$(".bottle ul li").size();
		
		for(var i=0;i<size;i++){
			$(".bottle ul li").eq(i).css("border","1px solid #e6e6e6");
			if(i==indexlog){
				$(".bottle ul li").eq(i).css("border","1px solid red");
			}
		}
	}
	
});