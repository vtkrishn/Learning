public class YourClassNameHere {
    public static void main(String[] args) {
      reverse("Vinod");
    }

    public static void reverse(String str){
      if(str.equals(""))
        return;
      reverse(str.substring(1,str.length()));
      System.out.println(str.substring(0,1));
    }
}
