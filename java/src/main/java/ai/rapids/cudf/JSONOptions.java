/*
 *
 *  Copyright (c) 2019, NVIDIA CORPORATION.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package ai.rapids.cudf;

/**
 * Options for reading in JSON encoded data.
 */
public final class JSONOptions  extends ColumnFilterOptions {

  public static JSONOptions DEFAULT = new JSONOptions(builder());
  private final int rowGuess;

  private JSONOptions(Builder builder) {
    super(builder);
    rowGuess = builder.rowGuess;
  }

  int getRowGuess() {
    return rowGuess;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder  extends ColumnFilterOptions.Builder<JSONOptions.Builder> {
    private int rowGuess = -1;

    /**
     * A guess of how many rows will be loaded.  This is totally optional and only used for
     * estimating the memory usage of loading the data.
     * @param guess the number of rows to be loaded as a guess.
     * @return this for chaining.
     */
    public Builder withRowGuess(int guess) {
      this.rowGuess = guess;
      return this;
    }

    public JSONOptions build() {
      return new JSONOptions(this);
    }
  }
}
