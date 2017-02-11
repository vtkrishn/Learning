var inputText = document.querySelector("input.guess");
var checkButton = document.querySelector("input.button");
var trial = document.querySelector("div.trial");

var randomValue = Math.floor(Math.random() * 100) + 1;

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
  var count = 0;
	if(inputText.value == randomValue){
  	trial.innerHTML ='You Won in ' + count;
  }
  else if(inputText.value < randomValue){
  count++;
  trial.innerHTML ='Number is greater than you guess, your guess count is ' + count;
  }
  else{
  count++;
  trial.innerHTML ='Number is lesser than you guess, your guess count is ' + count;
  }

}

inputText.addEventListener('keyup', inputValueEvent);
checkButton.addEventListener('click', checkButtonEvent);
