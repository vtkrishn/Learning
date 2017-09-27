(function(exports){
    'use strict';

  console.clear();
  var Power = function(){
    this.seed = 2;
    this.next = function(){
      while(!this.isPower(this.seed)){
        this.seed++;
      }
      return this.seed++;
    };

    this.reset = function(){
      this.seed = 2;
    };

    this.isPower = function(val){
      for (var x = 2; x <= Math.sqrt(val); x++) {
            var p = x;
            while (p <= val) {
                p = p * x;
                if (p == val)
                    return true;
            }
        }
        return false;
    }

  }

  var power = new Power();
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  power.reset();
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
  console.log(power.next());
})(typeof window === 'undefined' ? module.exports : window)
