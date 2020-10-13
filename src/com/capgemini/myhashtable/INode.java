package com.capgemini.myhashtable;

public interface INode<K, V> {
	K getKey();

	void setKey(K key);

	V getValue();

	void setValue(V value);

	INode getNext();

	void setNext(INode next);
}
