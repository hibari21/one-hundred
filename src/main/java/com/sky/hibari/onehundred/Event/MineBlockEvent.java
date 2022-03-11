package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundredEvent;
import com.sky.hibari.onehundred.OneHundred;
import org.bukkit.GameMode;
import org.bukkit.Statistic;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class MineBlockEvent implements Listener, OneHundredEvent<PlayerStatisticIncrementEvent> {

    @Override
    public void process(PlayerStatisticIncrementEvent event) {
        HumanEntity entity = event.getPlayer();
        Statistic statistic = event.getStatistic();
        if(statistic == Statistic.MINE_BLOCK) {
            if (!OneHundred.MineBlockCountHashMap.containsKey(entity)) {
                OneHundred.MineBlockCountHashMap.put(entity, 0);
            }
            OneHundred.MineBlockCountHashMap.put(entity, OneHundred.MineBlockCountHashMap.get(entity) + 1);
            entity.sendMessage("ブロック破壊" + OneHundred.MineBlockCountHashMap.get(entity) + "回目");
            if (OneHundred.MineBlockCount == OneHundred.MineBlockCountHashMap.get(entity)) {
                over(entity);
            }
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("ブロックを壊した回数が" + OneHundred.MineBlockCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.MineBlockCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onMineBlock(PlayerStatisticIncrementEvent event){
        if(OneHundred.MineBlock){
            process(event);
        }
    }
}
