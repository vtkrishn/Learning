String exampleString = "vinod";
char[] c = new char[exampleString.length()];
InputStream stream = new ByteArrayInputStream(exampleString.getBytes());
for(int i=0;i<c.length;i++){
    c[i] = (char)stream.read();
    System.out.println(c[i]);
}
