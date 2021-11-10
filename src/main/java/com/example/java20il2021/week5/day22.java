package com.example.java20il2021.week5;


/**
 *  *      global id
 *  *      leader election
 *  *      message queue
 *         global transaction
 *
 *   db mvcc (mysql -> tx_id, roll_pointer, row_id)
 *   global id / co-relation id
 *      1. uuid
 *      2. db1(0, +3),  db2(1, +3),  db3(2, +3)
 *      3. snowflake
 *         [timestamp][machine_id][serial id]
 *    *    *    *    *    *    *    *    *    *    *
 *    Raft
 *    follower - candidate - leader
 *     *     *     *     *     *     *     *     *    *
 *   message queue (server) Asynchronous
 *   server1(producer) -> server2(queue) -> server3(consumer) -> queue -> notification service
 *   ----
 *   pros
 *      1. Asynchronous process(user exp)
 *      2. more requests
 *   ----
 *   queue model
 *   publisher - subscriber model
 *   ----
 *   SQS : queue (visibility timeout)
 *   SNS : pub - sub
 *
 *   SNS --> SQS1  ->  notification -> email
 *       --> SQS2  ->  service -> db
 *       --> SQS3
 *   ----
 *   kafka vs rabbit mq
 *
 *   producer -> broker1(server)  -> consumer
 *               broker2(server)
 *
 *   broker1:
 *      partition1 *leader  (offset)
 *      partition2 *follower
 *   broker2:
 *      partition1 *follower
 *      partition2 *leader
 *
 *   consumer group1 [consumer1(pull partition1),  consumer2(pull partition2), consumer3(backup)]
 *   consumer group2 [consumer1(pull partition2),  consumer2(pull partition1), consumer3(backup)]
 *   ----
 *   db + mq tx
 *   request -> server1 - queue -..
 *                 |
 *                db
 *       1. save to db + commit db tx
 *       2. send msg to kafka + commit kafka tx
 *
 *       1. send msg to kafka + commit kafka tx
 *       2. save to db + commit db tx
 *  CDC -> change data capture pattern -> eventually consistency
 *       1. save to db emp table
 *          save to db msg table
 *          commit
 *
 *       request -> server1
 *                 |
 *                db   <-> monitor service -> message queue  - consumer(idempotent)
 *                                                               |
 *                                                            cache(processed msg id)
 *   ----
 *   global transaction
 *
 *              service1
 *             /        \
 *          db1         db2
 *   SAGA
 *          -> service1 -> queue -> service2  -> queue.. -> success response
 *                 |                    |
 *                db1                  db2
 *                |                     |
 *            service1  <- queue <- compensation msg
 *
 *   2PC
 *              coordinator
 *              /       \
 *          service1   service2
 *            |           |
 *          db1          db2
 *
 *
 * @ControllerAdvice
 *
 */