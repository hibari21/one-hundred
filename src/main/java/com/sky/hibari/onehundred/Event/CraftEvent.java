package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftEvent implements Listener, OneHundredEvent<CraftItemEvent> {

    @Override
    public void process(CraftItemEvent event) {
        HumanEntity Crafter = event.getWhoClicked();
        if(!OneHundred.CraftCountHashMap.containsKey(Crafter)) {
            OneHundred.CraftCountHashMap.put(event.getWhoClicked(), 0);
        }
        OneHundred.CraftCountHashMap.put(Crafter,OneHundred.CraftCountHashMap.get(Crafter) + 1);
        Crafter.sendMessage("クラフト" + OneHundred.CraftCountHashMap.get(Crafter) + "回目");
        if(OneHundred.CraftCountHashMap.get(Crafter) == OneHundred.CraftCount) {
            over(Crafter);
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("クラフト回数が" + OneHundred.CraftCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.CraftCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onCraft(CraftItemEvent event){
        if(OneHundred.Craft){
            process(event);
        }
    }
}
