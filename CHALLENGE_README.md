# The Efficient Monster Hunter Kazuma 👾

### Instructions

Following the revival of Baphomet, the ruler of Endless Maze, monsters have increased in the lands of Faerun.

The Obarskyr of Cormyr have taken upon themselves to reward land and gold to licensed adventurers who can help divert the monsters and aid Cormyr's outstretched military.

Lalati Kazuma is an adventurer who arrived in Cormyr from the lands of Axel and aims to make it big here by joining the monster hunting expedition.

The number of monsters Kazuma faces could be variable in different times since he is a member of an expedition.

It is possible for monsters of other fronts to be in his range in next time sequence.

Similarly, it is possible for others to defeat monsters that are in his range by the next time sequence.

### Explanation:
<pre>
For example, consider Kazuma faced 3 monsters in time t0, 5 monsters in time t1, and 2 monsters in time t2.

Time t0: 3
Time t1: 5
Time t2: 2

We would present this as [3, 5, 2].

</pre>

Kazuma possesses an Area of Effect spell that can defeat all the monsters in time it was applied. But once he uses the spell, he cannot use the spell in the next time sequence and since this move requires a lot of mana, he needs to drink a potion before activating the spell.

So, Kazuma can have four possible states in each time tX: 

<pre> Recover, Attack, Defend, Cooldown </pre>

Recover MP is the pre-requisite for Attack.

In all states other than attack, other adventurers will defeat monsters in the time frame.

If Kazuma chooses to attack, all monsters in a time tX are defeated with AOE spell.

Kazuma's goal is to earn money. To make things simple, let's assume that he needs to defeat an equal number of monsters he missed while in recover state to offset his potion costs. That is, he only takes potion when there is a "profit" to be made.

He is not concerned about monsters missed in defend state because he did not need to spend money on potions on defend move. So, as far as he is concerned, defend is a neutral state where he neither gained nor lost anything. 

So, Kazuma measures efficiency as the number of monsters he could defeat by choosing the best time to recover MP and attack. He wants to attack when the number of monsters is high while recovering MP when number of monsters are low.

Help Kazuma find the most efficient number of monsters he can defeat in a given expedition!

### Explanation:
<pre>
For example, consider an input array as [1,4,5,0,4]

You will read this as:
Monster Count in Time t0: 1
Monster Count in Time t1: 4
Monster Count in Time t2: 5
Monster Count in Time t3: 0 
Monster Count in Time t4: 4

If Kazuma wants to defeat the highest number of monsters he can while minimizing his cost, his ideal move will be to try to maximize the number of monsters he can defeat with attack while trying to minimize the number of monsters he misses while recovering mana.

For above case, one of his ideal moves would be to:

| t0      | t1     | t2     | t3      | t4    |
| Recover | Attack | Defend | Recover | Attack|

Which would lead his to defeat 7 monsters at the cost of missing one, leading to a "profitable" hunt of (4-1) + (4-0) = 7 monsters
</pre>


### Submission Method

Expose a `POST` endpoint `/efficient-hunter-kazuma` for verification

Expected request mime-type: `application/json`

Expected response mime-type: `application/json`


#### Expected Input Sample 1

Every test case will have the following format:

Monster Number

<pre>
[
    {
      "monsters": [1,4,5,0,4]
    }
]
</pre>

#### Expected Output Sample 1

<pre>
[
    {
        "efficiency": 7
    }
]
</pre>

#### Expected Input Sample 2

Every test case will have the following format:

Monster Number

<pre>
[
    {
      "monsters": [1]
    },
    {
      "monsters": [1,100,340,210,1,4,530]
    }
]
</pre>

#### Expected Output Sample 2

<pre>
[
    {
        "efficiency": 0
    },
    {
        "efficiency": 868
    }
]
</pre>

### Summary

1. The end goal for Kazuma is to find the most efficient way to defeat monsters. 
2. The number of monsters is variable at different times. 
3. Kazuma needs to use recover to gather his MP for his attack. 
4. After attack, Kazuma changes to a cooldown state. 
5. Once he uses attack, all the monsters at that time will be defeated. 
6. Kazuma measures efficiency as the number of monsters he could defeat by choosing the best time to recover MP and attack.