package ru.netology;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class PlayerTest {

    @Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya",
    // если добавлена ТОЛЬКО ОДНА ИГРА

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
    public void shouldSumHoursIfGameInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 3;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);

    }

    @Test
    public void shouldSumHoursIfGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");


        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }


    // другие ваши тесты


    @Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya",
    // если добавлено НЕСКОЛЬКО ИГР одного жанра

    public void shouldSumGenreIfSomeGame() {

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Земля", "Аркады");
        Game game3 = store.publishGame("Война", "Аркады");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 4);
        player.play(game2, 6);
        player.play(game3, 12);

        int expected = 4 + 6 + 12;
        int actual = player.sumGenre("Аркады");

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
    }
}

    /*@Test // Суммирует время, проигранныые во все игры жанра "Аркады" игроком "Petya",
          // если добавлено НЕСКОЛЬКО ИГР разных жанров

    public void sumGenreTwoGames() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");
        
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Земля", "Аркады");
        Game game3 = store.publishGame("Юпитер", "Стратегия");

        player.installGame(game1);      
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 6);    
        player.play(game2, 3);
        player.play(game3, 3);

        int expected = 6 + 3;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected,actual);
    }

    @Test // тест №4. Считает количество часов, которое играли в игру, если она УСТАНОВЛЕНА

    public void shouldCountHoursWhenGameInstalled() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");
        
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        player.installGame(game);

        int actual = player.play(game, 3);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test // Выкидывает исключение при попытке сосчитать количество часов,
          // которое играли в игру, если она НЕ УСТАНОВЛЕНА

    public void shouldThrowExceptionWhenGameNotInstalled() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");
        
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertThrows(RuntimeException.class, () -> player.play(game, 3));
    }

    @Test // Выдает игру заданного жанра "Аркады",
          // в которую играли бОльшее количество часов если играли только в игры одного жанра

    public void shouldReturnMostPlayedByGenre() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");
        
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Земля", "Аркады");

        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 3);
        player.play(game2, 5);

        Game[] expected = {game2};
        Game[] actual = player.mostPlayerByGenre("Аркады");

        assertArrayEquals(expected, actual);
    }

    @Test // Выдает игру заданного жанра "Аркады",
          // в которую играли бОльшее количество часов, если добавлены несколько игр разного жанра и играет один игрок

    public void shouldReturnTheMostPopularByGenreWhenSomeGamesOfDifferentGenresArePlayedByTheSamePlayer() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Земля", "Аркады");
        Game game3 = store.publishGame("Юпитер", "Стратегия");


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

        player.play(game1, 4);
        player.play(game2, 6);
        player.play(game3, 15);

        Game[] expected = {game2};
        Game[] actual =  player.mostPlayerByGenre("Аркады");

        assertArrayEquals(expected, actual);
    }

    @Test // Выдает null если в запрашиваемый жанр не играли
          // в которую играли бОльшее количество часов

    public void shouldReturnMostPlayedByGenreIfNoonePlayedThisGenre() {
        
        GameStore store = new GameStore();

        Player player = new Player("Petya");

        
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Юпитер", "Стратегия");

        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 3);
        player.play(game2, 5);

        assertNull(player.mostPlayerByGenre("Квесты"));
    }

    @Test// Выдает игры заданного жанра "Аркады",
         // в которые играли бОльшее количество часов, если добавлены несколько игр одного жанра, играет один игрок
    public  void shouldReturnTheMostPopularByGenreIfThereAreSeveral() {

        GameStore store = new GameStore();

        Player player = new Player("Petya");

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Земля", "Аркады");
        Game game3 = store.publishGame("Юпитер", "Стратегия");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 5);
        player.play(game2, 2);
        player.play(game3, 5);

        Game[] expected = {game1, game3};
        Game[] actual = player.mostPlayerByGenre("Аркады");

        assertArrayEquals(expected, actual);
    }*/



