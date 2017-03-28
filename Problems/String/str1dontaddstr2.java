String str1= "geeksforgeeks";
String str2= "geeks";
Set s1 = new HashSet();
String result = "";
for(int i=0;i<str2.length();i++){
    char ch = str2.charAt(i);
    if(!s1.contains(ch))
        s1.add(ch);
}
for(int i=0;i<str1.length();i++){
    char ch = str1.charAt(i);
    if(!s1.contains(ch))
        result = result + ch;
}
System.out.println(result);
