package com.araknoid.katas.beersong;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.iterate;

public class BeerSong
{
  public String verse(int verse)
  {
    if (verse == 2)
    {
      return "2 bottles of beer on the wall, 2 bottles of beer.\n"
          + "Take one down and pass it around, 1 bottle of beer on the wall.\n";
    }
    if (verse == 1)
    {
      return "1 bottle of beer on the wall, 1 bottle of beer.\n"
          + "Take it down and pass it around, no more bottles of beer on the wall.\n";
    }
    if (verse == 0)
    {
      return "No more bottles of beer on the wall, no more bottles of beer.\n"
          + "Go to the store and buy some more, 99 bottles of beer on the wall.";
    }

    return verse + " bottles of beer on the wall, " + verse + " bottles of beer.\n"
        + "Take one down and pass it around, " + (verse - 1) + " bottles of beer on the wall.\n";
  }

  public String verses(int from, int to)
  {
    return iterate(from, i -> i - 1)
        .limit(from - to + 1)
        .mapToObj(this::verse)
        .collect(joining("\n"));
  }
}
