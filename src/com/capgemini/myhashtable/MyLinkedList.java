package com.capgemini.myhashtable;

public class MyLinkedList<K, V> {
	public INode head;
	public INode tail;

	// Initializing the node fields
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Method to append
	public void append(INode myNode) {
		if (this.tail == null) {
			this.tail = myNode;
		}
		if (this.head == null) {
			this.head = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;

		}
	}

	// Method to add to top
	public void add(INode myNode) {
		if (this.tail == null) {
			this.tail = myNode;
		}
		if (this.head == null) {
			this.head = myNode;
		} else {
			INode tempNode = this.head;
			this.head = myNode;
			this.head.setNext(tempNode);
		}
	}

	// Search element and return node
	public INode search(K search) {
		INode tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(search)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}

	// Delete first element of linked list
	public INode pop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	// Delete last element of linked list
	public void popLast() {
		INode tempNode = head;
		while (tempNode.getNext().getNext() != null) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode.setNext(null);
	}

	// Delete a node
	public void delete(INode nodeToDelete) {
		if (nodeToDelete.equals(this.head)) {
			this.pop();
		}
		if (nodeToDelete.equals(this.tail)) {
			this.popLast();
		} else {
			INode tempNode = head;
			while (tempNode.getNext() != nodeToDelete) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(nodeToDelete.getNext());
			nodeToDelete.setNext(null);
		}

	}

	@Override
	public String toString() {
		return "MyLinkedList {" + head + "}";
	}
}
