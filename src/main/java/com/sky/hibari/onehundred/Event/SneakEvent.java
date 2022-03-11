package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundred;
import com.sky.hibari.onehundred.OneHundredEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakEvent implements Listener, OneHundredEvent<PlayerToggleSneakEvent> {

    @Override
    public void process(PlayerToggleSneakEvent event) {
        HumanEntity Sneaker = event.getPlayer();
        boolean sneak = event.isSneaking();
        if(sneak) {
            if (!OneHundred.SneakCountHashMap.containsKey(Sneaker)) {
                OneHundred.SneakCountHashMap.put(Sneaker, 0);
            }
            OneHundred.SneakCountHashMap.put(Sneaker, OneHundred.SneakCountHashMap.get(Sneaker) + 1);
            Sneaker.sendMessage("スニーク" + OneHundred.SneakCountHashMap.get(Sneaker) + "回目");
            if (OneHundred.SneakCountHashMap.get(Sneaker) == OneHundred.SneakCount) {
                over(Sneaker);
            }
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("スニーク回数が" + OneHundred.SneakCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.SneakCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event){
        if(OneHundred.Sneak){
            process(event);
        }
    }
}
