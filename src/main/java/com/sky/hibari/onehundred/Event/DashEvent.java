package com.sky.hibari.onehundred.Event;

import com.sky.hibari.onehundred.OneHundred;
import com.sky.hibari.onehundred.OneHundredEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class DashEvent implements Listener, OneHundredEvent<PlayerToggleSprintEvent> {

    @Override
    public void process(PlayerToggleSprintEvent event) {
        HumanEntity Dasher = event.getPlayer();
        boolean dash = event.isSprinting();
        if(dash) {
            if (!OneHundred.DashCountHashMap.containsKey(Dasher)) {
                OneHundred.DashCountHashMap.put(Dasher, 0);
            }
            OneHundred.DashCountHashMap.put(Dasher, OneHundred.DashCountHashMap.get(Dasher) + 1);
            Dasher.sendMessage("ダッシュ" + OneHundred.DashCountHashMap.get(Dasher) + "回目");
            if (OneHundred.DashCountHashMap.get(Dasher) == OneHundred.DashCount) {
                over(Dasher);
            }
        }
    }

    @Override
    public void over(HumanEntity ent) {
        ent.setHealth(0);
        ent.setGameMode(GameMode.SPECTATOR);
        ent.sendMessage("走った回数回数が" + OneHundred.DashCount + "回に到達しました");
        ent.sendMessage("ゲームモードがスペクテイターモードに変更されます");
        OneHundred.DashCountHashMap.put(ent,0);
    }

    @EventHandler
    public void onDash(PlayerToggleSprintEvent event){
        if(OneHundred.Dash){
            process(event);
        }
    }
}
