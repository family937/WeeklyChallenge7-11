import java.util.ArrayList;
import java.util.List;

import Node.Node;

public class Main {
	public static void main(String[] args) {

		Node node5 = new Node(5, null);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);

		Node node10 = new Node(10, node3);
		Node node9 = new Node(9, node10);
		Node node8 = new Node(8, node9);
		Node node7 = new Node(7, node8);
		Node node6 = new Node(6, node7);

		Node intersectionNode = intersection(node6, node1);
		System.out.println("The intersecting node is " + intersectionNode + "\n");

		Node a, b, c, d, e;
		a = new Node(1);
		b = new Node(2);
		c = new Node(3);
		d = new Node(4);
		e = new Node(5);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;

		Node loopStarter = loopDetection(a);

		System.out.println("Starter in loop is " + loopStarter);

	}

	public static Node intersection(Node pair1, Node pair2) {

		while (pair1 != null) {
			Node pointer = pair2;
			while (pointer != null) {
				if (pair1 == pointer) {
					return pointer;
				}
				pointer = pointer.next;
			}
			pair1 = pair1.next;
		}
		return null;
	}

	public static Node loopDetection(Node pointer) {
		Node current = pointer;
		List<Node> container = new ArrayList<>();
		while (current != null) {
			if (container.contains(current)) {
				return current;
			}
			container.add(current);
			current = current.next;
		}
		return null;
	}

}