  //Direction Renderer and Service object's
  var directionsDisplay = new google.maps.DirectionsRenderer();
  var directionsService = new google.maps.DirectionsService();

  //Origin and Destination Renderer object's
  var originDisplay = new google.maps.DirectionsRenderer();
  var destDisplay = new google.maps.DirectionsRenderer();
  var map;
  var requestMode;
  var flightPath;
  var flightPlanCoordinates;
  var start_steps;
  var end_steps;
  var marker1;
  var marker2;
  var difference;
  var sav;
  var KMPolylineCounter = 0;  
  var limit;
  var i;
  var color;
/**
 * init method
 */
  function initialize() {
  //initialize the call
  setUpDefaultMap();
  }

/**
 * Default map objects
 */
  function setUpDefaultMap(){
    //set the focus to Chicago initially
    var chicago = new google.maps.LatLng(41.618017, -96.482910);
    //Set the options for the map
    var myOptions = {
      zoom:4, //Set the zoom level
      mapTypeId: google.maps.MapTypeId.ROADMAP, // Default to the Road View
      center: chicago, // Chicago as default
      streetViewControl: false, // No Stret View
      disableDefaultUI: true, // default ui is turned off
      scaleControl: true, // the control for scaling is displayed
      zoomControl: true, // Zoom control is displayed
      zoomControlOptions: { 
        style: google.maps.ZoomControlStyle.LARGE //Zoom control is large
      },
      mapTypeControlOptions : {
        style : google.maps.MapTypeControlStyle.DEFAULT
      }
    };
    //Highway Color options
   var polyOptions = {
          strokeColor : "#BD3632",
          strokeWeight : 4,
          strokeOpacity : 1.0
          }; 
          
  directionsDisplay = new google.maps.DirectionsRenderer({ polylineOptions: polyOptions});

    //Set the map canvas to the component
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    //suppress the default marketr
    directionsDisplay.setOptions({suppressMarkers: true});
    //set the map to render the directions
    directionsDisplay.setMap(map);      
  }
  
/**
 * Display Driving direction for Highway
 */
  function drivingHWYRoute() {
  //alert("The application could not build an intermodal route for the lane pair selected. Please contact xyz Group at SalesAdmin@xyz.com or 800-377-5833 to determine intermodal route availability.");
  setUpDefaultMap();
  calcRoute(google.maps.TravelMode.DRIVING,false);
  }

/**
 * Display Driving direction for Intermodal
 */
  function drivingIMLRoute() {
  setUpDefaultMap();
  calcRoute(google.maps.TravelMode.DRIVING,true); 
  }
/**
 * Calculate the Intermodal Route
 * @param mode 
 */
 function calcRoute(mode,flag) {
  var start = document.getElementById("im_origin::content");
  var end = document.getElementById("im_dest::content");
  //compute the request
  var request = {
    origin:start.value,
    destination:end.value,
    travelMode: mode
  };
  //compute the route
  directionsService.route(request, function(result, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      //if its iml
      if(flag){    
         showSteps(result);  
      }
      else{
      
      var route  = result.routes[0].legs[0];    
      var origin = route.steps[0].start_location;
      var dest = route.steps[route.steps.length-1].end_location;       
      change_marker(origin,dest);
      }
      //set the direction
      directionsDisplay.setDirections(result);
      //change the button text value
      change_buttonValue();
      
      
    }
  });
 }
/**
 * 
 * @param result 
 */
function showSteps(result){
  var myRoute = result.routes[0].legs[0];
  computeSteps(myRoute);
}

/**
 * 
 */
