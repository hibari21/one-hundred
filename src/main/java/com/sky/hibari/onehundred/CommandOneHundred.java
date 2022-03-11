package com.sky.hibari.onehundred;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class CommandOneHundred implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("one-hundred")){
            if(args.length == 0){
                sender.sendMessage("以下がOneHundredの設定状態です");
                sender.sendMessage("Consume:" + OneHundred.Consume);
                sender.sendMessage("Craft:" + OneHundred.Craft);
                sender.sendMessage("Dash:" + OneHundred.Dash);
                sender.sendMessage("Jump:" + OneHundred.Jump);
                sender.sendMessage("Level:" + OneHundred.Level);
                sender.sendMessage("MineBlock:" + OneHundred.MineBlock);
                sender.sendMessage("MobKill:" + OneHundred.MobKill);
                sender.sendMessage("Sleep:" + OneHundred.Sleep);
                sender.sendMessage("Sneak:" + OneHundred.Sneak);
                return true;
            }else if(args.length == 1){
                    switch (args[0]) {
                        case "Consume":
                            sender.sendMessage(args[0] + "は" + OneHundred.Consume + "に設定されています");
                            return true;
                        case "Craft":
                            sender.sendMessage(args[0] + "は" + OneHundred.Craft + "に設定されています");
                            return true;
                        case "Dash":
                            sender.sendMessage(args[0] + "は" + OneHundred.Dash + "に設定されています");
                            return true;
                        case "Jump":
                            sender.sendMessage(args[0] + "は" + OneHundred.Jump + "に設定されています");
                            return true;
                        case "Level":
                            sender.sendMessage(args[0] + "は" + OneHundred.Level + "に設定されています");
                            return true;
                        case "MineBlock":
                            sender.sendMessage(args[0] + "は" + OneHundred.MineBlock + "に設定されています");
                            return true;
                        case "MobKill":
                            sender.sendMessage(args[0] + "は" + OneHundred.MobKill + "に設定されています");
                            return true;
                        case "Sleep":
                            sender.sendMessage(args[0] + "は" + OneHundred.Sleep + "に設定されています");
                            return true;
                        case "Sneak":
                            sender.sendMessage(args[0] + "は" + OneHundred.Sneak + "に設定されています");
                            return true;
                        default:
                            sender.sendMessage("§4引数が正しくありません");
                            return false;
                }
            }else if(args.length == 2){
                if(args[1].equals("true") ||
                   args[1].equals("false")
                ){
                    switch (args[0]) {
                        case "Consume":
                            OneHundred.Consume = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Consume は" + OneHundred.Consume + "に設定されました");
                            return true;
                        case "Craft":
                            OneHundred.Craft = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Craft は" + OneHundred.Craft + "に設定されました");
                            return true;
                        case "Dash":
                            OneHundred.Dash = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Dash は" + OneHundred.Dash + "に設定されました");
                            return true;
                        case "Jump":
                            OneHundred.Jump = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Jump は" + OneHundred.Jump + "に設定されました");
                            return true;
                        case "Level":
                            OneHundred.Level = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Level は" + OneHundred.Level + "に設定されました");
                            return true;
                        case "MineBlock":
                            OneHundred.MineBlock = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("MineBlock は" + OneHundred.MineBlock + "に設定されました");
                            return true;
                        case "MobKill":
                            OneHundred.MobKill = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("MobKill は" + OneHundred.MobKill + "に設定されました");
                            return true;
                        case "Sleep":
                            OneHundred.Sleep = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Sleep は" + OneHundred.Sleep + "に設定されました");
                            return true;
                        case "Sneak":
                            OneHundred.Sneak = Boolean.parseBoolean(args[1]);
                            sender.sendMessage("Sneak は" + OneHundred.Sneak + "に設定されました");
                            return true;
                        default:
                            sender.sendMessage("§4引数が正しくありません");
                            return false;
                    }
                }else if(Integer.parseInt(args[1]) > -1){
                    switch (args[0]) {
                        case "Consume":
                            OneHundred.ConsumeCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Consume の上限を" + OneHundred.ConsumeCount + "に設定しました");
                            return true;
                        case "Craft":
                            OneHundred.CraftCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Craft の上限を" + OneHundred.CraftCount + "に設定しました");
                            return true;
                        case "Dash":
                            OneHundred.DashCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Dash の上限を" + OneHundred.DashCount + "に設定しました");
                            return true;
                        case "Jump":
                            OneHundred.JumpCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Jump の上限を" + OneHundred.JumpCount + "に設定しました");
                            return true;
                        case "Level":
                            OneHundred.LevelTotal = Integer.parseInt(args[1]);
                            sender.sendMessage("Level の上限を" + OneHundred.LevelTotal + "に設定しました");
                            return true;
                        case "MineBlock":
                            OneHundred.MineBlockCount = Integer.parseInt(args[1]);
                            sender.sendMessage("MineBlockの上限を" + OneHundred.MineBlockCount + "に設定しました");
                            return true;
                        case "MobKill":
                            OneHundred.MobKillCount = Integer.parseInt(args[1]);
                            sender.sendMessage("MobKill の上限を" + OneHundred.MobKillCount + "に設定しました");
                            return true;
                        case "Sleep":
                            OneHundred.SleepCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Sleep の上限を" + OneHundred.SleepCount + "に設定しました");
                            return true;
                        case "Sneak":
                            OneHundred.SneakCount = Integer.parseInt(args[1]);
                            sender.sendMessage("Sneak の上限を" + OneHundred.SneakCount + "に設定しました");
                            return true;
                        default:
                            sender.sendMessage("§4引数が正しくありません");
                            return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("one-hundred")){
            if(args.length == 1) return Arrays.asList("Consume", "Craft","Dash", "Jump", "MineBlock", "MobKill", "Sleep", "Sneak","Level");
            if(args.length == 2) return Arrays.asList("true","false");
        }
        return null;
    }
}
