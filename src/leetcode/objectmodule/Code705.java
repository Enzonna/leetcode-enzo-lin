package leetcode.objectmodule;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Package: leetcode.objectmodule
 * Description: design HashSet - easy
 * Design a HashSet without using any built-in hash table libraries.
 *
 * @Author ENZO
 * @Create 2024年4月22日 16:34
 */

//MyHashSet -> Code705
public class Code705 {
    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    //构造器 初始化底层的LinkedList[]数组，每个数组的元素初始化为一个单独的LinkedList
    //选择 BASE = 769 相对大的质数，避免冲突
    public Code705() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        //判重
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        //offerLast() 添加到数组的最后
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    //hash存储结构的关键就是它的hash实现，也就是里面的常量都hash化
    private static int hash(int key) {
        return key % BASE;
    }
}