function computeCalculations(){
  
   var originDirections;
   var destDirections;
   var directions;
  var route;
  var route1;
  var route2;
  
   
        directions = directionsDisplay.getDirections();
        originDirections = originDisplay.getDirections();
        destDirections = destDisplay.getDirections();
        
              route  = directions.routes[0].legs[0];
              route1  = originDirections.routes[0].legs[0];
              route2  = destDirections.routes[0].legs[0];
       
      
              
    
              
  
  var distance;
  var duration;

  distance = route.distance.value;
  duration = route.duration.value;
  var weight = document.getElementById("weight::content").value;
  var volume = document.getElementById("load::content").value;
  
  var hwy = document.getElementById("hwy::content");
  var highway1 = document.getElementById("highway1");
  
  var hwyStr = new String(roundNumber((distance * 0.000621371192 * volume * 22.22) / highway1), 2);
  var highwayValue = hwyStr;
  hwy.value = hwyStr.concat(" lbs per load");
  
  var hwydur = document.getElementById("hwydur::content");
  //var hwydurStr = new String(roundNumber(duration / (60 * 60 * 10) , 2));
  var hwydurStr = new String(roundNumber(distance / 500), 2);
  hwydur.value = hwydurStr.concat(" Days");

  var distance1;
  var duration1;
 
  distance1 = route1.distance.value;
  duration1 = route1.duration.value;


//Calculate IML CO2 emission - Ramp to destination
//----------------------------------------------------------------------------------------------------      
  var distance2;
  var duration2;
  
  distance2 = route2.distance.value;
  duration2 = route2.duration.value;
  
  var distance3 = document.getElementById("RailMiles::content").value;
  
  var iml = document.getElementById("iml::content");
  var dray = document.getElementById("dray");
  var rail = document.getElementById("rail");
  
  var str = new String(roundNumber(((distance1 * 0.000621371192 * volume / dray) + (distance2 * 0.000621371192 * volume / dray) + (distance3 * (weight / 2000)/ rail)) * 22.22),2);
  var imlValue = str;
  iml.value = str.concat(" lbs per load");
  
  var imldur = document.getElementById("imldur::content");
  var imld = document.getElementById("imld::content");
  var duration3 = imld.value;
  //str = new String(roundNumber((duration1 / (60 * 60 * 10)) + (duration2 / (60 * 60 * 10)) + (duration3 / (10)) , 2));
  str = new String(roundNumber((duration1 / (60 * 60)) + (duration2 / (60 * 60)) + duration3 , 2));
  imldur.value = str.concat(" Days");
  
  difference = Math.abs(highwayValue - imlValue);
  sav = difference / highwayValue;
  computeGraphValue();
}
/**
 * Clear all the values
 * @param event 
 */
function clear(event){

 var start = document.getElementById("im_origin::content");
 var end = document.getElementById("im_dest::content");
  var button = document.getElementById("cb1");
  var weight = document.getElementById("weight");
  var select= document.getElementById("frequency::content");
  button.value = "CALCULATE";
  start.value = "";
  end.value = "";
  weight.value = "";
  select.value = "";
  var input_origin = AdfPage.PAGE.findComponent("im_origin");
  input_origin.setValid(false);
  var input_dest = AdfPage.PAGE.findComponent("im_dest");
  input_dest.setValid(false);
  var rebutton = AdfPage.PAGE.findComponent("recb1");
  rebutton.setVisible(false);

  
}
/**
 * 
 * @param route 
 */
function computeSteps(route){
  //Intermodal Color options
  color = "#275937";

//----------------------------------------------------------------------------------------------------

  origin = route.steps[0].start_location;
  dest = route.steps[route.steps.length-1].end_location;
  
  
//Calculate from origin location to the origin Ramp
//----------------------------------------------------------------------------------------------------
  var olat = document.getElementById("ORampLat::content");
  var olang = document.getElementById("ORampLong::content");
  start_steps = origin;
  end_steps = new google.maps.LatLng(olat.value,olang.value);
    
  var request1 = {
    origin:start_steps,
    destination:end_steps,
    travelMode: google.maps.TravelMode.DRIVING
  };
  
  //Drayage Color options
    var polyOptions = {
          strokeColor : "#69BE28",
          strokeWeight : 4,
          strokeOpacity : 1.0
          }; 
//  originDisplay.polylineOptions = polyOptions;
  originDisplay = new google.maps.DirectionsRenderer({ polylineOptions: polyOptions});
  
  originDisplay.setOptions({suppressMarkers: true, preserveViewport: true});
  
  
  directionsService.route(request1, function(result1, status1) {
  if(status1 == google.maps.DirectionsStatus.OK){
    originDisplay.setMap(map);
    originDisplay.setDirections(result1);
    
  }
  });
  
//Calculate passing events
//----------------------------------------------------------------------------------------------------  
var count = parseInt(document.getElementById("no::content").innerHTML);
limit = count;
for(i=1;i<limit;i++){
loopAndPass(i);  
}
//Calculate from passing 6 to destination Ramp
//----------------------------------------------------------------------------------------------------  
 computeLatAndLong("DRampLat::content","DRampLong::content");
//Calculate from destination Ramp to the destination location
//----------------------------------------------------------------------------------------------------  

    start_steps = end_steps;
    end_steps = dest;
    
    var request2 = {
      origin:start_steps,
      destination:end_steps,
      travelMode: google.maps.TravelMode.DRIVING
    };
    
//    destDisplay.polylineOptions = polyOptions;
    destDisplay = new google.maps.DirectionsRenderer({ polylineOptions: polyOptions});
    destDisplay.setOptions({suppressMarkers: true, preserveViewport: true});
          
    directionsService.route(request2, function(result2, status2) {
     if(status2 == google.maps.DirectionsStatus.OK){
      destDisplay.setMap(map);
      destDisplay.setDirections(result2);
     }
    });
 
//Change the marker to xyz icon
//----------------------------------------------------------------------------------------------------  
  change_marker(origin,dest);
  
//Calculate highway CO2 emission
//----------------------------------------------------------------------------------------------------  

}

