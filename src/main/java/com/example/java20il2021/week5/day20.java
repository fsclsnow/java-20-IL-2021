package com.example.java20il2021.week5;

/**
 * monolithic server
 *
 *            loadbalancer
 *       /      |       \       \
 *     N0      N1       N2      N3
 *
 *
 *      vertical scaling vs horizontal scaling
 *
 * microservice
 *                                 user
 *                               gateway     <---> security service  - DB3
 *                                  |
 *                         order service(N0, N1, N2) (log agent)
 *                          |                 \
 *      inventory service(N0, N1, N2)      payment service(N0, N1, N2) (log agent)
 *                  |                               |
 *                DB1                              DB2
 *
 *      log service
 *      service registration / discovery service : http://inventory-service/search
 *      config service
 *
 *   pros:
 *      1. fail tolerance
 *      2. test / team / deploy
 *      3. scalability + message queue + request volume
 *   difficulties:
 *      1. consistency :
 *              a. local cache (sticky session / global cache)
 *              b. database global transaction (2PC / SAGA)
 *      2. log : splunk / log service
 *              a. global unique id (UUID / 64 digit number / database primary key)
 *      3. security issue
 *      4. message queue :
 *              a. unique message
 *              b. database + mq transaction
 *      5. service ip address
 *              a. service discovery
 *              b. client-side loadbalancer
 *      6. config service
 */