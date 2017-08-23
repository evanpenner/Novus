package com.fireboyev.discord.novus.commands.bot;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.fireboyev.discord.novus.commandmanager.CommandExecutor;
import com.fireboyev.discord.novus.util.Bot;
import com.fireboyev.discord.novus.util.ImageBuilder;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class ImageCommand implements CommandExecutor {

	@Override
	public void onCommand(Guild guild, User user, Member member, Message message, String[] args, MessageChannel channel,
			GuildMessageReceivedEvent event) {
		if (Bot.IsFire(member)) {
			File file = new File("foo.jpg");
			try {
				ImageIO.write(ImageBuilder.buildImage(user), "JPEG", file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			channel.sendFile(file, null).queue();

		}
	}

}