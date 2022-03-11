package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SleepEvent implements Listener, OneHundredEvent<PlayerBedEnterEvent> {

    @Override
    public void process(PlayerBedEnterEvent event) {
            HumanEntity Sleeper = event.getPlayer();
            if (!OneHundred.SleepCountHashMap.containsKey(Sleeper)) {
                OneHundred.SleepCountHashMap.put(Sleeper, 0);
            }
            OneHundred.SleepCountHashMap.put(Sleeper, OneHundred.SleepCountHashMap.get(Sleeper) + 1);
            Sleeper.sendMessage("睡眠" + OneHundred.SleepCountHashMap.get(Sleeper) + "回目");
            if (OneHundred.SleepCountHashMap.get(Sleeper) == OneHundred.SleepCount) {
                over(Sleeper);
            }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("睡眠回数が" + OneHundred.SleepCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.SleepCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent event){
        if(OneHundred.Sleep) {
            process(event);
        }
    }
}
