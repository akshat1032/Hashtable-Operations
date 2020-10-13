package com.capgemini.myhashtable;

public class MyHashMap<K, V> {

	// Field for linked list
	MyLinkedList<K, V> myLinkedList;

	// Initializing the field
	public MyHashMap() {
		this.myLinkedList = new MyLinkedList<>();
	}

	// Method to get value based on key
	public V get(K key) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	// Method to add key, value pair or update value corresponding to existent key
	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			this.myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "MyLinkedList { " + myLinkedList + " }";
	}
}
