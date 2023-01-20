package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {
        List<Game> games = new ArrayList<>();
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayTimeIfMapContainsKey() {
        Map<String, Integer> map = new HashMap<>();
        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);

        map.put("anya49", 1);
        store.addPlayTime("anya49", 4);
        Integer expected = 5;
        Integer actual = map.get("anya49");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldAddPlayTimeIfMapNotContainsKey() {
        Map<String, Integer> map = new HashMap<>();
        GameStore store = new GameStore();
        Game game = new Game ("Нетология Баттл Онлайн", "Аркады", store);
        store.publishGame ("Нетология Баттл Онлайн", "Аркады");
        map.put("anya49", 1);
        store.addPlayTime("tima", 4);
        Integer expected = 4;
        Integer actual = map.get("tima");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindBestPlayer(){
        GameStore store = new GameStore();
        Map<String, Integer> playedTime = new HashMap<>();
        playedTime.put("anya49", 3);
        playedTime.put("Vova", 4);
        playedTime.put("Anton", 5);
        playedTime.put("Polya", 6);
        playedTime.put("Marina", 7);

        store.getMostPlayer();

        String expected = "Marina";
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldgetSumPlayedTime(){
        GameStore store = new GameStore();
        Map<String, Integer> playedTime = new HashMap<>();
        playedTime.put("anya49", 3);
        playedTime.put("Vova", 4);
        playedTime.put("Anton", 5);
        playedTime.put("Polya", 6);
        playedTime.put("Marina", 7);

        store.getSumPlayedTime();
        Integer expected = 25;
        Integer actual = store.getSumPlayedTime();
        Assertions.assertEquals(expected, actual);

    }
}