function loopAndPass(index){
//computeLatAndLong("tbl:"+ index +":latitude::content","tbl:"+ index +":longitude::content");
computeLatAndLong("latitudej_id_"+ index +"::content","longitudej_id_"+ index +"::content");
}

function computeLatAndLong(latStr,longStr){
  
  var lat = document.getElementById(latStr);
  var lang = document.getElementById(longStr);
 
 start_steps = end_steps;
 if(lat.value != "" && lang.value != ""){
  end_steps = new google.maps.LatLng(lat.value,lang.value);
    doFlight();
  }
}


function doFlight(){
  flightPlanCoordinates = [start_steps,end_steps];
    flightPath = new google.maps.Polyline({path: flightPlanCoordinates,strokeColor: color,strokeOpacity: 1.0,strokeWeight: 4});
  flightPath.setMap(map);
}


function computeCompleteRoute(start,end){
  
  var request3 = {
    origin:start,
    destination:end,
    travelMode: google.maps.TravelMode.DRIVING
  };
  
  var polyOptionsDummy = {
          strokeOpacity : 0
          }; 
          
  destDisplay.polylineOptions = polyOptionsDummy;
  
  destDisplay.setOptions({suppressMarkers: true});
        
  directionsService.route(request3, function(result3, status3) {
   if(status3 == google.maps.DirectionsStatus.OK){
    destDisplay.setMap(map);
    destDisplay.setDirections(result3);
   }
  });
  
}


function computeGraphValue(){
  var tons = document.getElementById("tons::content");
  var trees = document.getElementById("trees::content");
  var cars = document.getElementById("cars::content");
  var savings = document.getElementById("savings::content");
  
  if(tons != null){
    tons.value = parseInt(difference / 2000);
    cars.value = parseInt(difference / 6);
    trees.value = parseInt((difference * 3)/  70);
    savings.value = sav;
    
    var button = AdfPage.PAGE.findComponent("cb1");
    
    AdfCustomEvent.queue(button,
    "setGraphValue",
    {
      "tons":tons.value,
      "cars":cars.value,
      "trees":trees.value,
      "savings":savings.value
     }, true);
  }
}

function roundNumber(number, decimals) { // Arguments: number to round, number of decimal places
	var newnumber = new Number(number+'').toFixed(parseInt(decimals));
	return parseFloat(newnumber); // Output the result to the form field (change for your purposes)
}

function change_marker(org,dst){
  
  marker1 = new google.maps.Marker({
    map:map,
    position:org,
    icon : new google.maps.MarkerImage("images/green_marker.png")
  });
  
  marker2 = new google.maps.Marker({
    map:map,
    position:dst,
    icon : new google.maps.MarkerImage("images/green_marker.png")
  });
  
  addOriginInfo();
  addDestinationInfo();
}

function originInfo(event){
  google.maps.event.trigger(marker1,'click');
}

function destInfo(event){
  google.maps.event.trigger(marker2,'click');
}

