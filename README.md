# Allocation algorithm interview question
This question asks the interviewee to implement an algorithm that randomly chooses an element from a list following a given distribution.

## Solutions
Check the branches of this repo. The master branch contains the statement and the rest of them are solutions.

# Sergio's solution
This branch contains Sergio's solution.

The rationale behind it is simple: let S be the sum of the weights of all the instances in the list. We can then assign each instance an interval in [1, S] in such a way that all the numbers in [1, S] belong to exactly one interval, and all these intervals are mutually disjoint and have the same size as the weights of the instance they represent.

For example, if we have three instances with weights [2, 3, 4] we can assign them the following intervals: [1, 2], [3, 5], and [6, 9]. It is not hard to see that a random number chosen in [1, 9] will fall in [1, 2] 2 / 9 of the times, in [3, 5] 1 / 3, and in [6, 9] the remaining 4 / 9.

To test the algorithm we can run the algorithm a big number of times (e.g: 40 million times) and then check that the times each instance are assigned with match with the theoretical probabilities in the first d decimal places.

Another way would be to mock the random number generator to make it return all values in [1, S] and check that each instance is assigned as many times as its weight.
