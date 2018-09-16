package com.github.oskardevkappa.plus.commands.apis;

import com.github.oskardevkappa.plus.commands.ICommand;
import com.github.oskardevkappa.plus.entities.CommandGroup;
import com.github.oskardevkappa.plus.entities.CommandSettings;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;

/**
 * @author oskar
 * github.com/oskardevkappa/
 * <p>
 * 05.09.2018
 */

public class TrumpQuote implements ICommand {

    private final String api_url = "https://api.whatdoestrumpthink.com/api/";
    private final String api_random = "v1/quotes/random/";

    private final String gif = "https://media.giphy.com/media/xTiTnHXbRoaZ1B1Mo8/giphy.gif";

    public TrumpQuote()
    {

    }

    @Override
    public void onCommand(GuildMessageReceivedEvent event, TextChannel channel, Member member, String[] args, String label)
    {

        Request request = new Request.Builder()
                .url(api_url + api_random).build();

        String message = "";

        try
        {
            Response response = new OkHttpClient().newCall(request).execute();

            JSONObject object = new JSONObject(response.body().string());

            message = object.getString("message");


        } catch (IOException e)
        {
            e.printStackTrace();
        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setAuthor("Trump Quote", api_url)
                .setColor(Color.YELLOW)
                .setDescription(message)
                .setImage(gif)
                .setTimestamp(Instant.now());

        channel.sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public CommandSettings getSettings()
    {
        return new CommandSettings(CommandGroup.PUBLIC, Permission.MESSAGE_WRITE, "TrumpQuote", "Trump");
    }

    @Override
    public String getInfo()
    {
        return null;
    }
}
