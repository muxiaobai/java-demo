package io.github.muxiaobai.labuladong;

/**
 *
 *
 * 二叉树
 * 二叉搜索树（B树） BST。中序有序    hhh4
 * 平衡
 * 多路搜索树（B-树）多分枝，每一个节点有数据，命中返回 平衡
 * B+树 叶子结点有数据，叶子结点返回
 *
 * mysql InnoDB引擎  2000万条数据  3层B+树
 * 文件系统 一页4k，InnoDB 一页默认16k
 * 一条数据1k   一个int 8bytes   一个指针6bytes
 * ibd 索引 不存数据 只存 键值+指针
 * 16k 叶子结点 一页16条数据 3层 一共多少个节点
 *  一层 只有一页  只有 16条数据
 *      占用空间  索引 + 数据  = 0 + 16k   一页数据 直接存放数据
 *  二层 两页 不算数据存储 只存节点 16*1024/14 = 1170 个节点，每一页16k有1170个节点，1170*16=18720条数据， 大概
 *       占用的空间  索引  + 数据  =  16k(第一层上放1170个节点)  + 1170*16*1k   20M
 *  三层  1170*1170*16 = 21902400 需要查询1-3次页（IO） (第一层 一页 1170个节点 16k  第二层 1170页 每一个1170占16k，第三层 数据层  1170*1170个 16k数据)
 *       占用空间    索引 + 数据    =   (16k+16k*1170)   + 1170*1170*16*1k     20G
 * 如果 索引不是int的话那么 键值就不是8bytes
 *
 * 不根据ID键值查询的话，常用的查询列需要添加索引，那么就会生成该列和主键值的索引。
 *      因此主键列尽量小的话，其它索引文件就会小，那么每一页16k存的节点就会多，会用更少的页存储更多的数据
 *
 * InnoDB参考java   ../java/mysql/InnoDBPageInfo.java
 *
 * https://www.jianshu.com/p/92d15df75027
 * https://www.cnblogs.com/owenma/p/8723465.html
 * https://blog.csdn.net/quitepig/article/details/8041308
 *
 *
 */
public class hhht {

}
