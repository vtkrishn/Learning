(function(exports){
    'use strict';

  console.clear();

  var Trie = function(){
    this.child = new TrieNode("");
  }

  var TrieNode = function(value){
    this.kids = new Map();
  };

  var list = [
    "abacus",
    "bar",
    "bart",
    "build",
    "cat",
    "cart"
  ];

  var insert = function(list){
    var trieRoot = new Trie();

    //iterate the list
    list.forEach(function(item){

      //insert into it
      insertIntoTrie(item,trieRoot);
    });

    return trieRoot;
  }

  var insertIntoTrie = function(item,root){
      var current = root;

      //iterate the character of the single word
      for(var i=0;i<item.length;i++){

        //get the character
        var ch = item[i];
        //create a trie node
        var child = new TrieNode(ch);

        //See if the kids contains character
        var value = child.kids.get(ch);

        if(value !== null){
          //get the child to kids value
          child = value;
        }
        else{
          //set the kids value
          child.kids.set(ch, new TrieNode(ch));
        }
        //assign current value
        current = child;
      }
  }

  var search  =function(key,root){
    var current = root;
    var child = null;
    for(var i=0;key.length;i++){
      var ch = key[i];
      var value = current.child.kids.get(ch);
       if(value !== null){
         child = value;
       }
       else{
         return false;
       }
      current = child;
    }
  }

  var root = insert(list);
  var exist = search("bart",root);
  console.log(exist);

})(this)
