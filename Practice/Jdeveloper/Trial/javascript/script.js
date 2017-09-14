// !(function (options){
    
//     // var canvas = function(id){
//     //     var canv=document.createElement("canvas");
//     //     canv.setAttribute("id", id);
//     //     return canv;
//     // };
    
//     // var context = function(canvas){
//     //     var context = canvas.getContext("2d");
//     //     return context;
//     // }
    
//     // var canvas = canvas("convasId");
//     // var context = context(canvas);
    
//     // context.fillStyle = "#FF0000";
//     // context.fillRect(2, 2, 15, 10); 
//     // document.body.appendChild(canvas);

//     // var value = document.body.querySelector('script').innerHTML;
//     // var line = value.split(/\n+/g);
     
//     //  for(var i=1;i<line.length-1;i++){
        
//     //     var command = line[i].split(' ');
//     //     if(command[0] === 'print'){
            
//     //         var tag = document.createElement('span');
//     //         tag.setAttribute('id',command[0] + i);
//     //         tag.innerHTML = command[1] + '&nbsp;';
//     //         tag.style ='color :' + command[2] + ';';
//     //         document.body.appendChild(tag);
//     //     }
//     //  }

//     var tinyAd = document.getElementById('tinyAd');
//     var value = tinyAd.getAttribute('options');
//     for(var i=0;i<value.length;i++){
//         document.body.innerHTML+=value[i];
//         document.body.style='transition : 100s; background-color : grey';
//     }
// }
// )();

(function(exports){
    'use strict';
    
    var $ = (function(test){
      
      var execute = function(test){
        test(1);
      }

      return execute();
    }()); 
  
    console.clear()
    //console.log('vinod');
    
  exports.$ = $;
  
})(typeof window === 'undefined' ? module.exports : window)