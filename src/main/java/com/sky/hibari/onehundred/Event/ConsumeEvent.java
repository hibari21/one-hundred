package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ConsumeEvent implements Listener, OneHundredEvent<PlayerItemConsumeEvent> {

    @Override
    public void process(PlayerItemConsumeEvent event) {
        HumanEntity Consumer = event.getPlayer();
        if(!OneHundred.ConsumeCountHashMap.containsKey(Consumer)) {
            OneHundred.ConsumeCountHashMap.put(Consumer, 0);
        }
        OneHundred.ConsumeCountHashMap.put(Consumer,OneHundred.ConsumeCountHashMap.get(Consumer) + 1);
        Consumer.sendMessage("食事" + OneHundred.ConsumeCountHashMap.get(Consumer) + "回目");
        if(OneHundred.ConsumeCountHashMap.get(Consumer) == OneHundred.ConsumeCount) {
            over(Consumer);
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("食事回数が" + OneHundred.ConsumeCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.ConsumeCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        if(OneHundred.Consume){
            process(event);
        }
    }
}
