<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function() {
	
	function selectZip(z, a) {
		$("#zipcode").val(z);
		$("#address").val(a);
		$("#zipModal").modal("hide");
		$("#doro").val('');
		$("#zip_codeList").val('');
	}
	$("#searchBtn").click(function() {
		
		var $doro = $("#doro").val();
		$.ajax({
			type : "GET",
			url : "${root}/user/zipsearch.kitri",
			dataType : "json",
			data : {
				"doro" : $doro
			},
			success : function(result) {
				var ziplistView = $("#zip_codeList");
				var view = "";
				var list = result.ziplist;
				var len = list.length;
				for(var i = 0; i < len; i++) {
					var zipcode = list[i].zipcode;
					var address = list[i].sido + " " 
					+ list[i].gugun + " " 
					+ list[i].upmyon + " " 
					+ list[i].doro + " " 
					+ list[i].buildingNumber + " " 
					+ list[i].sigugunBuildingName;
					view += "<tr>\n";
					view += "<td>" + zipcode + "</td>\n";
					view += "<td>";
					view += '<a href="javascript:selectZip(\''+zipcode+'\', \''+address + '\');">';
					view += address;
					view += '</a>';
					view += "</td>\n";
					view += "</tr>\n";
				}
				ziplistView.empty().append(view);
			},
			error : function(a, b, c) {
				alert(a+", "+b+", "+c)
			}
			
		});
	});
	
});
</script>
<div id="zipModal" class="modal fade" role="dialog">
	<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>    
            <div class="modal-body text-center">

            		<div align="center">
            			<label>도로명 주소검색</label>
            		</div>
					<div class="input-group" align="left">
						<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)">
						<span class="input-group-btn">
						<input type="button" class="btn btn-warning" value="검색" id="searchBtn">
						</span>
					</div>
				<div class="table text-center">
					<table>
                		<thead>
                		<tr>
                			<th style="width:150px;">우편번호</th>
                			<th style="width:600px;">주소</th>
                		</tr>
                		</thead>
                		<tbody id="zip_codeList">
                		
                		</tbody>
                	</table>
				</div>
            </div>
        </div>
    </div>
</div>