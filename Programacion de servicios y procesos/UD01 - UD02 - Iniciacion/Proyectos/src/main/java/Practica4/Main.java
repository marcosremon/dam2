package Practica4;

import javax.print.DocFlavor;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Roulet roulet = new Roulet(50000);
        List<Player> players = new ArrayList<>(Arrays.asList(
             new Player("player1", 1000, "par", 10),
             new Player("player2", 1000, "par", 10),
             new Player("player3", 1000, "par", 10),
             new Player("player4", 1000, "par", 10),
             new Player("player5", 1000, "impar", 10),
             new Player("player6", 1000, "impar", 10),
             new Player("player7", 1000, "impar", 10),
             new Player("player8", 1000, "impar", 10),
             new Player("player9", 1000, "numero", 10),
             new Player("player10", 1000, "numero", 10),
             new Player("player11", 1000, "numero", 10),
             new Player("player12", 1000, "numero", 10)
        ));

        int rouletNumber = roulet.rouletNumber();
        System.out.println("el numero de la rule es: " + rouletNumber);
        System.out.println("---------------------------");

        for (Player player : players) {
            String tipoApuesta = player.getTipoApuestaa();
            if (rouletNumber == 0) {
                player.setCash(player.getCash() - player.getApuesta());
                roulet.setCash(player.getCash() + player.getApuesta());
            } else if (tipoApuesta.equalsIgnoreCase("par")) {
                if (rouletNumber % 2 != 0) {
                    player.setCash(player.getCash() - player.getApuesta());
                    roulet.setCash(roulet.getCash() + player.getApuesta());
                } else {
                    player.setCash(player.getCash() + player.getApuesta() * 2);
                    roulet.setCash(roulet.getCash() - player.getApuesta() * 2);
                }
            } else if (tipoApuesta.equalsIgnoreCase("impar")) {
                if (rouletNumber % 2 == 0) {
                    player.setCash(player.getCash() - player.getApuesta());
                    roulet.setCash(roulet.getCash() + player.getApuesta());
                } else {
                    player.setCash(player.getCash() + player.getApuesta() * 2);
                    roulet.setCash(roulet.getCash() - player.getApuesta() * 2);
                }
            } else if (tipoApuesta.equalsIgnoreCase("numero")) {
                if (rouletNumber != player.apuestaca()) {
                    player.setCash(player.getCash() - player.getApuesta());
                    roulet.setCash(roulet.getCash() + player.getApuesta());
                } else {
                    player.setCash(roulet.getCash() - player.getApuesta() * 36);
                    roulet.setCash(roulet.getCash() + player.getApuesta() * 36);
                }
            }
        }
        System.out.println(roulet.getCash());
        System.out.println("---------------------------");
        players.forEach(player -> System.out.println(player.getCash()));
    }
}
