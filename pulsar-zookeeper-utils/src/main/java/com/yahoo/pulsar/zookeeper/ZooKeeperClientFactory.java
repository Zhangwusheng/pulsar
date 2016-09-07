/**
 * Copyright 2016 Yahoo Inc.
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
package com.yahoo.pulsar.zookeeper;

import java.util.concurrent.CompletableFuture;

import org.apache.zookeeper.ZooKeeper;

public interface ZooKeeperClientFactory {
    enum SessionType {
        /**
         * Create a normal ZK session that requires a valid quorum
         */
        ReadWrite,

        /**
         * Create a ZK session that allow the client to stay connected (in read only mode) to a ZK server that has lost
         * the quorum
         */
        AllowReadOnly,
    }

    /**
     * Return a future yielding a connected ZooKeeper client
     *
     * @param conf
     * @return
     */
    CompletableFuture<ZooKeeper> create(String serverList, SessionType sessionType, int zkSessionTimeoutMillis);
}