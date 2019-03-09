# GuessNum

A simple guessing number game by JAVA

GameDemo:  The current server can only establish connection with one client. So it is a single player game.

           Data processing in server.
           
Rule: 
1. The game is to guess the target number, which is a 5-digit number(Leading zero is possible). The first one
   who guess the correct number will win.

2. When guessing a number, The server will return two number. Fisrt one represents that how many numbers in the
   right place, and second one represents that how many number is correct but in wrong place.
   
   Example:   66274(Token)
              66472    -- return   3r2d
              99999    -- return   0r0d
              47266    -- return   0r5d

Upcoming update:
1. GUI Version.
2. Try to use JSON to handle message.
3. multiple player online Version.
4. Using UDP to instead of TCP/IP transmission(Optional).
