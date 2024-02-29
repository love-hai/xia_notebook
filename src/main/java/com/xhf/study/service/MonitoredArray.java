package com.xhf.study.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: MonitoredArray
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/8/12 10:32
 * @updateUser: xiahaifeng
 * @updateDate: 2023/8/12 10:32
 * @updateRemark:
 * @version: v1.0
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
