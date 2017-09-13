!(function (){
    
    var canvas = function(id){
        var canv=document.createElement("canvas");
        canv.setAttribute("id", id);
        return canv;
    };
    
    var context = function(canvas){
        var context = canvas.getContext("2d");
        return context;
    }
    
    var canvas = canvas("convasId");
    var context = context(canvas);
    
    context.fillStyle = "#FF0000";
    context.fillRect(2, 2, 15, 10); 
    document.body.appendChild(canvas);
    
}
)();