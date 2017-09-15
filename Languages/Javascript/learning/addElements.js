(function(exports){
   console.clear();

//   setTimeout(function(){
//     console.log('this is a msg from call back');
//   },3600);

  var tagMap = new Map();

  createElement = function(tag,id){
    var val = document.createElement(tag);

    if(id === undefined){
      var tagId = tagMap.get(tag);
      if(tagId === undefined)
        tagMap.set(tag,0);
      else
        tagMap.set(tag,tagId + 1);
        val.id = tag + tagMap.get(tag);
    }
    else
        val.id = id;

    return val;
  }

  addStyle = function(id, options){
    var tag = document.getElementById(id);
    if(tag === undefined)
      tag = document.querySelector("."+id+"");
    tag.style = options;
  }

  for(var i=0;i<10;i++){
    var tag = createElement("div");
    document.body.appendChild(tag);
    addStyle("div"+i,"border : 1px solid #000ff"+i+";opacity : .3; width : 1"+(i)+"px; height : 6px;");
    //tag2.parentNode.insertBefore(tag2,tag);
  }


}
)(typeof window === 'undefined' ? module.exports : window);
