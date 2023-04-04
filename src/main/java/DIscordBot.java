import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.Random;

public class DIscordBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDA bot= JDABuilder.createDefault("token")
                .addEventListeners(new DIscordBot())
                .setActivity(Activity.playing("Beerball"))
                .build();
        bot.upsertCommand("roll","Gives a randon number between 1 and 100").queue();

    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Random r= new Random();
        int randomint=r.nextInt(100)+1;
        if (event.getName().equals("roll")){
            event.reply(String.valueOf(randomint)).queue();
        }
    }
}
