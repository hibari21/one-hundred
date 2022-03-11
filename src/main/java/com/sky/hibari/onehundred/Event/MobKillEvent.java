package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class MobKillEvent implements Listener, OneHundredEvent<PlayerStatisticIncrementEvent> {
    @Override
    public void process(PlayerStatisticIncrementEvent event) {
        HumanEntity entity = event.getPlayer();
        Statistic statistic = event.getStatistic();
        if(statistic == Statistic.MOB_KILLS) {
            if (!OneHundred.MobKillCountHashMap.containsKey(entity)) {
                OneHundred.MobKillCountHashMap.put(entity, 0);
            }
            OneHundred.MobKillCountHashMap.put(entity, OneHundred.MobKillCountHashMap.get(entity) + 1);
            entity.sendMessage("殺戮" + OneHundred.MobKillCountHashMap.get(entity) + "回目");
            if (OneHundred.MobKillCount == OneHundred.MobKillCountHashMap.get(entity)) {
                over(entity);
            }
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("Mobを殺した回数が" + OneHundred.MobKillCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.MobKillCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onMobKill(PlayerStatisticIncrementEvent event){
        if(OneHundred.MobKill){
            process(event);
        }
    }
}
