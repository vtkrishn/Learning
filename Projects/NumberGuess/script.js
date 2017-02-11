var inputText = document.querySelector("input.guess");
var checkButton = document.querySelector("input.button");
var replayButton = document.querySelector("input.replay");
var trial = document.querySelector("div.trial");
var gameTable = document.querySelector("div.table");


var count = 0;
var randomValue = Math.floor(Math.random() * 100) + 1;
var gameCount = 1;

replayButton.style.visibility= 'hidden';
gameTable.style.visibility= 'hidden';

inputValueEvent = function(){
  var charValue = inputText.value.toString();

  //value should be a number
  if(charValue.charCodeAt(0) < 48 || charValue.charCodeAt(0) > 57)
    inputText.value=null;

  //number should be in range
  if(inputText.value > 100 || inputText.value < 0)
    inputText.value=null;
}

checkButtonEvent = function(){
  if(inputText.value == '')
  	return;
    alert(randomValue);
  if(Number(inputText.value) == Number(randomValue)){
  	trial.innerHTML ='Congratulations! You Won in ' + count + ' guesses';
    replayButton.style.visibility= 'visible';
    gameTable.style.visibility= 'visible';
   }
  else if(Number(inputText.value) < Number(randomValue))
  	trial.innerHTML ='Number is greater than you guess, your guess count is ' + (++count);
  else
  	trial.innerHTML ='Number is lesser than you guess, your guess count is ' + (++count);
}

replayButtonEvent = function(){
  replayButton.style.visibility= 'hidden';
	randomValue = Math.floor(Math.random() * 100) + 1;
  var tableChild = document.createElement('div');
  tableChild.id=1;
  tableChild.innerHTML = tableChild.id + '|' + count;
  gameTable.appendChild(tableChild);
  count = 0;
  gameCount++;
 }

inputText.addEventListener('keyup', inputValueEvent);
checkButton.addEventListener('click', checkButtonEvent);
replayButton.addEventListener('click', replayButtonEvent);
