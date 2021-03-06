package com.capgemini.myhashtable;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {

	private final int bucketSize;
	ArrayList<MyLinkedList<K, V>> myBucketArray;

	// Initializing the field and bucket size
	public MyLinkedHashMap() {
		this.bucketSize = 10;
		this.myBucketArray = new ArrayList<>(bucketSize);

		// Creating empty linked list
		for (int index = 0; index < bucketSize; index++) {
			this.myBucketArray.add(null);
		}
	}

	// Method to return value corresponding to key which has an index
	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
			return (myMapNode == null) ? null : myMapNode.getValue();
		}
	}

	// Get index corresponding to key
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % bucketSize;
		return index;
	}

	// Add key, value pair to hash map
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> foundKey = (MyMapNode<K, V>) myLinkedList.search(key);
		if (foundKey == null) {
			foundKey = new MyMapNode<>(key, value);
			myLinkedList.append(foundKey);
		} else {
			foundKey.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap List {" + myBucketArray + "}";
	}

	public MyMapNode remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		} else {
			MyMapNode<K, V> foundKey = (MyMapNode<K, V>) myLinkedList.search(key);
			if (foundKey == null) {
				return null;
			} else {
				myLinkedList.delete(foundKey);
				return foundKey;
			}
		}
	}
}
