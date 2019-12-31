package org.csee.bot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class Welcome extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@Nonnull GuildMemberJoinEvent event) {
        Member member = event.getMember();
        Guild server = event.getGuild();

        member.getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage(welcomeEmbed(member, server.getName()).build()).queue();
        });
    }

    private EmbedBuilder welcomeEmbed(Member member, String guildName) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Welcome " + member.getEffectiveName() + " to the " + guildName + "!");
        builder.setDescription("Make sure to put your name/grade in the #role-request channel so we could give you the proper roles!");
        builder.setFooter("Joined on " + member.getTimeJoined());
        builder.setColor(Color.BLUE);
        return builder;
    }
}
