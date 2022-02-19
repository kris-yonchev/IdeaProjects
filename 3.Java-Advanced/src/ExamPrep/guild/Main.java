package ExamPrep.guild;

public class Main {
    public static void main(String[] args) {
        Guild guild = new Guild("Weekend Raiders", 20);

        Player player = new Player("Mark", "Rogue");

        System.out.println(player);

        guild.addPlayer(player);

        System.out.println(guild.count());

        System.out.println(guild.removePlayer("Gosho"));

        Player player1 = new Player("Pep", "Warrior");
        Player player2 = new Player("Lizzy", "Priest");
        Player player3 = new Player("Mike", "Rogue");
        Player player4 = new Player("Marlin", "Mage");

        player2.setDescription("Best healer EU");

        guild.addPlayer(player1);
        guild.addPlayer(player2);
        guild.addPlayer(player3);
        guild.addPlayer(player4);

        guild.promotePlayer("Lizzy");

        System.out.println(guild.removePlayer("Pep"));

        Player[] kickedPlayers = guild.kickPlayersByClass("Rogue");
        for (Player kickedP : kickedPlayers) {
            System.out.print(kickedP.getName() + " ");
        }
        System.out.println();

        System.out.println(guild.report());

    }

}
