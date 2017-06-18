public class YourClassNameHere {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        StringBuilder stb = new StringBuilder();
        String str = serialize(node1,stb);
        System.out.println(str);
        Node root = deserialize(str.split(","),0);
    }

  public static String serialize(Node root, StringBuilder stb){
	if(root == null){
		stb.append("X");
		return stb.toString();
	}
	if(stb.toString().length() > 0)
	  stb.append(",");
	stb.append(root.value);
	serialize(root.left,stb);
	serialize(root.right,stb);
	return stb.toString();
}

public static Node deserialize(String[] str, int i){
  if(str == null || str.equals(""))
    return null;
    Node node1 = null;
    if(!str[i].contains("X")){
      node1 = new Node(Integer.valueOf(str[i]));
      node1.left = deserialize(str,i+1);
      node1.right = deserialize(str,i+2);
    }
    else
      node1 = new Node(Integer.valueOf(""+str[i].charAt(0)));

    return node1;
}

    static class Node{
      int value;
      Node left;
      Node right;

      public Node(int data){
        this.value = data;
      }
    }
}
