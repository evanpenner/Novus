package com.fireboyev.discord.novus.commands.games.insults;

import com.fireboyev.discord.novus.commandmanager.GuildCommandExecutor;
import com.fireboyev.discord.novus.filestorage.FileManager;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ViewInsultsCommand implements GuildCommandExecutor {

	@Override
	public void onCommand(Guild guild, User user, Member member, Message message, String[] args, MessageChannel channel,
			MessageReceivedEvent event) {
		StringBuilder builder = new StringBuilder("Guild Insults:\n");
		int count = 1;
		for (String str : FileManager.openGuildFolder(guild).getInsults()) {
			builder.append(count + ": " + str + "\n");
			count++;
		}
		builder.setLength(1900);
		channel.sendMessage(builder.toString());
	}
}
