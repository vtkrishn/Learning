(function(exports){
   console.clear();

  setTimeout(function(){
    console.log('this is a msg from call back');
  },3600);

}
)(typeof window === 'undefined' ? module.exports : window);
