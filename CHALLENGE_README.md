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

### Specifics:

Kazuma possesses an Area of Effect spell that can defeat all the monsters in time it was applied. But before he can use this spell, he must complete an incantation chant to activate the spell. 
In addition, once he uses the spell, he immediately enters a cooldown state to recover MP.

So, Kazuma can have four possible states in each time tX: 

<pre> Chant, Attack, Recover MP, Defend </pre>

Chant is the pre-requisite for Attack. But Kazuma doesn't need to attack immediately after chanting. He can continue defending until he finds a good opportunity to attack.

In all states other than attack, other adventurers will defeat monsters in the time frame.

If Kazuma chooses to attack, all monsters in a time tX are defeated with AOE spell.

Kazuma's goal is to be an efficient hunter and defeat the highest number of monsters with the least effort.

He is not concerned about monsters missed in defend state because he did not need to spend much effort or mana on defend move. So, as far as he is concerned, defend is a neutral state where he neither gained nor lost anything. 

So, Kazuma measures efficiency as the number of monsters he could defeat by choosing the best time to chant and attack. He wants to attack when the number of monsters is high while chanting when number of monsters are low.

Help Kazuma find the most efficient number of monsters he can defeat in a given expedition!

### Explanation:

For example, consider an input array as 
<pre>
[1,4,5,0,4]
</pre>

You will read this as: <br />
Monster Count in Time t0: 1 <br />
Monster Count in Time t1: 4 <br />
Monster Count in Time t2: 5 <br />
Monster Count in Time t3: 0 <br />
Monster Count in Time t4: 4 <br />

If Kazuma wants to defeat the highest number of monsters he can while minimizing his cost, his ideal move will be to try to maximize the number of monsters he can defeat with attack while trying to minimize the number of monsters he misses while chanting.

For above case, one of his ideal moves would be to:
<pre>
| t0      | t1       | t2                         | t3      | t4    |
| Chant   | Attack   | Recover MP (Cooldown)      | Chant   | Attack|
</pre>

Which would lead him to defeat 8 monsters at the cost of missing one, leading to a "efficient" hunt of (4-1) + (4-0) = 7 monsters



### Submission Method

Expose a `POST` endpoint `/efficient-hunter-kazuma` for verification

Expected request mime-type: `application/json`

Expected response mime-type: `application/json`

Refer to below samples for input and output format:

#### Sample 1

Expected Input:

<pre>
[
    {
      "monsters": [1,4,5,0,4]
    }
]
</pre>

Expected Output:

<pre>
[
    {
        "efficiency": 7
    }
]
</pre>

#### Sample 2

Expected Input:

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

Expected Output:

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
3. Kazuma needs to chant invocation for his attack. 
4. After attack, Kazuma changes to a cooldown state to recover MP. 
5. Once he uses attack, all the monsters at that time will be defeated. 
6. Kazuma measures efficiency as the number of monsters he could defeat by choosing the best time to chant invocation and attack.

### Finally...

####          ( • ̀ω•́ )✧ We Wish You Luck On Your Quest To Your Grand Adventure, Adventurer! ⸜(｡˃ ᵕ ˂)⸝♡ 
