<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Restaurants by Pincode</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<style type="text/css">
.search {
	margin-top: 30px;
	font-size: 40px;
}

.search input, .search button {
	font-size: 25px;
	line-height: 25px;
	height: auto;
}

.search .input-group {
	margin: 10px auto;
}

#results > .location {
	padding: 20px 0;
	border-bottom: 1px solid silver;
}

#results > .resto > .name {
	background-color: #ddd;
	padding: 10px 5px;
}

#results > .nodata {
	text-align: center;
	padding: 20px 0;
}
</style>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery("#search").click(searchNearbyRestaurants);
	});

	function searchNearbyRestaurants() {
		var pin = jQuery("#pincode").val();

		console.log("Will search with pin: " + pin);

		jQuery(this).attr('disabled', 'disabled');
		
		
		jQuery.get('/api/address/' + pin, "", showRestaurants)
		.always(
			function () {
				console.log('processing always');
				jQuery("#search").removeAttr('disabled'); 
			}
		);

	}
	
	function showRestaurants(data) {
		console.log("Showing restaurants");

		var target = jQuery("#results");

		target.html('');
		
		if (!data.success) {
			target.append('<h2 class="nodata">No restaurants found!</h2>')
		} else {
			target.append('<h2 class="location">Showing restaurants near ' + data.address + '</h2>')
			data.restaurants.forEach(
				function(resto) {
					var resto = 
					target.append('<div class="resto">' +
					'<h3 class="name">' + resto.name + '</h3>' +
					'<h4 class="address">Address: ' + resto.vicinity + '</h4>' +
					'<h4 class="open">Open Now: ' + resto.openNowStatus + '</h4>' +
					'<h4 class="rating">Rating: ' + resto.rating + '</h4>' +
					'</div>');
				}
			);
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div
				class="form-inline search col-md-6 col-md-offset-3">
				<div class="form-group">
					<div class="input-group">
						<input type="text" class="form-control" id="pincode"
							name="pincode" placeholder="Enter a valid pincode">
					</div>
				</div>
				<button id="search" type="button" class="btn btn-primary">Search</button>
			</div>
			<div id="results" class="col-md-8 col-md-offset-2">
			
			</div>
		</div>
	</div>
</body>
</html>
