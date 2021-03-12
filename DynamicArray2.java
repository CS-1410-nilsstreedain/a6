package a6;

/**
 * A DynamicArray2 behaves like an array of strings, except that it can grow and
 * shrink. It is indexed beginning with zero. When a DynamicArray2 is created,
 * it is empty. Methods are provided to report on the size, add, get, set, and
 * remove elements.
 * 
 * @author Prof. David E. Johnson
 * @author Nils Streedain
 *
 */
public class DynamicArray2 {

	private String[] data; // the backing array
	private int virtualArrayLength; // the number of elements in the dynamic array

	/**
	 * Creates an empty dynamic array with room to grow. (DO NOT modify this
	 * method.)
	 */
	public DynamicArray2() {
		// Start with a few available extra spaces. Do not change this.
		data = new String[8];
		// But the virtual array is empty.
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements.
	 */
	public int size() {
		// This is not the length of the backing array. It is the 
		// number of elements used by the virtual array.
		return virtualArrayLength;
	}

	/**
	 * Appends s to the end of the dynamic array at index this.size().
	 * 
	 * @param s	The string to be added to the end of the dynamic array.
	 */
	public void add(String s) {
		add(size(), s);
	}
	
	/**
	 * Throws an IndexOutOfBoundsException if index is not a valid index
	 * for adding to the dynamic array, otherwise inserts s at index.
	 * Elements can be added from index 0 up to and including this.size().
	 * 
	 * @param index The index for the string s to be placed in.
	 * @param s The string to be placed at index of "index".
	 */
	public void add(int index, String s) {
		if (index < 0 || index > this.size())
			throw new IndexOutOfBoundsException();
		if (data.length <= this.size()) {
			String[] newData = new String[data.length * 2];
			for (int i = 0; i < data.length; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
		for (int i = this.size(); i > index; i--) {
			data[i] = data[i-1];
		}
		data[index] = s;
		virtualArrayLength++;
		// If there is no room for s in data, create a new array
		// that is twice as long as data. Copy the contents of data
		// over to this new array. Set data (the reference to the
		// backing array) to this new array.

		// Shift the items in data at or above index up by one,
		// to make room for s at index index.
		// HINT: Try this on paper first. This is tricky to get right.

		// Add s at index.

		// Update virtualArrayLength.
	}

	/*
	 * Throws an IndexOutOfBoundsException if index is not a valid index
	 * of the dynamic array, otherwise removes the element at index
	 * and shifts the elements after index down one to fill in the gap.
	 * 
	 * @param index The indexed item to be removed from the string.
	 */
	public void remove(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		for (int i = index; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}
		virtualArrayLength--;
	}

	/*
	 * Throws an IndexOutOfBoundsException if index is not a valid index
	 * of the dynamic array, otherwise returns the element at index.
	 * 
	 * @param index The index to be retrieved and returned.
	 * 
	 * @return data[index] Returns the value at index of data.
	 */
	public String get(int index) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();

		return data[index];
	}

	/* Throws an IndexOutOfBoundsException if index is not a valid index
	 * of the dynamic array, otherwise replaces the element at index
	 * with s
	 * 
	 * @param index The index to be set by the method.
	 * @param s The string to be set at the specified index.
	 */
	public void set(int index, String s) {
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		data[index] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int index = 1; index < size(); index++)
			result += ", " + get(index);

		return result + "] backing size: " + data.length;
	}
	
	public static void main(String[] args) {
		// Use the code above to make a DynamicArray2, add items to it
		// at the end and at places in the middle, remove some items, and
		// print out the array after each change to check that your class is
		// working as expected. This does not have to be in the test style we
		// have been using so far, but it should be clear that the code you
		// have hear checks different possibilities in the code above.

		System.out.println("\n-----------------------------------------------------------------------------------------------------");
		System.out.println("\nAdding element to fill array creating a new larger array with the same values(using .add('string'):\n");
		DynamicArray2 myDynamicArray1 = new DynamicArray2();
		myDynamicArray1.add("zero");
		myDynamicArray1.add("one");
		myDynamicArray1.add("two");
		myDynamicArray1.add("three");
		myDynamicArray1.add("four");
		myDynamicArray1.add("five");
		myDynamicArray1.add("six");
		myDynamicArray1.add("seven");
		System.out.println("\tBefore: " + myDynamicArray1);
		myDynamicArray1.add("eight");
		System.out.println("\tAfter:  " + myDynamicArray1);
		
		System.out.println("\nAdding element to first index with .add(0, 'negative one':\n");
		DynamicArray2 myDynamicArray2 = new DynamicArray2();
		myDynamicArray2.add("zero");
		myDynamicArray2.add("one");
		myDynamicArray2.add("two");
		myDynamicArray2.add("three");
		myDynamicArray2.add("four");
		myDynamicArray2.add("five");
		myDynamicArray2.add("six");
		myDynamicArray2.add("seven");
		System.out.println("\tBefore: " + myDynamicArray2);
		myDynamicArray2.add(0, "negative one");
		System.out.println("\tAfter:  " + myDynamicArray2);
		
		System.out.println("\nAdding element to a middle index with .add(6, 'five and a half':\n");
		DynamicArray2 myDynamicArray3 = new DynamicArray2();
		myDynamicArray3.add("zero");
		myDynamicArray3.add("one");
		myDynamicArray3.add("two");
		myDynamicArray3.add("three");
		myDynamicArray3.add("four");
		myDynamicArray3.add("five");
		myDynamicArray3.add("six");
		myDynamicArray3.add("seven");
		System.out.println("\tBefore: " + myDynamicArray3);
		myDynamicArray3.add(6, "five and a half");
		System.out.println("\tAfter:  " + myDynamicArray3);

		System.out.println("\n-----------------------------------------------------------------------------------------------------");
		
		System.out.println("\nRemoving element from dynamic array with .remove(5):\n");
		DynamicArray2 myDynamicArray4 = new DynamicArray2();
		myDynamicArray4.add("zero");
		myDynamicArray4.add("one");
		myDynamicArray4.add("two");
		myDynamicArray4.add("three");
		myDynamicArray4.add("four");
		myDynamicArray4.add("five");
		myDynamicArray4.add("six");
		myDynamicArray4.add("seven");
		System.out.println("\tBefore: " + myDynamicArray4);
		myDynamicArray4.remove(5);
		System.out.println("\tAfter:  " + myDynamicArray4);
		
		System.out.println("\nRemoving first element from dynamic array with .remove(0):\n");
		DynamicArray2 myDynamicArray5 = new DynamicArray2();
		myDynamicArray5.add("zero");
		myDynamicArray5.add("one");
		myDynamicArray5.add("two");
		myDynamicArray5.add("three");
		myDynamicArray5.add("four");
		myDynamicArray5.add("five");
		myDynamicArray5.add("six");
		myDynamicArray5.add("seven");
		System.out.println("\tBefore: " + myDynamicArray5);
		myDynamicArray5.remove(0);
		System.out.println("\tAfter:  " + myDynamicArray5);
		
		System.out.println("\nRemoving last element from dynamic array with .remove(7):\n");
		DynamicArray2 myDynamicArray6 = new DynamicArray2();
		myDynamicArray6.add("zero");
		myDynamicArray6.add("one");
		myDynamicArray6.add("two");
		myDynamicArray6.add("three");
		myDynamicArray6.add("four");
		myDynamicArray6.add("five");
		myDynamicArray6.add("six");
		myDynamicArray6.add("seven");
		System.out.println("\tBefore: " + myDynamicArray6);
		myDynamicArray6.remove(7);
		System.out.println("\tAfter:  " + myDynamicArray6);

		System.out.println("\n-----------------------------------------------------------------------------------------------------");
		
		System.out.println("\nSetting first element from dynamic array with .set(0, 'nothing'):\n");
		DynamicArray2 myDynamicArray7 = new DynamicArray2();
		myDynamicArray7.add("zero");
		myDynamicArray7.add("one");
		myDynamicArray7.add("two");
		myDynamicArray7.add("three");
		myDynamicArray7.add("four");
		myDynamicArray7.add("five");
		myDynamicArray7.add("six");
		myDynamicArray7.add("seven");
		System.out.println("\tBefore: " + myDynamicArray7);
		myDynamicArray7.set(0, "nothing");
		System.out.println("\tAfter:  " + myDynamicArray7);	
		
		System.out.println("\nSetting a middle element from dynamic array with .set(4, 'four'):\n");
		DynamicArray2 myDynamicArray8 = new DynamicArray2();
		myDynamicArray8.add("zero");
		myDynamicArray8.add("one");
		myDynamicArray8.add("two");
		myDynamicArray8.add("three");
		myDynamicArray8.add("for");
		myDynamicArray8.add("five");
		myDynamicArray8.add("six");
		myDynamicArray8.add("seven");
		System.out.println("\tBefore: " + myDynamicArray8);
		myDynamicArray8.set(4, "four");
		System.out.println("\tAfter:  " + myDynamicArray8);
		
		System.out.println("\nSetting last element from dynamic array with .set(7, 'the end'):\n");
		DynamicArray2 myDynamicArray9 = new DynamicArray2();
		myDynamicArray9.add("zero");
		myDynamicArray9.add("one");
		myDynamicArray9.add("two");
		myDynamicArray9.add("three");
		myDynamicArray9.add("four");
		myDynamicArray9.add("five");
		myDynamicArray9.add("six");
		myDynamicArray9.add("seven");
		System.out.println("\tBefore: " + myDynamicArray9);
		myDynamicArray9.set(7, "the end");
		System.out.println("\tAfter:  " + myDynamicArray9);

		System.out.println("\n-----------------------------------------------------------------------------------------------------");
		
		System.out.println("\nGetting various elements from dynamic array with .get():\n");
		DynamicArray2 myDynamicArray10 = new DynamicArray2();
		myDynamicArray10.add("zero");
		myDynamicArray10.add("one");
		myDynamicArray10.add("two");
		myDynamicArray10.add("three");
		myDynamicArray10.add("four");
		myDynamicArray10.add("five");
		myDynamicArray10.add("six");
		myDynamicArray10.add("seven");
		System.out.println("\tdynamicArray: " + myDynamicArray10);
		System.out.println("\tdynamicArray.get(0) is " + myDynamicArray10.get(0));
		System.out.println("\tdynamicArray.get(4) is " + myDynamicArray10.get(4));
		System.out.println("\tdynamicArray.get(7) is " + myDynamicArray10.get(7));
		
		
		
//		DynamicArray2 d = new DynamicArray2();
//		d.add("David");
//		d.add("Joe");
//		d.add("Joe");
//		System.out.println(d);
//		System.out.println(d.get(0));
//		System.out.println(d);
//		d.set(1, "Mary");
//		System.out.println(d.get(1));
//		System.out.println(d);
	}
}
