package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManager;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.example.events.eventListeners;

public class Bot {
    private final Dotenv config;
    private final ShardManager shardManager;

    public Dotenv getConfig() {
        return config;
    }

    public Bot(){
        config=Dotenv.configure().load();
        String token=config.get("TOKEN");
        DefaultShardManagerBuilder builder=DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT,GatewayIntent.GUILD_MEMBERS);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL) ;
        builder.addEventListeners(new eventListeners());
        shardManager= builder.build();
    }

    public ShardManager getSharedManager() {
        return shardManager;
    }
}