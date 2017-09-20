(function(exports){
   console.clear();

   //check draggable = true
   //ondragstart
   drag = function(event){
     event.dataTransfer.setData("dragElement", event.target.id);
   }

   //ondragover
   dragOver = function(event){
      event.preventDefault();
    }

   //ondrop
   drop = function(event){
      event.preventDefault();
      var data =  event.dataTransfer.getData("dragElement");
      event.target.appendChild(document.getElementById(data));
   }

}
)(typeof window === 'undefined' ? module.exports : window);
