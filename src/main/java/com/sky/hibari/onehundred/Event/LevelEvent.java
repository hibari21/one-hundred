package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundred;
import com.sky.hibari.onehundred.OneHundredEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

public class LevelEvent implements Listener, OneHundredEvent<PlayerLevelChangeEvent> {

    @Override
    public void process(PlayerLevelChangeEvent event) {
        HumanEntity player = event.getPlayer();
        if (!OneHundred.LevelTotalHashMap.containsKey(player)) {
            OneHundred.LevelTotalHashMap.put(player, 0);
        }
        OneHundred.LevelTotalHashMap.put(player, OneHundred.LevelTotalHashMap.get(player) + 1);
        player.sendMessage(OneHundred.LevelTotalHashMap.get(player) + "レベル");
        if (OneHundred.LevelTotalHashMap.get(player) == OneHundred.LevelTotal) {
            over(player);
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("累計レベルが" + OneHundred.LevelTotal + "に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.LevelTotalHashMap.put(ent,0);
    }

    @EventHandler
    public void onLevelChange(PlayerLevelChangeEvent event){
        if(OneHundred.Level){
         process(event);
        }
    }
}
