import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	List<Object> list = new ArrayList<>();
	int index = 0;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}

	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return (Integer) list.get(index);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		index++;
		return (Integer) list.get(index - 1);
	}

	@Override
	public boolean hasNext() {
		return index < list.size();
	}
}
// @lc code=end

