package com.sky.hibari.onehundred;

import com.sky.hibari.onehundred.Event.*;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class OneHundred extends JavaPlugin {

    public static HashMap<HumanEntity,Integer> CraftCountHashMap = new HashMap<>();
    public static int CraftCount = 100;
    public static boolean Craft = false;
    public static HashMap<HumanEntity,Integer> ConsumeCountHashMap = new HashMap<>();
    public static int ConsumeCount = 100;
    public static boolean Consume = false;
    public static HashMap<HumanEntity,Integer> SleepCountHashMap = new HashMap<>();
    public static int SleepCount = 100;
    public static boolean Sleep = false;
    public static HashMap<HumanEntity,Integer> JumpCountHashMap = new HashMap<>();
    public static int JumpCount = 100;
    public static boolean Jump = false;
    public static HashMap<HumanEntity,Integer> MobKillCountHashMap = new HashMap<>();
    public static int MobKillCount = 100;
    public static boolean MobKill = false;
    public static HashMap<HumanEntity,Integer> MineBlockCountHashMap = new HashMap<>();
    public static int MineBlockCount = 100;
    public static boolean MineBlock = false;
    public static HashMap<HumanEntity,Integer> SneakCountHashMap = new HashMap<>();
    public static int SneakCount = 100;
    public static boolean Sneak = false;
    public static HashMap<HumanEntity,Integer> LevelTotalHashMap = new HashMap<>();
    public static int LevelTotal = 100;
    public static boolean Level = false;
    public static HashMap<HumanEntity,Integer> DashCountHashMap = new HashMap<>();
    public static int DashCount = 100;
    public static boolean Dash = false;



    @Override
    public void onEnable() {
        // Plugin startup logic
        new EventRegister(this,
                new ConsumeEvent(),
                new CraftEvent(),
                new JumpEvent(),
                new MineBlockEvent(),
                new MobKillEvent(),
                new SleepEvent(),
                new SneakEvent(),
                new LevelEvent(),
                new DashEvent()
        );
        getCommand("one-hundred").setExecutor(new CommandOneHundred());
    }
}
