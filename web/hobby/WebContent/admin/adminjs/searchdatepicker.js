$(function() {
		var startDate = new Date();
		var fechaFin = new Date();
		var FromEndDate = new Date();
		var ToEndDate = new Date();

		$('.yearFrom').datepicker({
			autoclose : true,
			minViewMode : 2,
			format : 'yyyy'
		}).on(
				'changeDate',
				function(selected) {
					startDate = new Date(selected.date.valueOf());
					startDate.setDate(startDate.getDate(new Date(selected.date
							.valueOf())));
					$('.to').datepicker('setStartDate', startDate);
				});

		$('.yearTo').datepicker({
			autoclose : true,
			minViewMode : 2,
			format : 'yyyy'
		}).on(
				'changeDate',
				function(selected) {
					FromEndDate = new Date(selected.date.valueOf());
					FromEndDate.setDate(FromEndDate.getDate(new Date(
							selected.date.valueOf())));
					$('.from').datepicker('setEndDate', FromEndDate);
				});
		//-----------------------------------------------------------------------------
		$('.monthFrom').datepicker({
			autoclose : true,
			minViewMode : 1,
			format : 'yyyy/mm'
		}).on(
				'changeDate',
				function(selected) {
					startDate = new Date(selected.date.valueOf());
					startDate.setDate(startDate.getDate(new Date(selected.date
							.valueOf())));
					$('.to').datepicker('setStartDate', startDate);
				});

		$('.monthTo').datepicker({
			autoclose : true,
			minViewMode : 1,
			format : 'yyyy/mm'
		}).on(
				'changeDate',
				function(selected) {
					FromEndDate = new Date(selected.date.valueOf());
					FromEndDate.setDate(FromEndDate.getDate(new Date(
							selected.date.valueOf())));
					$('.from').datepicker('setEndDate', FromEndDate);
				});
		//-----------------------------------------------------------------------------
		$('.dayFrom').datepicker({
			autoclose : true,
			minViewMode : 0,
			format : 'yyyy/mm/dd'
		}).on(
				'changeDate',
				function(selected) {
					startDate = new Date(selected.date.valueOf());
					startDate.setDate(startDate.getDate(new Date(selected.date
							.valueOf())));
					$('.to').datepicker('setStartDate', startDate);
				});

		$('.dayTo').datepicker({
			autoclose : true,
			minViewMode : 0,
			format : 'yyyy/mm/dd'
		}).on(
				'changeDate',
				function(selected) {
					FromEndDate = new Date(selected.date.valueOf());
					FromEndDate.setDate(FromEndDate.getDate(new Date(
							selected.date.valueOf())));
					$('.from').datepicker('setEndDate', FromEndDate);
				});
	});