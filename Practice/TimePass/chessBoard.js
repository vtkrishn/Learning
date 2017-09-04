var str = " # # # # ";
var len = str.length;
var f = true;
for(var i=0;i<8;i++){
  if(f)
 console.log(str.substring(0,len-1));
 else
 console.log(str.substring(1,len));
 f=!f;
}
