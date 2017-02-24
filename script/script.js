var now = new Date();

var date = document.getElementById('date');
var day = document.getElementById('day');
var month = document.getElementById('month');
var days = ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'];
var months = ['January','February','March','April','May','June','July','August','September','October','November','December'];

var dateElem  = ((now.getDate()<10) ? "0" : "") + now.getDate();
var today = days[now.getDay()];
var month = months[now.getMonth()];

date.textContent = dateElem;
day.textContent = today;
months.textContent = month;


