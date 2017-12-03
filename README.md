### Steps

1. use `fastjson` to parse the players information
2. find your character (its `login` should be your student id)
3. find the best teammate for your character according to our rules
4. create a merge request, with your best teammate student id (i.e. its `login`) in the message


### Objective

What we want you to learn in this lab:

- Use Maven to manage dependencies.
- Understand the JSON format.
- Use a community software (`fastjson` in this lab) to parse JSON into Java objects instead of writing their own parsers.
- Implement `Player.java` and `PlayerMgr.java`. Complete the code in `App.java`.

### Some details about rules

> 1\. Find the player that has the closest level with you.

Note that closest level is **NOT** necessarily the  **same** level.

For example:

```json
players = [
	{
    "id": 20,
    "login": "103021209",
    "name": "Small Night",
    "profession": "Archer",
    "level": 96
  },
  {
    "id": 5,
    "login": "101033252",
    "name": "Empty Sea",
    "profession": "Archer",
    "level": 95
  },
  {
    "id": 50,
    "login": "103062171",
    "name": "Empty Grass",
    "profession": "Mage",
    "level": 97
  }
]
```

Then the list of users with level closest to `user#20` are `[user#5, user#50]`.

> 2\. If multiple players have the closest level with you. Find the one that has the complementary profession.

One possible case is that there isn't any players with complementary professions in the *closest level list*, if so, please skip this rule and head to the next rule.

Or, if there are more than one platers with complementary profession, please go to rule 3, too.

Complementary professions:

| Your Profession | Complementary Profession |
|:---------------:|:------------------------:|
|    Warrior | Mage |
| Archer     | Thief |
| Thief | Archer     | 
|  Mage |  Warrior | 


### Guidance of the rules

Find a best match teammate with routines:



1. Find the players with levels closest to you and store them in an array named `playersWithClosestLevels`.
	- If there's exactly one player in the array, return the player.
	- Otherwise, go to rule 2.
2. Find the players that complementary profession in `playersWithClosestLevels` and store them in an array named `playersWithClosestLevelsAndComplementaryProfession`.
	- If there's exactly one player in the array, return the player.
	- Otherwise, go to rule 3.
3. Find the player with smallest ID:
	- If `playersWithClosestLevelsAndComplementaryProfession` is not empty, return the player with smallest ID within this array.
	- Otherwise, return the player with smallest ID within `playersWithClosestLevels`.
