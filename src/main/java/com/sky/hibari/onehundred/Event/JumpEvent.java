package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class JumpEvent implements Listener, OneHundredEvent<PlayerStatisticIncrementEvent> {

    @Override
    public void process(PlayerStatisticIncrementEvent event) {
        HumanEntity entity = event.getPlayer();
        Statistic statistic = event.getStatistic();
        if(statistic == Statistic.JUMP) {
            if (!OneHundred.JumpCountHashMap.containsKey(entity)) {
                OneHundred.JumpCountHashMap.put(entity, 0);
            }
            OneHundred.JumpCountHashMap.put(entity, OneHundred.JumpCountHashMap.get(entity) + 1);
            entity.sendMessage("ジャンプ" + OneHundred.JumpCountHashMap.get(entity) + "回目");
            if (OneHundred.JumpCount == OneHundred.JumpCountHashMap.get(entity)) {
                over(entity);
            }
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("ジャンプ回数が" + OneHundred.JumpCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.JumpCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onJump(PlayerStatisticIncrementEvent event){
        if(OneHundred.Jump){
            process(event);
        }
    }
}
