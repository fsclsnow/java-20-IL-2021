package com.example.java20il2021.week4;

/**
 *  How to secure your web service ?
 *
 *  1. https
 *  2. authentication  -> 401
 *  3. authorization(OAuth2.0)  -> 403
 *  4. sql injection / xml injection
 *  5. CSRF
 *      www.bank.com/account?transferFrom=&transferTo=
 *      <input type=hidden value=token />
 *  6. CORS
 *      client                    server
 *               ->pre-flight
 *  7. DDOS
 *  8. firewall / gateway / subnet
 *  9. encryption
 *  10. password hashing
 *  11. email / phone verification
 *  12. log
 *  13. rate limiter / token bucket
 *  ...
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  JWT - json web token
 *  header.payload.signature
 *  encoding(header.payload.encrypt(header.payload))
 *
 *  header
 *      Authorization = token
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   tomcat(ThreadPool)
 *      request 1 - 1 thread  1 - 1 ThreadLocal
 *
 *   @PreAuthorize("hasRole(Admin)")
 *   method1()
 *
 *   @PreAuthorize("hasRole(Admin)")
 *   method2()
 *    *    *    *    *    *    *    *    *    *    *
 * 	request -> tomcat -> filter1 -> filter2 -> dispatcherServlet -> handler mapping -> Controller
 *
 *   filter1. username password
 *            securityContext = ThreadLocal
 *   filter2. header => token
 *            securityContext = ThreadLocal
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   1. username password authentication filter
 *      a. impl UserDetails(user info)
 *      b. impl UserDetailsService(load user by username)
 *      c. add filter into spring security filter chain
 *   2. jwt token filter
 *      a. get Authorization header from request
 *      b. use jwt library decoding jwt token
 *      c. verify token => add user details into Security Context(Thread local)
 *      d. add filter into spring security filter chain
 *   3. use @PreAuthorize("hasRole(Admin)") on methods
 */