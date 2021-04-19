/*
 * Copyright 2021 StreamSets Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.streamsets;

import java.util.List;
import java.util.Random;

public class AllocationAlgorithm {

  private final Random random = new Random();

  /**
   * Select an instance from a list using the weights as probabilities. So, if the input is a list of instance with
   * weights [3, 2, 4] then we will choose these instances with probabilities 1 / 3, 2 / 9, and 4 / 9 respectively.
   * The algorithm returns null only if the list is empty
   * @param instances List of instances
   * @return Instance or null
   */
  public Instance selectInstance(List<Instance> instances) {
    if(!instances.isEmpty()) {
      int sumOfWeights = instances.stream().mapToInt(Instance::getWeight).sum();
      int chosenNumber = getRandomPositiveNumber() % sumOfWeights + 1;
      int currentWeight = 1;
      for(Instance instance: instances) {
        int nextWeight = currentWeight + instance.getWeight();
        if(chosenNumber >= currentWeight && chosenNumber < nextWeight) {
          return instance;
        }
        currentWeight = nextWeight;
      }
    }
    return null;
  }

  int getRandomPositiveNumber() {
    return Math.abs(random.nextInt());
  }

  public AllocationAlgorithm() {

  }

  /**
   * Returns the random number generator object of the algorithm
   * @return Random
   */
  public Random getRandom() {
    return random;
  }

}
