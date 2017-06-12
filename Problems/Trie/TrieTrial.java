package javaproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaproject.testing.Hash;

public class TrieInJava {
    public TrieInJava() {
        super();
    }

    public static void main(String[] args){
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abcd");
        t.insert("aa");
        t.insert("abbbaba");
        System.out.println(t.search("abc"));
        System.out.println(t.search("abcd"));
        System.out.println(t.search("aa"));
        System.out.println(t.search("abbbaba"));
        System.out.println(t.search("bab"));
        System.out.println(t.search("abbbaba"));
        System.out.println(t.startsWith("a"));

    }

    static class Trie{
        Map<Character, TrieNode> root;

        public Trie(){
             root = new HashMap<Character,TrieNode>();
        }

        public List<String> startsWith(String str){
            TrieNode child = root.get(str.charAt(0));
            List<String> result = new ArrayList<String>();
            StringBuilder stb = new StringBuilder();
            stb.append(str.charAt(0));
                for(int i=1;i<str.length();i++){
                    char ch = str.charAt(i);
                    if(child != null){
                        Map<Character,TrieNode> map = child.children;
                            if(map.containsKey(ch)){
                                child = map.get(ch);
                                stb.append(ch);
                            }
                        }
                }

                while(!child.isLeaf){
                    Map<Character,TrieNode> k = child.children;
                    for(Map.Entry<Character,TrieNode> e : k.entrySet()){
                        stb.append(e.getKey());
                        child = e.getValue();
                    }
                    result.add(stb.toString());
                }
                return result;
        }

        public boolean search(String str){
            TrieNode child = root.get(str.charAt(0));

                for(int i=1;i<str.length();i++){
                    char ch = str.charAt(i);
                    if(child != null){
                        Map<Character,TrieNode> map = child.children;
                            if(map.containsKey(ch)){
                                child = map.get(ch);
                            }
                            else{
                                return false;
                            }
                        }
                    else{
                        return false;
                    }
                }
                return true;
        }

        public void insert(String str){
            TrieNode child = new TrieNode();
            char c = str.charAt(0);
            if(root.containsKey(c))
                child = root.get(c);
            else
                root.put(c, child);
            for(int i=1;i<str.length();i++){
                Character ch = str.charAt(i);
                Map<Character,TrieNode> map = child.children;
                if(!map.containsKey(ch))
                    map.put(ch, new TrieNode());
                child = map.get(ch);
            }
            child.isLeaf= true;
        }

        class TrieNode{
            Map<Character, TrieNode> children;
            boolean isLeaf = true;

            TrieNode(){
                children = new HashMap<Character,TrieNode>();
            }
        }
    }


}
