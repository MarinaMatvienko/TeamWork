package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSomeGamesByOneGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Шахматы", "Аркады");
        Game game3 = store.publishGame("Нарды", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 3);
        player.play(game3, 3);

        int expected = 9;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSomeGamesByAnotherGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Шахматы", "Настольные");
        Game game3 = store.publishGame("Нарды", "Настольные");
        Game game4 = store.publishGame("Карты", "Настольные");
        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 1);
        player.play(game2, 3);
        player.play(game3, 3);
        player.play(game4, 3);

        int expected = 9;
        int actual = player.sumGenre("Настольные");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlaySumHoursIfGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 3;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);

    }

    @Test
    public void shouldPlaySumHoursIfGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");


        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });

    }

    @Test
    public void shouldMostPlayerByGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Petya");
        Player player2 = new Player("Vasya");
        player1.installGame(game);
        player2.installGame(game);


        player1.play(game, 3);
        player2.play(game, 3);

        String expected = "Нетология Баттл Онлайн";
        String actual = player1.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreIfSomeGamesOneGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Карты", "Настольные");
        Game game2 = store.publishGame("Шахматы", "Настольные");
        Game game3 = store.publishGame("Нарды", "Настольные");


        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);


        player.play(game1, 3);
        player.play(game2, 8);
        player.play(game3, 5);


        String expected = "Шахматы";
        String actual = player.mostPlayerByGenre("Настольные");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreIfSomeGamesAnotherGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Карты", "Настольные");
        Game game2 = store.publishGame("Шахматы", "Настольные");
        Game game3 = store.publishGame("Нарды", "Настольные");
        Game game4 = store.publishGame("Формула", "Гонки");
        Game game5 = store.publishGame("Танки", "Гонки");
        Game game6 = store.publishGame("Футбол", "Спорт");


        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.installGame(game5);
        player.installGame(game6);


        player.play(game1, 3);
        player.play(game2, 8);
        player.play(game3, 5);
        player.play(game4, 2);
        player.play(game5, 1);
        player.play(game6, 7);


        String expected = "Шахматы";
        String actual = player.mostPlayerByGenre("Настольные");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerByGenreIfNoGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Карты", "Настольные");
        Game game2 = store.publishGame("Шахматы", "Настольные");
        Game game3 = store.publishGame("Нарды", "Настольные");
        Game game4 = store.publishGame("Формула", "Гонки");
        Game game5 = store.publishGame("Танки", "Гонки");
        Game game6 = store.publishGame("Футбол", "Спорт");


        Player player = new Player("Petya");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.installGame(game5);
        player.installGame(game6);


        player.play(game1, 3);
        player.play(game2, 8);
        player.play(game3, 5);
        player.play(game4, 2);
        player.play(game5, 1);
        player.play(game6, 7);


        String expected = null;
        String actual = player.mostPlayerByGenre("Интеллектуальные");
        assertEquals(expected, actual);
    }
}

