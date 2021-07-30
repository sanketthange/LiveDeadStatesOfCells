# LiveDeadStatesOfCells


Rules:
At each step in time (tick), the following transitions occur:
1. Any live cell with fewer than two live neighbors dies, as if by loneliness.
2. Any live cell with more than three live neighbors dies, as if by overcrowding.
3. Any live cell with two or three live neighbors lives, unchanged, to the next generation.
4. Any dead cell with exactly three live neighbors comes to life.

Console screen after execution:
Enter number of cells in 2D grid: 
25
Enter the all cell elements row by row: 
0 0 0 0 0 0 0 0 1 0 0 0 1 1 0 0 0 0 1 0 0 0 0 0 0
Enter the number of ticks: 
3
Seed system: 
0 0 0 0 0 
0 0 0 1 0 
0 0 1 1 0 
0 0 0 1 0 
0 0 0 0 0 

Next 3 ticks are: 

0 0 0 0 0 
0 0 1 1 0 
0 0 1 1 1 
0 0 1 1 0 
0 0 0 0 0 

0 0 0 0 0 
0 0 1 0 1 
0 1 0 0 1 
0 0 1 0 1 
0 0 0 0 0 

0 0 0 0 0 
0 0 0 1 0 
0 1 1 0 1 
0 0 0 1 0 
0 0 0 0 0 


