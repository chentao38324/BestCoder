package com.bestcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chentao on 16-4-2.
 */
public class 统计难题1251trie树实现 {

    private int SIZE = 26;

    // 字典树的根
    private TrieNode root;

    // 初始化字典树
    统计难题1251trie树实现() {
        root = new TrieNode();
    }

    // 字典树节点
    private class TrieNode {

        // 有多少单词通过这个节点,即节点字符出现的次数
        private int num;
        // 所有的儿子节点
        private TrieNode[] son;
        // 是不是最后一个节点
        private boolean isEnd;
        // 节点的值
        private char val;

        TrieNode() {
            num = 1;
            son = new TrieNode[SIZE];
            isEnd = false;

        }
    }

    // 建立字典树
    public void insert(String str) {

        // 在字典树中插入一个单词
        if (str == null || str.length() == 0) {
            return;
        }

        TrieNode node = root;
        char[] letters = str.toCharArray();

        for (int i = 0, len = str.length(); i < len; i++) {

            int pos = letters[i] - 'a';

            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } else {
                node.son[pos].num++;
            }

            node = node.son[pos];
        }
        node.isEnd = true;

    }

    // 计算单词前缀的数量
    public int countPrefix(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            return -1;
        }

        TrieNode node = root;
        char[] letters = prefix.toCharArray();

        for (int i = 0, len = prefix.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                return 0;
            } else {
                node = node.son[pos];
            }
        }

        return node.num;

    }

    // 在字典树中查找一个完全匹配的单词.
    public boolean has(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        TrieNode node = root;
        char[] letters = str.toCharArray();

        for (int i = 0, len = str.length(); i < len; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }

        return node.isEnd;
    }

    // 前序遍历字典树.
    public void preTraverse(TrieNode node) {

        if (node != null) {

//            System.out.print(node.val + "-");

            for (TrieNode child : node.son) {
                preTraverse(child);
            }

        }

    }

    public TrieNode getRoot() {
        return this.root;
    }

    public static void main(String[] args) {

        统计难题1251trie树实现 tree = new 统计难题1251trie树实现();
        Scanner in = new Scanner(System.in);
        List<String> strs  = new ArrayList<>();
        int i = 0;
        //收集单词
        while (in.hasNext()) {
            String word = in.nextLine();
            if (!"".equals(word)) {
                strs.add(i++, word);
            }else break;
        }

        for (String str : strs) {
            tree.insert(str);
        }

//        System.out.println("判断blogchong是否为树枝:"+tree.has("blogchong"));
//        System.out.print("先序遍历字典树:");
        tree.preTraverse(tree.getRoot());
//        System.out.println();

        while (in.hasNext()) {
            String pre = in.nextLine();
            int num = tree.countPrefix(pre);
            System.out.println(num);
        }

    }
}