package com.example.demo.config;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 静态全局变量，用于存放信息
 */
public class StaticData {
    public static LinkedList<JSONObject> messageLinkedList = new LinkedList<>();
    public static Queue<JSONObject> messageQueue = new ConcurrentLinkedDeque<>();
}
