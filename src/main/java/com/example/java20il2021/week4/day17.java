package com.example.java20il2021.week4;


/**
 *  https://www.domain.com/,,, <-> DNS
 *      public ip
 *
 *  u1 public ip 1 + port
 *                          ->   public ip 2 + port
 *  u2 public ip 1 + port
 *
 *  connection = source ip + port + destination ip + port
 *
 *   u1  private ip + port
 *                             ->       NAT(ip pool)      ->   public ip 2 + port
 *   u2  private ip + port
 *
 *   u1 private ip1 + port1 <=> public ip1 + port1  <-> server ip1 + port1
 *   u2 private ip2 + port1 <=> public ip1 + port2  <-> server ip1 + port1
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Application layer :
 *  Presentation layer: ssl / tls /ssh
 *  Session layer   : socket
 *  Transport layer : tcp / udp     tcp header + [data]
 *  Network layer   : ip            ip header + tcp header + port + [http data]
 *  Data link layer : mac address
 *  Physical layer  : cable
 *
 *
 *  socket => build connection => thread pool
 *      t1 get connection
 *          parse data
 *          calculate
 *          send response
 *
 *
 *  certification + RSA(public key + private key)
 *  client(public key)   <->   server(private key)
 *
 *
 *  client                           server
 *                -> say hi
 *         <-certificate + public key
 *             -> [random string]
 *             <- hash value
 *          generate symmetric key
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Http
 *      1. http method
 *         get (no request body)
 *         head (no response body)
 *         post : create
 *         delete :
 *         put : update resource
 *         patch : partial updating
 *      2. status code
 *         200 : success
 *         400 : client error
 *         500 : server error
 *      3. http header
 *
 *
 * tomorrow:
 *      1:30pm cdt
 *      session
 *      rest api design
 *      spring MVC
 *      filter vs interceptor
 */