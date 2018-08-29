package com.github.oskardevkappa.plus.commands;

import com.github.oskardevkappa.plus.core.Database;
import com.github.oskardevkappa.plus.entities.CommandGroup;
import com.github.oskardevkappa.plus.entities.CommandSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import org.bson.Document;



/**
 * @author oskar
 * github.com/oskardevkappa/
 * <p>
 * 23.08.2018
 */

public class Test implements ICommand {

    private final Database database;

    public Test(Database database)
    {

        this.database = database;
    }

    @Override
    public void onCommand(GuildMessageReceivedEvent event, TextChannel channel, Member member, String[] args, String label)
    {


    }

    @Override
    public CommandSettings getSettings()
    {
        return new CommandSettings(CommandGroup.OWNER, Permission.MESSAGE_WRITE, "test");
    }

    @Override
    public String getInfo()
    {
        return null;
    }
}
