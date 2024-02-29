package com.xhf.study.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听数组变化
 * @author xiahaifeng
 * @since 2023/8/12 10:32
 */

public class MonitoredArray {
    private List<ArrayChangeListener> listeners = new ArrayList<>();
    private List<String> array = new ArrayList<>();

    public void addListener(ArrayChangeListener listener) {
        listeners.add(listener);
    }

    public void addElement(String element) {
        array.add(element);
        notifyListeners(array.size());
    }

    private void notifyListeners(int newSize) {
        for (ArrayChangeListener listener : listeners) {
            listener.onArrayChanged(newSize);
        }
    }
}
