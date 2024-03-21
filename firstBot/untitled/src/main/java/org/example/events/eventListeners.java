package org.example.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class eventListeners extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message=event.getMessage().getContentRaw();
        if(message.contains("hello") && !event.getAuthor().isBot()){
            event.getChannel().sendMessage("hello "+event.getAuthor().getName()).queue();
        }
    }
}
