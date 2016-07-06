function searchToggle(obj, evt){
		var container = $(obj).closest('.search-wrapper');

		if(!container.hasClass('active')){
			  container.addClass('active');
			  evt.preventDefault();
		}
		else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
			  container.removeClass('active');
			  // clear input
			  container.find('.search-input').val('');
			  // clear and hide result container when we press close
			  container.find('.result-container').fadeOut(100, function(){$(this).empty();});
		}
	}

	function submitFn(obj, evt){
		value = $(obj).find('.search-input').val().trim();

		_html = "Yup yup! Your search text sounds like this: ";
		
		if(!value.length){
			  
		}
		else{
			//如果输入不为空
			window.location.href="servlet/LimitItemsServlet?itemName="+value+"#location";   
		}

		$(obj).find('.result-container').html('<span>' + _html + '</span>');
		$(obj).find('.result-container').fadeIn(100);

		evt.preventDefault();
	}