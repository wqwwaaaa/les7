package ru.demo;
import java.util.Objects;

public class Practicum {
    public static void main(String[] args) {
        Song theRockBandSong = new Song("Popular Song", "The Rock Band", "John Doe");
        Song johnDoeSong = new Song("Popular Song", "The Rock Band", "John Doe");

        Song rapSong = new Song("A song about a hard life", "Popular Rapper", "Popular Rapper");

        Song richardRoeSong = new Song("A song about a hard life", "Popular Rapper", "Richard Roe");

        // проверяем рефлексивность
        boolean check0 = false;
        if (johnDoeSong.equals(johnDoeSong)) {
            check0 = true;
        }

        // проверяем симметричность
        boolean check1 = false;
        if (theRockBandSong.equals(johnDoeSong) &&
                johnDoeSong.equals((Object) theRockBandSong)) {
            check1 = true;
        }

        // проверяем на неравенство объекту другого класса
        boolean check2 = false;
        if (!rapSong.equals(42)) {
            check2 = true;
        }

        // проверяем на неравенство пустой ссылке
        boolean check3 = false;
        if (!theRockBandSong.equals(null)) {
            check3 = true;
        }

        // проверяем на правильное сравнение объектов одного класса
        boolean check4 = true;
        if (richardRoeSong.equals(johnDoeSong)) {
            check4 = false;
        }

        // проверяем транзитивность
        boolean check5 = false;
        Song popularSong = new Song("Popular Song", "The Rock Band", "John Doe");
        if (popularSong.equals(theRockBandSong) && theRockBandSong.equals(johnDoeSong)
                && popularSong.equals(johnDoeSong)) {
            check5 = true;
        }

        // проверяем согласованность
        boolean check6 = true;
        boolean result = rapSong.equals(richardRoeSong);
        for (int i = 0; i < 10; i++) {
            if (rapSong.equals(richardRoeSong) != result) {
                check6 = false;
            }
        }

        if (check0 && check1 && check2 &&
                check3 && check4 && check5 && check6) {
            System.out.println("Поздравляем! Метод equals реализован верно.");
        } else {
            System.out.println("Что-то здесь не так. Подумайте над реализацией ещё немного.");
        }
    }
}


class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Song song = (Song) obj;

        return Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(songwriter, song.songwriter);

    }
}





