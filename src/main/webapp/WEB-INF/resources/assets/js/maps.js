function initialize() {
	var mapOptions = {
		center: new google.maps.LatLng(-18.911549 , 47.526622),
	
		zoom: 16.5,
		mapTypeId:google.maps.MapTypeId.PLAN
  };
	var carte = new google.maps.Map(document.getElementById("carteId"),mapOptions);
	
}
google.maps.event.addDomListener(window, 'load', initialize);
	