package com.example;

public class JokesProvider {
  static final String jokes[] = {
      "Can a kangaroo jump higher than a house? \n\nOf course, a house doesn’t jump at all.\n",
      "Anton, do you think I’m a bad mother?\n \n My name is Paul.",
      "My wife’s cooking is so bad we usually pray after our food.",
      "I'd like to buy a new boomerang please.\n Also, can you tell me how to throw the old one away?\n",
      "Police officer: \"Can you identify yourself, sir?\"\n \n Driver pulls out his mirror and says: \"Yes, it's me.\"\n",
      "It is so cold outside I saw a politician with his hands in his own pockets.",
      "Pessimist: \"Things just can't get any worse!\" \n \n Optimist: \"Nah, of course they can!\"\n",
      "I wanted to grow my own food but...\n\n I couldn’t get bacon seeds anywhere.\n"
  };

  public static String getJoke() {
    return jokes[(int) Math.floor(Math.random() * (jokes.length - 1))];
  }
}
