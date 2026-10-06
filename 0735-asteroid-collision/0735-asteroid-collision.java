/** 
Each number represents an asteroid:
- Its absolute value is its size. For example, -5 has size 5.
- A positive number moves right; a negative number moves left.
- Asteroids moving in the same direction never collide.
- Asteroids collide only when a right-moving asteroid is to the left of a left-moving one. The smaller one explodes; if they’re the same size, both explode.
The goal is to return the asteroids that remain after all collisions. 


Each asteroid is pushed once and removed at most once, so the time complexity is O(n) and the extra space is O(n).

*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {         // takes the input array and returns an array of the surviving asteroids.

    int[] stack = new int[asteroids.length];    // Creates an array to use as a stack.
    int size = 0;                             // Tracks how many asteroids are currently in the stack. The top asteroid is at stack[size - 1].

    for(int asteroid: asteroids){             // Processes each asteroid from left to right.
        boolean jeevit = true;                // Assumes the current asteroid survives until a collision proves otherwise.

        while(jeevit && asteroid < 0 && size > 0 && stack[size -1] > 0 ){             // Collision tab hi sakta hai jab left me chalega to uske mandatory hai ki negative value ho aur ek cheejh stack’s top asteroid moves right.

        int top = stack[size - 1];     // Gets the right-moving asteroid that might collide with the current one.

        if(top < -asteroid){           // if top value is smaller than -asteroid value , explode it
            size--;                    // Removes the exploded stack asteroid , The current asteroid may now collide with the next asteroid in the stack, so the loop continues.

        }else if(top == -asteroid){       // checks , if both asteroids have the same size. also explode it
            size--;
            jeevit = false;               // The current asteroid also explodes, so it must not be added to the stack.

        }else{
            jeevit = false;              // means the asteroid on top of the stack is bigger than the current asteroid.So jeevit = false marks the current asteroid (-5) as destroyed.
        }

        }

        if(jeevit){                         // If the current asteroid survived all possible collisions, add it to the stack.
            stack[size++] = asteroid;       // Stores the asteroid at the next free spot, then increases size.

        }

    }

    return java.util.Arrays.copyOf(stack , size);   // Returns just the occupied part of the stack. The stack array may have unused spaces at the end.
        
    }
}