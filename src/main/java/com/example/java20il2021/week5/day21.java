package com.example.java20il2021.week5;

/**
 *      user
 *        |
 *      app(N0, N1, N2)
 *       |
 *      DB0
 *     *     *     *     *     *     *     *
 *     single - leader
 *      user
 *        |
 *      app(N0, N1, N2)
 *       |          \   \   \
 *      DB0  ->>   DB1  DB2 DB3
 *      write          Read
 *      leader         follower
 *      master         slave
 *
 *      1. Synchronous
 *      2. Asynchronous
 *      3. chain synchronous
 *     *     *     *     *     *     *     *
 *     multi-leader
 *     *      *      *      *      *      *
 *     leaderless
 *          N1
 *      N0      N2(replica1)
 *    N7           N3(replica2)
 *      N6      N4(replica3)
 *          N5
 *   memory  -> SSTable -> sorted string table
 *   Bloom filter(hash1, hash2, hash3)
 *   [][1][][][][][1][][][][][][1]
 *
 *          file7                            file8
 *      /       \       \               /       \      \
 *   file1     file2     file3      file4     file5    file6
 *
 *  hashing :
 *     N0, N1, N2, ... N7, N8=> length = 9
 *     hash(key) % 9 => idx
 *  Cassandra cluster(LWW) :
 *      consistent hashing
 *      1. replica factor = 3
 *      2. read consistency(1 - 3) / write consistency(1 - 3)
 *      2 + 2 = 4 > replica factor
 *      1 + 3 = 4 > replica factor
 *      R + W > replica factor
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    mongodb CP
 *                  mongos  ---->    config server
 *              /      |      \
 *         shard1   shard2    shard3
 *         1 - 100  101-200   201-300
 *
 *         insert hash(id)
 *         insert id
 *         select 100 < id < 300
 *
 *  global 2nd index
 *    *      *      *      *      *      *      *      *      *      *
 *    cache - redis cluster(snapshot + aof)
 *
 *    10k+ hash slot
 *    N0(1 - 5000)master     N1(5001 - 10000)master
 *     /    \                   /   \
 *   N2     N3
 *
 *  Read / Write through
 *              user
 *               |
 *              app
 *              |
 *             cache
 *              |
 *             db
 *
 *  Cache Aside pattern
 *            user
 *             |
 *            app  --  cache
 *             |
 *            db
 *       read ->  check cache
 *                      1. yes -> return
 *                      2. no -> read db, update cache
 *       write -> 1. remove data from cache
 *                2. write data to db
 *
 *
 * tomorrow :
 *      global id
 *      leader election
 *      message queue
 */
