(function(exports){
    'use strict';

  console.clear();

  var Tree = function(t, h){
    this.type = t;
    this.height = h;
  }

  var Stack = function() {
      this.arr = [];
      this.size = 0;
      this.push = function(value){
        this.arr.unshift(value);
        this.size++;
      };
      this.pop = function(){
        this.arr.shift();
        if(this.size > 0)
          this.size--;
      };
      this.peek = function(){
        return this.arr[0];
      };
      this.empty = function(){
        return (this.size === 0);
      };
    }
  var method = function(str){

   var stack = new Stack();
    for(var i = 0;i<str.length;i++){
      var ch = str.charAt(i);
      if(ch == '0')
        stack.push(new Tree(0,-1));
      else if(ch == '(')
        stack.push(new Tree(1,1));
      else if(ch == ')'){

        var top1 = stack.peek();
        if(top1.type !== 0) return -1;
        stack.pop();

        var top2 = stack.peek();
        if(top2.type !== 0) return -1;
        stack.pop();

        var top3 = stack.peek();
        if(top3.type !== 1) return -1;
        stack.pop();

        stack.push(new Tree(0, 1 + Math.max(top.height, top2.height)));
      }
      else
        return -1;

      if(stack.size == 1){
        var t = stack.peek();
        if(t.type !== 0)
          return t.height;
        else
          return -1;
      }

    }

    return -1;
  };

  var x = method("((00)(0(0(00))))");
  console.log(x);



})(typeof window === 'undefined' ? module.exports : window)
