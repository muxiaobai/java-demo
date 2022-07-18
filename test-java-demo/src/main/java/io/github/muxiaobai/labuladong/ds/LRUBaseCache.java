package io.github.muxiaobai.labuladong.ds;


import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 最近使用  最近最少使用算法
 * Least Recently Used
 * HashMap + link 实现  使用基本的内容进行实现
 * @see  java.util.HashMap
 * @author Administrator
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUBaseCache {
    private int size;
    HashMap<Integer, Integer> cache;


    private LRUBaseCache(int capacity) {
        this.size = capacity;
        cache = new LinkedHashMap<>(capacity);

    }

    /**
     * 获取得到val。
     * 没有 key 返回-1
     * 有key 移动原来的key value 到开头
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            //移动顺序
            int value = cache.remove(key);
            cache.put(key, value);
            return cache.get(key);
        }
        return -1;
    }

    /**
     * 保存得到val。
     * 需要看是否满了，不能扩容只有capacity大小，是否有key
     * 有key 直接把原来的key 移除,修改引用 在开头添加新的key value
     * 没有的话 删除最后一个，在开头添加新的key value
     *
     * @param key
     * @return
     */

    public void put(int key, int value) {
        //存在key
        if (cache.containsKey(key)) {
            //移动顺序
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        // 满了
        if (size <= cache.size()) {
            //删除  链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //，添加到最后
        cache.put(key, value);

    }

    public static void main(String[] args) {
        LRUBaseCache lRUCache = new LRUBaseCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}