package com.sky.hibari.onehundred;

import org.bukkit.entity.HumanEntity;

public interface OneHundredEvent<T> {
    void process(T event);
    void over(HumanEntity ent);
}