function addOriginInfo(){

    var contentString;
//    if(org.indexOf(', CT') != -1 || org.indexOf(', DC') != -1 || org.indexOf(', DE') != -1 || org.indexOf(', ME') != -1 || org.indexOf(', MD') != -1 || org.indexOf(', MA') != -1 || org.indexOf(', NH') != -1 || org.indexOf(', NJ') != -1 || org.indexOf(', PA') != -1 || org.indexOf(', RI') != -1 || org.indexOf(', VT') != -1 || org.indexOf(', VA') != -1 || org.indexOf(', WV') != -1){
//  contentString = 'The Northeast is the home to some of the most densely populated areas in the U.S. which indicates why this market typically is heavier on inbound freight.   In 2011 industry reported domestic intermodal volume of just over 950,000 loads and outbound flows being about 90,000 loads less in this market.';
//    }
//    else if(org.indexOf(', IL') != -1 || org.indexOf(', IN') != -1 || org.indexOf(', IA') != -1 || org.indexOf(', KY') != -1 || org.indexOf(', KS') != -1 || org.indexOf(', MI') != -1 || org.indexOf(', MN') != -1 || org.indexOf(', MO') != -1 || org.indexOf(', OH') != -1 || org.indexOf(', WI') != -1){
//      contentString = 'The Midwest is one of the main shipping xyzs in the North America transportation network.  In 2011 alone over 4 million domestic intermodal loads moved in and out of this market.  xyz Group\'s corporate office is located in the suburbs of Chicago, IL.';   
//    }
//    else if(org.indexOf(', CO') != -1 || org.indexOf(', ID') != -1 || org.indexOf(', MT') != -1 || org.indexOf(', NE') != -1 || org.indexOf(', ND') != -1 || org.indexOf(', SD') != -1 || org.indexOf(', UT') != -1 || org.indexOf(', WY') != -1){
//      contentString = 'The Mountain Central region is the site where the completion of the world\'s first transcontinental railroad at Promontory in Box Elder County, UT where the Central Pacific and Union Pacific Railroads met on May 10, 1869.  The Union Pacific corporate office is located in Omaha, NE.';   
//    }
//    else if(org.indexOf(', AL') != -1 || org.indexOf(', FL') != -1 || org.indexOf(', GA') != -1 || org.indexOf(', MS') != -1 || org.indexOf(', NC') != -1 || org.indexOf(', SC') != -1 || org.indexOf(', TN') != -1){
//      contentString = 'The Southeast is the home of the world\'s busiest airport, Hartsfield-Jackson in Atlanta, as well as the fastest growing port, Port of Savannah.   There is no coincidence that this market sees over 1.5 million domestic intermodal loads in a year.';   
//    }
//    else if(org.indexOf(', AR') != -1 || org.indexOf(', LA') != -1 || org.indexOf(', NM') != -1 || org.indexOf(', OK') != -1 || org.indexOf(', TX') != -1){
//      contentString = 'The anchor of the South Central market is Texas which has the U.S.\'s second largest state according to their GDP and the corporate home of many Fortune 500 companies including Kimberly-Clark, J.C. Penney and AT&T.  This market saw more than one million domestic intermodal moves in 2011.';   
//    }
//    else if(org.indexOf(', AZ') != -1 || org.indexOf(', CA') != -1 || org.indexOf(', NV') != -1){
//      contentString = 'The Southwest market is primarily driven by Southern California, which 20+ million inhabitants draw large amounts of inbound food and other consumer products.  Add to this outbound freight that is heavily weighted towards imported products and this market saw more than 2.5 million domestic intermodal loads in 2011.';   
//    }
//    else if(org.indexOf(', OR') != -1 || org.indexOf(', WA') != -1){
//      contentString = 'The Northwest is focused on the environment friendliness. Housing the Port of Seattle, which is referred to as the Green Gateway for trade, this port combined with intermodal service provide the lowest carbon footprint for ocean to land service from Asia to major U.S. markets in the Midwest and Northeast.  The Port of Tacoma is a major gateway to Asia and Alaska which handles over $28 billion in international trade.  This market handled over a half million domestic intermodal containers in 2011.';   
//    }
    contentString = document.getElementById("originFacts::content").value;
    var infowindow;
    infowindow = new google.maps.InfoWindow({
        content: contentString
    });

    google.maps.event.addListener(marker1, 'click', function() {
      infowindow.open(map,marker1);
    });
    
}

