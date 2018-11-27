$(document).ready(function() {
	$("#one-way").on('click', function() {
		$('#return-date').hide();
		$('.flight-type').removeClass("btn-primary").addClass("btn-secondary");
		$(this).addClass("btn-primary").removeClass("btn-secondary");
		$('input[name=tripType]').val("one_way");
	})

	$("#round-trip").on('click', function() {
		$('.flight-type').removeClass("btn-primary").addClass("btn-secondary");
		$(this).addClass("btn-primary").removeClass('btn-secondary');
		$('#return-date').show();
		$('input[name=tripType]').val("round_trip");
	})

	$('#one-way').click();

	$('.date-picker').datepicker({
		minDate : 0,
		dateFormat : 'mm/dd/yy'
	});
    $(function() {
        // this will get the full URL at the address bar
        var url = window.location.href;

        // passes on every "a" tag
        $("#topmenu a").each(function() {
            // checks if its the same on the address bar
            if (url == (this.href)) {
                $(this).closest("li").addClass("active");
                //for making parent of submenu active
                $(this).closest("li").parent().parent().addClass("active");
            }
        });
    });
    // $('#departure-date').on('change', function(){
	// debugger;
	// $("#return-date").datepicker(
	// "change", {
	// minDate: new Date($('#departure-date').val())
	// });
	// })
})