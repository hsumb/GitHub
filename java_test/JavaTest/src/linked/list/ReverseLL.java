package linked.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Node {

	int value;
	Node next;

	Node(int value) {
		this.value = value;
		next = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value != other.value)
			return false;
		return true;
	}

}

class LinkedList {

	Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Time complexity:  O(<length of list>)
	// Space complexity:  O(1)

	Node reverseUtil(Node curr, Node prev) {
		if(curr == null) return null;
		if(curr.next == null){
			curr.next = prev;
			return curr;
		}
		Node next = curr.next;
		curr.next = prev;
		return reverseUtil(next, curr);
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public void push(int newValue)
	{
		Node new_Node = new Node(newValue);
		new_Node.next = head;
		head = new_Node;
	}
}

public class ReverseLL{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);

		System.out.println("Original Linked list ");
		list.printList(list.head);
		Node res = list.reverseUtil(list.head, null);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(res);
	}

	@Test
	public void testReverseLL() {
		LinkedList list1 = new LinkedList();
		list1.push(1);
		list1.push(2);
		list1.push(3);
		list1.push(4);
		
		Node actual = list1.reverseUtil(list1.head, null);
		LinkedList list2 = new LinkedList();
		
		list2.push(4);
		list2.push(3);
		list2.push(2);
		list2.push(1);
		Node expected = list2.getHead();
		while((actual.next != null) && (expected.next != null)) {
			assertEquals("failure - not same", expected, actual);
			actual=actual.next;
			expected=expected.next;
		}
	}
}