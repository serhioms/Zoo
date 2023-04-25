package pl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceOfMovesInSpinGame {

    public static class Player {
        String name;
        public Player(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    List<Player> players = Arrays.asList(new Player[]{new Player("A"), new Player("B"), new Player("C"), });

    Random rand = new Random();

    private int spin() {
        return rand.nextInt(5)+1;
    }

    @Test
    public void playOutFirstMove() {
        System.out.println("Play out for first move...");

        int[] playOutBetween = new int[players.size()];
        IntStream.range(0, players.size()).forEach(i -> playOutBetween[i] = i);

        do {
            System.out.println("Round between " + Arrays.stream(playOutBetween).filter(i -> i >= 0).mapToObj(i -> players.get(i).getName()).collect(Collectors.toList()));

            Arrays.stream(playOutBetween).filter(i -> i >= 0).forEach(i -> {
                playOutBetween[i] = spin();
                System.out.println(players.get(i).getName() + " spins " + playOutBetween[i]);
            });

            int max = Arrays.stream(playOutBetween).max().getAsInt();

            for (int i = 0, size = playOutBetween.length; i < size; ++i) {
                playOutBetween[i] = playOutBetween[i] != max ? -1 : i;
            }

        } while (Arrays.stream(playOutBetween).filter(i -> i >= 0).count() != 1);

        System.out.println("playOutBetween: " + Arrays.stream(playOutBetween).mapToObj(i -> i).collect(Collectors.toList()));

        Player firstPlayer = null;

        boolean isBefore = true;
        int indexCorrection = 0;
        for (int i = 0, size = playOutBetween.length, before = 0, after = 0; i < size; ++i) {
            if (playOutBetween[i] >= 0) {
                firstPlayer = players.get(i);
                indexCorrection = size - i - 1;
                isBefore = false;
            }
            playOutBetween[i] = isBefore ? --before : after++;
        }

        System.out.println("playOutBetween: " + Arrays.stream(playOutBetween).mapToObj(i -> i).collect(Collectors.toList()));

        Player[] newplayers = new Player[players.size()];

        if (indexCorrection >= 0) {
            for (int i = 0, size = playOutBetween.length; i < size; ++i) {
                if (playOutBetween[i] < 0) {
                    playOutBetween[i] = indexCorrection - playOutBetween[i];
                }
                newplayers[playOutBetween[i]] = players.get(i);
            }
        }

        System.out.println("playOutBetween: " + Arrays.stream(playOutBetween).mapToObj(i -> i).collect(Collectors.toList()));

        System.out.println("old players: " + players);
        System.out.println("First player: " + firstPlayer.getName());

        players = Arrays.stream(newplayers).collect(Collectors.toList());
        System.out.println("new players: " + players);
    }

}
