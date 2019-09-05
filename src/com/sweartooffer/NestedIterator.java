package com.sweartooffer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList){

        if (nestedList == null) return;

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.offer(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }

    }

    @Override
    public Integer next() {
        return list.poll();
    }

    @Override
    public boolean hasNext() {
        return list.size() > 0;
    }


    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}
