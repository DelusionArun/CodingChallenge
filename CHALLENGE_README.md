# The Efficient Monster Hunter Kazuma 👾

### Instructions

Following the revival of Baphomet, the ruler of Endless Maze, monsters have increased in the lands of Faerun.

The Obarskyr of Cormyr have taken upon themselves to reward land and gold to licensed adventurers who can help divert the monsters and aid Cormyr's outstretched military.

Lalati Kazuma is an adventurer who arrived in Cormyr from the lands of Axel and aims to make it big here by joining the monster hunting expedition.

The number of monsters Kazuma faces could be variable in different times since he is a member of an expedition.

It is possible for monsters of other fronts to be in his range in next time sequence.

Similarly, it is possible for others to defeat monsters that are in his range by the next time sequence.

Lucky for him, he possesses a clairvoyant spell that allows him to determine the number of monsters that will appear in each time frame.

### Explanation:
<pre>
For example, consider Kazuma faced 3 monsters in time t0, 5 monsters in time t1, and 2 monsters in time t2.

Time t0: 3
Time t1: 5
Time t2: 2

We would present this as [3, 5, 2].

</pre>

### Specifics: 

Kazuma has an Area of Effect attack that can defeat all the monsters in the time it was applied. But before he can use this attack, he must prepare a transmutation circle in the field to transmute his mana into the attack spell. The circle disappears after the attack. 

The transmutation circle is the pre-requisite for Attack. These circles cannot be stacked (i.e., he must attack before he can draw another circle). But Kazuma doesn't need to attack immediately after drawing the circle. He can move to the backline until he finds a good opportunity to attack. 

After attacking, Kazuma immediately moves back to the rear to recover MP (Mana Points) at t+1, where t is the time of attack. 

Since the transmutation circle needs to be drawn on the frontline, Kazuma has an agreement with other adventurers to protect him while he draws the spell. In exchange, he agrees to pay them a standard fee of 1 gold coin for each monster they defeat in addition to what they receive from Cormyr's military.

Cormyr's military offers 1 gold coin for each monster defeated.

So, Kazuma can have three possible actions in each time tX: 

<pre> Prepare Transmutation Circle, Attack, Move to Rear </pre>

Kazuma joined the hunting expedition with the hope of earning the riches promised by the Obarskyr royal family of Cormyr. Hence, he measures the efficiency of his monster hunts as the amount of gold he earned while on expedition.

Help Kazuma become an efficient monster hunter!

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

If Kazuma wants to be efficient, he will want to earn more gold than he pays the adventurers. That is, he will only want to draw transmutation circle if he believes it to be efficient to attack at a later time frame.

For above case, one of his ideal moves would be to:
<pre>
| t0                             | t1       | t2                           | t3                             | t4     |
| Prepare Transmutation Circle   | Attack   | Move to rear (Cooldown)      | Prepare Transmutation Circle   | Attack |
</pre>

Which would lead him to earn gold coins equivalent to 8 monsters while paying back one gold coin to the adventurers for their protection, leading to an earnings of (4-1) + (4-0) = 7 gold coins


Had the input array instead been
<pre>
[5,4,3,2,1]
</pre>

Then, Kazuma would not have drawn a transmutation circle because it would have cost him more to hire the adventurers to protect him than he could potentially earn. Hence, it would not have been "efficient" for him to do so. His ideal move in this scenario would be to just not go to the frontline.

<pre>
| t0             | t1             | t2                | t3            | t4           |
| Move to rear   | Move to rear   | Move to rear      | Move to rear  | Move to rear |
</pre>

Any other move would lead him to lose more than he gains, so Kazuma would not consider it efficient.

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

1. The end goal for Kazuma is to find the most efficient way to earn money. 
2. The number of monsters is variable at different times. 
3. Kazuma needs to draw a transmutation circle to prepare for his attack. 
4. After attack at time t, Kazuma must immediately retreat to the rear/backline to recover MP at t+1. 
5. Once he uses attack, all the monsters at that time will be defeated. 
6. Kazuma measures efficiency as the amount of gold coins he earned.

### Finally...

####          ( • ̀ω•́ )✧ We Wish You Luck On Your Quest To Your Grand Adventure, Adventurer! ⸜(｡˃ ᵕ ˂)⸝♡ 
