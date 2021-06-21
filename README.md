# Allocation algorithm interview question
This question asks the interviewee to implement an algorithm that randomly chooses an element from a list following a given distribution.

# Statement
You are given a list of instances. An instance is a computer resource. Each instance is different to the others in terms of size and computing capabilities.

We want to write a workload balance algorithm which takes that into account. We gave each instance a weight, which is an integer between 1 and 100, and we want to use them as follows:

Suppose we have two instances A and B with weights 3 and 5. The sum of the weights are 8, and we want to choose instance A with probability 3 / 8, and B with probability 5 / 8.

You are given an `Instance` class, write the workload balancing algorithm. It would be nice to also write some tests.

## Solutions
Check the branches of this repo. The master branch contains the statement and the rest of them are solutions.
