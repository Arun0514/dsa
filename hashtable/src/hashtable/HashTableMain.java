package hashtable;

import java.util.Hashtable;
import java.util.LinkedList;

import hashtable.HashTable.Pair;

class HashTable {
	class Pair {
		private int key;
		private String value;

		public Pair(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}

	}

	private int slots=10;
	private LinkedList<Pair>[] table;

	public HashTable() {
		
		table = new LinkedList[slots];
		for (int i = 0; i < slots; i++) {
			table[i] = new LinkedList<Pair>();
		}
	}

	public void add(int key, String value) {
		// get slot number using hash function
		int slot = Hash(key);
		// get linked list associated with that slot number
		LinkedList<Pair> bucket = table[slot];
		// search the pair by using key in linked list
		//if key already present replace old value with new one and return
		for (Pair pair : bucket) {
			if (key == pair.key) {
				pair.value=value;
				return ;
			}
		}
		//else create new pair and add it to bucket;
		Pair pair=new Pair(key, value);
		bucket.add(pair);
		System.out.println("added "+get(key));
		
	}

	public String get(int key) {
		// get slot number using hash function
		int slot = Hash(key);
		// get linked list associated with that slot number
		LinkedList<Pair> bucket = table[slot];
		// search the pair by using key in linked list
		for (Pair pair : bucket) {
			if (key == pair.key) {
				return pair.value;
			}
		}
		return null;
	}

	private int Hash(int key) {
		// TODO Auto-generated method stub
		return key % slots;
	}

}

public class HashTableMain {

	public static void main(String[] args) {
		HashTable ht=new HashTable();
        ht.add(11, "suraj");
        ht.add(22, "dhiraj");
        ht.add(25, "akash");
        ht.add(19, "arun");
        ht.add(11, "vishal");
        System.out.println(ht.get(11));
	}

}
