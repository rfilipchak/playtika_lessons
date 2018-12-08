package com.example.rfilipchak.servicecommon;

import lombok.Value;

@Value
public class Pair<K, V> {
    private K key;
    private V value;
}
