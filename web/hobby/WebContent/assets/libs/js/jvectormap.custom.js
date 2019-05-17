$(function() {
    "use strict";

    jQuery('#world-map-markers').vectorMap({
        map: 'world_mill_en',
        backgroundColor: 'transparent',
        borderColor: '#818181',
        borderOpacity: 0.25,
        borderWidth: 1,
        zoomOnScroll: false,
        color: '#8b94d6',
        regionStyle: {
            initial: {
                fill: '#8b94d6'
            }
        },
        markerStyle: {
            initial: {
                r: 9,
                'fill': '#fff',
                'fill-opacity': 1,
                'stroke': '#000',
                'stroke-width': 5,
                'stroke-opacity': 0.4
            },
        },
        enableZoom: true,
        hoverColor: '#8b94d6',
        markers: [{
            latLng: [21.00, 78.00],
            name: 'India'

        }],
        hoverOpacity: null,
        normalizeFunction: 'linear',
        scaleColors: ['#b6d6ff', '#005ace'],
        selectedColor: '#c9dfaf',
        selectedRegions: [],
        showTooltip: true,
        onRegionClick: function(element, code, region) {
            var message = 'You clicked "' +
                region +
                '" which has the code: ' +
                code.toUpperCase();

            alert(message);
        }
    });


    $('#korea').vectorMap({
        map: 'kr_mill',
        backgroundColor: 'transparent',
        zoomOnScroll: false,
        regionStyle: {
            initial: {
                fill: '#64ced3'
            }
        }
    });


    /*$('#usa').vectorMap({
        map: 'us_aea_en',
        backgroundColor: 'transparent',
        zoomOnScroll: false,
        regionStyle: {
            initial: {
                fill: '#f87ca1'
            }
        }
    });*/



    /*$('#australia').vectorMap({
        map: 'au_mill',
        backgroundColor: 'transparent',
        zoomOnScroll: false,
        regionStyle: {
            initial: {
                fill: '#ffe174'
            }
        }
    });*/

    /*$('#uk').vectorMap({
        map: 'uk_mill_en',
        backgroundColor: 'transparent',
        zoomOnScroll: false,
        regionStyle: {
            initial: {
                fill: '#ffa47f'
            }
        }
    });*/
    //made by 권영�(지�릭지�름 �어�기)
    //-------------------------------------------------
    var $path = $("path");
    var addressList = {
    			KR31:	 '�산',
    			KR49:	 '�주',
    			KR48:	  '경상�도',
    			KR45:	  '�라북도',
    			KR44:	  '충청�도',
    			KR47:	  '경상북도',
    			KR46:	  '�라�도',
    			KR41:	 '경기,
    			KR43:	  '충청북도',
    			KR42:	 '강원,
    			KR27:	 '��,
    			KR11:	 '�울',
    			KR50:	 '�종',
    			KR29:	 '경주',
    			KR28:	 '�천',
    			KR30:	 '�,
    			KR26:	 '부,
    };
    var addressArr = [
    			{ name : 'KR31',	value :	'�산'},
    			{ name : 'KR49',	value :	'�주'},
    			{ name : 'KR48',	value :	'경상�도'},
    			{ name : 'KR45',	value :	'�라북도'},
    			{ name : 'KR44',	value :	'충청�도'},
    			{ name : 'KR47',	value :	'경상북도'},
    			{ name : 'KR46',	value :	'�라�도'},
    			{ name : 'KR41',	value :	'경기},
    			{ name : 'KR43',	value :	'충청북도'},
    			{ name : 'KR42',	value :	'강원},
    			{ name : 'KR27',	value :	'��},
    			{ name : 'KR11',	value :	'�울'},
    			{ name : 'KR50',	value :	'�종'},
    			{ name : 'KR29',	value :	'경주'},
    			{ name : 'KR28',	value :	'�천'},
    			{ name : 'KR30',	value :	'�},
    			{ name : 'KR26',	value :	'부}
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
  //-------------------------------------------------
});