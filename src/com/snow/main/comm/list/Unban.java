package com.snow.main.comm.list;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import static com.snow.main.util.CommandOption.USERID;

public class Unban {

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("unban")) return;
        if (!event.isFromGuild()) {
            event.getInteraction().deferReply(true).setContent("請在伺服器內使用此指令").queue();
            return;
        }
        if (!event.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.getInteraction().deferReply(true).setContent("請給予踢出成員之權限").queue();
            return;
        }
        event.getGuild().unban((event.getOption(USERID)).getAsString()).queue();
        event.getInteraction().deferReply(true).setContent("unban Successfully").queue();
    }
}