function addDestinationInfo(){

    var contentString;
    
//    if(org.indexOf(', CT') != -1 || org.indexOf(', DC') != -1 || org.indexOf(', DE') != -1 || org.indexOf(', ME') != -1 || org.indexOf(', MD') != -1 || org.indexOf(', MA') != -1 || org.indexOf(', NH') != -1 || org.indexOf(', NJ') != -1 || org.indexOf(', PA') != -1 || org.indexOf(', RI') != -1 || org.indexOf(', VT') != -1 || org.indexOf(', VA') != -1 || org.indexOf(', WV') != -1){
//      contentString = 'The Northeast is the home to some of the most densely populated areas in the U.S. which indicates why this market typically is heavier on inbound freight.   In 2011 industry reported domestic intermodal volume of just over 950,000 loads and outbound flows being about 90,000 loads less in this market.';   
//    }
//    else if(org.indexOf(', IL') != -1 || org.indexOf(', IN') != -1 || org.indexOf(', IA') != -1 || org.indexOf(', KY') != -1 || org.indexOf(', KS') != -1 || org.indexOf(', MI') != -1 || org.indexOf(', MN') != -1 || org.indexOf(', MO') != -1 || org.indexOf(', OH') != -1 || org.indexOf(', WI') != -1){
//      contentString = 'The Midwest is one of the main shipping xyzs in the North America transportation network.  In 2011 alone over 4 million domestic intermodal loads moved in and out of this market.  xyz Group\'s corporate office is located in the suburbs of Chicago, IL.';   
//    }
//    else if(org.indexOf(', CO') != -1 || org.indexOf(', ID') != -1 || org.indexOf(', MT') != -1 || org.indexOf(', NE') != -1 || org.indexOf(', ND') != -1 || org.indexOf(', SD') != -1 || org.indexOf(', UT') != -1 || org.indexOf(', WY') != -1){
//      contentString = 'The Mountain Central region is the site where the completion of the world\'s first transcontinental railroad at Promontory in Box Elder County, UT where the Central Pacific and Union Pacific Railroads met on May 10, 1869.  The Union Pacific corporate office is located in Omaha, NE.';   
//    }
//    else if(org.indexOf(', AL') != -1 || org.indexOf(', FL') != -1 || org.indexOf(', GA') != -1 || org.indexOf(', MS') != -1 || org.indexOf(', NC') != -1 || org.indexOf(', SC') != -1 || org.indexOf(', TN') != -1){
//      contentString = 'The Southeast is the home of the world\'s busiest airport, Hartsfield-Jackson in Atlanta, as well as the fastest growing port, Port of Savannah.   There is no coincidence that this market sees over 1.5 million domestic intermodal loads in a year.';   
//    }
//    else if(org.indexOf(', AR') != -1 || org.indexOf(', LA') != -1 || org.indexOf(', NM') != -1 || org.indexOf(', OK') != -1 || org.indexOf(', TX') != -1){
//      contentString = 'The anchor of the South Central market is Texas which has the U.S.\'s second largest state according to their GDP and the corporate home of many Fortune 500 companies including Kimberly-Clark, J.C. Penney and AT&T.  This market saw more than one million domestic intermodal moves in 2011.';   
//    }
//    else if(org.indexOf(', AZ') != -1 || org.indexOf(', CA') != -1 || org.indexOf(', NV') != -1){
//      contentString = 'The Southwest market is primarily driven by Southern California, which 20+ million inhabitants draw large amounts of inbound food and other consumer products.  Add to this outbound freight that is heavily weighted towards imported products and this market saw more than 2.5 million domestic intermodal loads in 2011.';   
//    }
//    else if(org.indexOf(', OR') != -1 || org.indexOf(', WA') != -1){
//      contentString = 'The Northwest is focused on the environment friendliness. Housing the Port of Seattle, which is referred to as the Green Gateway for trade, this port combined with intermodal service provide the lowest carbon footprint for ocean to land service from Asia to major U.S. markets in the Midwest and Northeast.  The Port of Tacoma is a major gateway to Asia and Alaska which handles over $28 billion in international trade.  This market handled over a half million domestic intermodal containers in 2011.';   
//    }
    contentString = document.getElementById("destFacts::content").value;
    var infowindow;
    infowindow = new google.maps.InfoWindow({
    content: contentString
    });

    google.maps.event.addListener(marker2, 'click', function() {
      infowindow.open(map,marker2);
    });
}


function change_buttonValue(){
  var button = AdfPage.PAGE.findComponent("cb1");
  button.setVisible(false);
  var button2 = AdfPage.PAGE.findComponent("cb12");
  button2.setVisible(true);
  var rebutton = AdfPage.PAGE.findComponent("recb1");
  rebutton.setVisible(true);

}

function closePopup(event){
  AdfPage.PAGE.findComponent("pop1").hide();;
}


  function updateEloquaForm(){
  
//  $.ajaxSetup({
//  cache: "false"
//   });
//  $.ajax({
//  type:"POST", 
//  url: "http://s2595.t.eloqua.com/e/f2", 
//  cache : false,
//  data:$("#f2").serialize(), 
//  success: function(response) {
//    }});
//

var s = $("#f2").serialize();
var xhr = new XMLHttpRequest();
var path="http://s2595.t.eloqua.com/e/f2";
xhr.onreadystatechange=state_change;
xhr.open("POST", path, true);
xhr.setRequestHeader("Content-type", "text/html; charset=UTF-8");
xhr.setRequestHeader("Cache-Control", "no-store, no-cache, must-revalidate");
xhr.setRequestHeader("Expires","0");
xhr.setRequestHeader("Access-Control-Max-Age","3628800");
xhr.setRequestHeader("Access-Control-Allow-Methods:","GET, POST, PUT, DELETE");
xhr.send(s);
  }
