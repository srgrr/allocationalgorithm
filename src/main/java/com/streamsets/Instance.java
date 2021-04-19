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

/**
 * Representation of an instance
 */
public class Instance {

  private String id;

  private int weight;

  public Instance(String id, int weight) {
    this.id = id;
    this.weight = weight;
  }

  /**
   * Returns the identifier of the instance
   * @return String
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the identifier of the instance
   * @param id String
   * @return Instance
   */
  public Instance setId(String id) {
    this.id = id;
    return this;
  }

  /**
   * Return the weight of the instance
   * @return Int
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Set the weight of the instance
   * @param weight Int
   * @return Instance
   */
  public Instance setWeight(int weight) {
    this.weight = weight;
    return this;
  }
}
