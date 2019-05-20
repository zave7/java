$(function() {
	var $path = $("path");
    var addressList = {
    			KR31:	 '울산',
    			KR49:	 '제주',
    			KR48:	  '경상남도',
    			KR45:	  '전라북도',
    			KR44:	  '충청남도',
    			KR47:	  '경상북도',
    			KR46:	  '전라남도',
    			KR41:	 '경기도',
    			KR43:	  '충청북도',
    			KR42:	 '강원도',
    			KR27:	 '대구',
    			KR11:	 '서울',
    			KR50:	 '세종',
    			KR29:	 '경주',
    			KR28:	 '인천',
    			KR30:	 '대전',
    			KR26:	 '부산',
    };
    var addressArr = [
    			{ name : 'KR31',	value :	'울산'},
    			{ name : 'KR49',	value :	'제주'},
    			{ name : 'KR48',	value :	'경상남도'},
    			{ name : 'KR45',	value :	'전라북도'},
    			{ name : 'KR44',	value :	'충청남도'},
    			{ name : 'KR47',	value :	'경상북도'},
    			{ name : 'KR46',	value :	'전라남도'},
    			{ name : 'KR41',	value :	'경기도'},
    			{ name : 'KR43',	value :	'충청북도'},
    			{ name : 'KR42',	value :	'강원도'},
    			{ name : 'KR27',	value :	'대구'},
    			{ name : 'KR11',	value :	'서울'},
    			{ name : 'KR50',	value :	'세종'},
    			{ name : 'KR29',	value :	'경주'},
    			{ name : 'KR28',	value :	'인천'},
    			{ name : 'KR30',	value :	'대전'},
    			{ name : 'KR26',	value :	'부산'}
    ];
    $path.click(function(addressList) {
    	//alert("data-code = "+$(this).attr("data-code").replace('-', ''));
    	for(var i=0; i<17; i++) {
    		if(addressArr[i].name == $(this).attr("data-code").replace('-', '')) {
    			alert(addressArr[i].value);
    			break;
    		}
    	}
    });
});
