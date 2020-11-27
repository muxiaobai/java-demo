package io.github.muxiaobai.labuladong.ds;


import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 最频繁使用  最不经常使用算法
 * Least Frequently  Used
 * topK 问题
 *
 * @author Administrator
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LFUCache {
    private int size;
    /**
     * key value
     */
    HashMap<Integer, Integer> cache;
    /**
     * key frequent
     */
    HashMap<Integer, Integer> keyFre;

    /**
     * fre  key
     */
    HashMap<Integer, LinkedHashSet<Integer>> freKey;


    private LFUCache(int capacity) {
        this.size = capacity;
        cache = new HashMap<>(capacity);
        keyFre = new HashMap<>();
        freKey = new HashMap<>();
    }

    /**
     * 获取得到val。
     * 没有 key 返回-1
     * 有key 修改key 的访问次数
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (size == 0) {
            return -1;
        }

        if (cache.containsKey(key)) {
            updateFre(key);
            return cache.get(key);
        }
        return -1;
    }

    private void updateFre(int key) {
        //修改频次
        int fre = keyFre.get(key);
        keyFre.put(key, fre + 1);
        //当前频次，删除key
        LinkedHashSet keys = freKey.get(fre);
        keys.remove(key);
        freKey.put(fre, keys);
        //下一频次 添加key
        LinkedHashSet keys2 = freKey.get(fre + 1);
        if (keys2 == null) {
            keys2 = new LinkedHashSet<>();
        }
        keys2.add(key);
        freKey.put(fre + 1, keys2);
    }

    /**
     * 保存得到val。
     * 需要看是否满了，不能扩容只有capacity大小，是否有key
     * 有key 直接把原来的key 移除,修改引用 在开头添加新的key value
     * 没有的话 删除使用最少的一个，有频次相同的删除最久未使用的那个，在开头添加新的key value
     *
     * @param key
     * @return
     */

    public void put(int key, int value) {
        if (size == 0) {
            return;
        }
        //存在key，更新数据value,更新fre频次
        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateFre(key);
            return;
        }
        // 满了，删除
        if (size <= cache.size()) {
            //删除   key 判断是哪一个key
            deleteFre(getDeleteKey());
        }
        //，添加 不存在的key
        saveFre(key, value);

    }

    /**
     * 要删除的key
     *
     * @return
     */
    private int getDeleteKey() {
        int key = 0;
        for (int i = 0; i < freKey.size(); i++) {
            LinkedHashSet<Integer> keys = freKey.get(i);
            if (keys == null || keys.isEmpty()) {
                continue;
            }
            //获取当前频次对应的所有key
            //LinkedHashSet<Integer> 不会重复 可以获取最后一个key，这个key则是最长时间没有访问的
            key = keys.iterator().next();
            break;
        }
        return key;
    }

    private void deleteFre(int key) {
        //移除缓存
        cache.remove(key);
        //移除key频次，频次置为0
        int fre = keyFre.get(key);
        keyFre.put(key, 0);

        LinkedHashSet<Integer> keys = freKey.get(fre);

        if (keys == null) {
            keys = new LinkedHashSet<>();
        }
        //当前频次，删除key
        keys.remove(key);
        freKey.put(fre, keys);
    }

    private void saveFre(int key, int value) {
        //添加缓存
        cache.put(key, value);
        //添加key频次
        keyFre.put(key, 0);

        LinkedHashSet<Integer> keys = freKey.get(0);

        if (keys == null) {
            keys = new LinkedHashSet<>();
        }
        //当前0频次，添加
        keys.add(key);
        freKey.put(0, keys);
    }

    public static void main(String[] args) {
        LFUCache LFUCache = new LFUCache(3);
        LFUCache.put(1, 1); // 缓存是 {1=1}
        LFUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        LFUCache.get(1);    // 返回 1
        System.out.println(LFUCache.cache + ":" + LFUCache.keyFre + ":" + LFUCache.freKey);
        LFUCache.put(3, 3); // 缓存是 {3=3，1=1, 2=2}
        LFUCache.get(2);    // 返回 2
        System.out.println(LFUCache.cache + ":" + LFUCache.keyFre + ":" + LFUCache.freKey);
        LFUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4，2=2, 1=1}
        LFUCache.get(1);    // 返回 1
        LFUCache.get(3);    // 返回 -1
        LFUCache.get(4);    // 返回 4
        System.out.println(LFUCache.cache + ":" + LFUCache.keyFre + ":" + LFUCache.freKey);


    }
}