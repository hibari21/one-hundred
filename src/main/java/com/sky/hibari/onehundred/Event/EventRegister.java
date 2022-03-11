package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventRegister {
    public EventRegister(OneHundred plugin, Listener... listener){
        for(Listener forListener:listener) Bukkit.getServer().getPluginManager().registerEvents(forListener, plugin);
    }
}
