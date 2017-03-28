String str = "geeksforgeeks";
Set s = new HashSet();
String result = "";
for(int i=0;i<str.length();i++){
    char ch = str.charAt(i);
    if(!s.contains(ch)){
        s.add(ch);
        result = result + ch;
    }
}
System.out.println(result);
