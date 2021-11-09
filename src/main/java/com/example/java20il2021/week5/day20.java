package com.example.java20il2021.week5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.json.JacksonJsonParser;

import java.util.HashMap;
import java.util.Map;

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
//class TDay20 {
//    public static void main(String[] args) {
//        String json = "{\"name\":\"tom\",\"sub\":{\"sub-name\":{\"sub-name22\":\"inner name\"}},\"age\":25, \"sub2\":{\"sub-name2\":\"inner name2\"}}";
//        System.out.println(jsonParse(json, 1));
//    }
//
//    private static Map<String, Object> jsonParse(String json, int idx) {
//        Map<String, Object> map = new HashMap<>();
//        String key = null;
//        for(int l = idx, r = idx; r < json.length(); r++) {
//            char ch = json.charAt(r);
//            if((ch == ',' || ch == ' ') && l == r) {
//                //do nothing
//            } else if(ch == ':') {
//                key = json.substring(l + 1, r - 1);
//                l = r + 1;
//                continue;
//            } else if(ch == '{') {
//                map.put(key, jsonParse(json, r + 1));
//                int cntL = 1;
//                while(cntL > 0 && ++r < json.length()) {
//                    if(json.charAt(r) == '}') cntL--;
//                    else if(json.charAt(r) == '{') cntL++;
//                }
//            } else if(r > 0 && Character.isDigit(ch) && json.charAt(r - 1) == ':') {
//                while(r < json.length() && Character.isDigit(json.charAt(r))) {
//                    r++;
//                }
//                map.put(key, Long.parseLong(json.substring(l, r)));
//            } else if(ch == '"' && key != null) {
//                r++;
//                while(r < json.length() && json.charAt(r) != '"') {
//                    r++;
//                }
//                map.put(key, json.substring(l + 1, r));
//            } else if(ch == '}') {
//                return map;
//            } else {
//                continue;
//            }
//            l = r + 1;
//            key = null;
//        }
//        return map;
//    }
//}