package com.araknoid.katas.beersong;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.iterate;

public class BeerSong
{
  public String verse(int number)
  {
    return capitalize(quantity(number)) + " " + container(number) + " of beer on the wall, " + quantity(number) + " " + container(number) + " of beer.\n"
        + action(number) +", " + quantity(number - 1) + " " + container(number - 1) + " of beer on the wall.\n";
  }

  private String action(int number) {
    if(number == 0)
      return "Go to the store and buy some more";

    return "Take " + pronoun(number) + " down and pass it around";
  }

  private String capitalize(String string) {
    return string.substring(0,1).toUpperCase()+string.substring(1);
  }

  private String quantity(int number) {
    if (number == 0)
      return "no more";
    if(number == -1)
      return "99";

    return number+"";
  }

  private String pronoun(int number) {
    if(number == 1)
      return "it";

    return "one";
  }

  private String container(int number)
  {
    if (number == 1)
      return "bottle";
    return "bottles";
  }

  public String verses(int from, int to)
  {
    return iterate(from, i -> i - 1)
        .limit(from - to + 1)
        .mapToObj(this::verse)
        .collect(joining("\n"));
  }
}
