package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {
	ListNode returnedNode, finalAddedNode , head;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;

		while(l1 != null || l2 != null){

			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;

			int sum = x + y + carry;
			carry = sum/10;

			finalAddedNode = new ListNode(sum%10);

			finalAddedNode.next = returnedNode;
			returnedNode = finalAddedNode;

			l1= l1 !=null ? l1.next : l1;
			l2= l2 !=null ? l2.next : l2;
		}

		if(carry>0){
			finalAddedNode = new ListNode(carry);
			finalAddedNode.next = returnedNode;
			returnedNode = finalAddedNode;

		}

		return reverse(returnedNode,null);
	}
	ListNode reverse(ListNode curr, ListNode prev) {

		/* If last node mark it head*/
		if (curr.next == null) {
			head = curr;

			/* Update next to prev node */
			curr.next = prev;

			return head;
		}

		/* Save curr->next node for recursive call */
		ListNode next1 = curr.next;

		/* and update next ..*/
		curr.next = prev;

		reverse(next1, curr);
		return head;
	}

}

class MainClass {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for(int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for(int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode l1 = stringToListNode(line);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);

			ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}
}