package com.vtkrishn.dfs;

import java.util.Deque;
import java.util.LinkedList;

import com.vtkrishn.common.TreeNode;

public class ConvertArrayToBST {

	
	
	public static void main(String[] args) {
	
		int[] arr = {-10, 3, 0 , 5, 9};
		Deque<TreeNode> stack = new LinkedList>TreeNode>();
		stack.push(new TreeNode(0));
		
		int start = arr[0];
		int end = arr.length;
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int mid = (end - start)/2;
			node.val = mid;
			if(mid-1 < node.val) {
				stack.push(node.left);
			}
			
			if(node.right != null) {
				stack.push(node.right);
			}
			
			
		}
	}
	
	
}
