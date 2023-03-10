public class ListFunctions {

    /**
     * Return true if the list is empty.
     *
     * Examples:
     *
     * * isEmpty(makeList()) should return true
     * * isEmpty(makeList(0)) should return false
     *
     * @param list The list.
     * @return True if the list is empty; false otherwise.
     */
    public static boolean isEmpty(ListNode list) {
        if (list == null) {
        	return true;
        }
        return false;
    }

    /**
     * Get the number of elements in the list.
     *
     * Examples:
     *
     * * size(makeList()) should return 0
     * * size(makeList(0, 1)) should return 2
     *
     * @param list The list.
     * @return The size of the list.
     */
    public static int size(ListNode<Integer> list) {
		return sizeHelper(list, 0);
    }
    
	private static int sizeHelper(ListNode<Integer> list, int total) {
		if (list == null) {
			return total;
		}
		else {
			return sizeHelper(list.getRest(), total + 1);
		}
	}

    /**
     * Get the element at the index.
     *
     * The index is assumed to be in range.
     *
     * Examples:
     *
     * * get(makeList(0, 1, 4, 9), 2) should return 4
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The element at the index.
     */
    public static int get(ListNode<Integer> list, int index) {
    	if (index == 0) {
    		return list.getFirst();
    	}
    	else {
    		return get(list.getRest(), index - 1);
    	}
    }
    
    private static ListNode getNode(ListNode<Integer> list, int index) {
    	if (index == 0) {
    		return list;
    	}
    	else {
    		return getNode(list.getRest(), index - 1);
    	}
    }

    /**
     * Get the index of the first occurrence of the element.
     *
     * Examples:
     *
     * * indexOf(makeList(0, 3, 3, 4), 3) should return 1
     *
     * @param list The list
     * @param element The element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int indexOf(ListNode<Integer> list, int element) {
        return indexHelper(list, element, 0);
    }
    
    private static int indexHelper(ListNode<Integer> list, int element, int index) {
    	if (list == null) {
    		return -1;
    	}
    	if (list.getFirst() == element) {
    		return index;
    	}
    	else {
    		return indexHelper(list.getRest(), element, index + 1);
    	}
    }

    /**
     * Get the index of the last occurrence of the element.
     *
     * Examples:
     *
     * * lastIndexOf(makeList(0, 3, 3, 4), 3) should return 2
     *
     * @param list The list
     * @param element The element.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int lastIndexOf(ListNode<Integer> list, int element) {
        return lastIndexHelper(list, element, 0);
    }
    
    private static  int lastIndexHelper(ListNode<Integer> list, int element, int index) {
    	if (list == null) {
    		return -1;
    	}
    	if (list.getFirst() == element && indexOf(list.getRest(), element) == -1) {
    		return index;
    	}
    	else {
    		return lastIndexHelper(list.getRest(), element, index + 1);
    	}
    }

    /**
     * Return true if the two lists are the same.
     *
     * Examples:
     *
     * * equals(makeList(1, 2), makeList(1, 2)) should return true
     * * equals(makeList(1, 2), makeList(1, 1)) should return false
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal; false otherwise.
     */
    public static boolean equals(ListNode list1, ListNode list2) {
        if (isEmpty(list1) && isEmpty(list2)) {
        	return true;
        }
        if (isEmpty(list1) && !isEmpty(list2)) {
        	return false;
        }
        if (!isEmpty(list1) && isEmpty(list2)) {
        	return false;
        }
        if (list1.getFirst() != list2.getFirst()) {
        	return false;
        }
        else {
        	return equals(list1.getRest(), list2.getRest());
        }
    }

    /**
     * Create a new, reversed list.
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode reverse(ListNode list) {
    	return reverseHelper(list.getRest(), list, list);
    }
    
    private static ListNode reverseHelper(ListNode curr, ListNode prev, ListNode head) {
    	if (head == null) {
    		return head;
    	}
    	head.next = null;
    	if (curr.getRest() == null) {
    		head = new ListNode(curr.getFirst(), prev);
    		return head;
    	}
    	return reverseHelper(curr.getRest(), new ListNode(curr.getFirst(), prev), head);
    }

    /**
     * Get the first n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode headList(ListNode list, int n) {
    	return headListHelper(list, list, n - 1);
    }
    
    private static ListNode headListHelper(ListNode head, ListNode list, int n) {
    	if (n == 0) {
    		list.next = null;
    		return head;
    	}
    	else {
    		return headListHelper(head, list.getRest(), n - 1);
    	}
    }
    
    /**
     * Get the last n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode tailList(ListNode list, int n) {
    	int startIndex = size(list) - n;
    	ListNode head = getNode(list, startIndex);
        return tailListHelper(head, head, startIndex);
    }
    
    private static ListNode tailListHelper(ListNode head, ListNode list, int n){
    	if (n == 0) {
    		return head;
    	}
    	else {
    		return tailListHelper(head, list.getRest(), n - 1);
    	}
    }

    /**
     * Get the slice of the list between the start and end indices.
     *
     * start and end are assumed to be between 0 and the size of
     * the list, inclusive, and that start <= end.
     *
     * Examples:
     *
     * * subList(makeList(1, 2, 3, 4), 1, 3) should be equivalent to
     *   makeList(2, 3)
     *
     * @param list The list.
     * @param start The first index to include in the slice.
     * @param end The first index to exclude from the slice.
     * @return The slice of the list between the start and end indices.
     */
    public static ListNode subList(ListNode list, int start, int end) {
        return tailList(headList(list, end), end - start);
    }

    /**
     * Add an element at the end of the list.
     *
     * * add(makeList(1, 2), 3) should be equivalent to makeList(1, 2, 3)
     *
     * @param list The list.
     * @param element The element to add.
     * @return The list with the new element added.
     */
    public static ListNode add(ListNode list, int element) {
    	return addHelper(list, list, element);

    }
    private static ListNode addHelper(ListNode head, ListNode list, int element) {
        if(list.getRest() == null) {
        	list.next = new ListNode(element, null);
        	return head;
        }
        else {
        	return addHelper(head, list.getRest(), element);
        }
    }

    /**
     * Add all of the second list to the end of the first list.
     *
     * * addAll(makeList(1, 2), makeList(3, 4)) should be equivalent to
     *   makeList(1, 2, 3, 4)
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return A new list that combines the two lists.
     */
    public static ListNode addAll(ListNode list1, ListNode list2) {
        return addAllHelper(list1, list1, list2);
    }
    private static ListNode addAllHelper(ListNode head, ListNode list, ListNode list2) {
        if(list.getRest() == null) {
        	list.next = list2;
        	return head;
        }
        else {
        	return addAllHelper(head, list.getRest(), list2);
        }
    }
  
}