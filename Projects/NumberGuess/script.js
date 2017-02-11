//get all the object information in a variable
var inputText = document.querySelector("input.guess");
var checkButton = document.querySelector("input.button");
var replayButton = document.querySelector("input.replay");
var trial = document.querySelector("div.trial");
var gameTable = document.querySelector("div.table");

//guess counter
var guessCount = 0;
//random value which is to be guessed by the user
var randomValue = Math.floor(Math.random() * 100) + 1;
//game counter
var gameCount = 1;

//initially this will be hidden
replayButton.style.visibility= 'hidden';
gameTable.style.visibility= 'hidden';

//event listner for the text for number validation
inputText.addEventListener('keyup', inputValueEvent);
//event listner for the check button for empty string validation and check if the user guessed the right number
checkButton.addEventListener('click', checkButtonEvent);
//event listner for the replay button to show the game table
replayButton.addEventListener('click', replayButtonEvent);

//input Text event handler
inputValueEvent = function(){
  var charValue = inputText.value.toString();
  //value should be a number
  if(charValue.charCodeAt(0) < 48 || charValue.charCodeAt(0) > 57)
    inputText.value=null;
  //number should be in range
  if(inputText.value > 100 || inputText.value < 0)
    inputText.value=null;
}

//check button event handler
checkButtonEvent = function(){
  //check the value is empty
  if(inputText.value == '')
  	return;
  //check if the user guess is correct then display the number of guesses
  if(Number(inputText.value) == Number(randomValue)){
  	trial.innerHTML ='Congratulations! You Won in ' + guessCount + ' guesses';
    //set the visibility of the replay button and the game table to true
    replayButton.style.visibility= 'visible';
    gameTable.style.visibility= 'visible';
  }//If Number is less that the randomValue, then give hint to guess greater than the current guess
  else if(Number(inputText.value) < Number(randomValue))
  	trial.innerHTML ='Number is greater than you guess, your guess count is ' + (++guessCount);
  else//Number is greater that the randomValue,, then give hint to guess lesser than the current guess
  	trial.innerHTML ='Number is lesser than you guess, your guess count is ' + (++guessCount);
}

//replay button event handler
replayButtonEvent = function(){
  //set the visibility back to false
  replayButton.style.visibility= 'hidden';
  //recompute the values for the new game
  randomValue = Math.floor(Math.random() * 100) + 1;
  //compute the current status
  var tableChild = document.createElement('div');
  tableChild.id=1;
  tableChild.innerHTML = tableChild.id + '|' + count;
  //add the status to the game table
  gameTable.appendChild(tableChild);
  //rest the value and increase the game count
  guessCount = 0;
  gameCount++;
 }
