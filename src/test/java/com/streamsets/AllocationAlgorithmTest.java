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

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AllocationAlgorithmTest {
  private static final List<Instance> instances = new ArrayList<Instance>() {
    {
      add(new Instance("a", 3));
      add(new Instance("b", 2));
      add(new Instance("c", 4));
    }
  };

  @Test
  public void testAllocationAlgorithm() {
    AllocationAlgorithm allocationAlgorithm = Mockito.spy(new AllocationAlgorithm());
    Map<Instance, Integer> empiricalObservations = new HashMap<>();
    int sumOfShares = instances.stream().mapToInt(Instance::getWeight).sum();
    for(int i = 1; i <= sumOfShares; ++i) {
      Mockito.when(allocationAlgorithm.getRandomPositiveNumber()).thenReturn(i);
      Instance chosenInstance = allocationAlgorithm.selectInstance(instances);
      empiricalObservations.put(
          chosenInstance,
          empiricalObservations.getOrDefault(chosenInstance, 0) + 1
      );
    }
    for(Instance instance: instances) {
      Assert.assertEquals(instance.getWeight(), (int) empiricalObservations.get(instance));
    }
  }

}