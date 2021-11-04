package com.example.java20il2021.week4;

/**
 * stateful / session
 * 	1. /employee -> server
 * 	2. session id -> cookie
 *
 *     loadbalancer(weight,  geo location,  round robin,  random)
 *    /		 |		\
 * node1   node2    node3
 *
 * *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * Rest Api :
 * 	1. Http : method + status code ..
 * 	2. /employee
 * 	3. stateless
 * 	4. json / xml
 * {
 * 	“username”: “xx”,
 * 	“users”: [
 *                                {
 * 					“userId”: 123
 *                },
 *                {
 * 					“userId”: 234
 *                }
 * 			]
 * }
 *
 * *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * status code :
 * 	200 / 201 / 204
 * 	400 / 401 / 403 / 404
 * 	500
 *
 * design rest api for employees
 * 	1. requirements:  create employee / get emp info / get all emp / delete / update employee (idempotent)
 * 	2. create employee
 * 		api  / endpoint :  /employee
 * 		http method :  post
 * 		status code :  200 OK / 201 CREATED / 400 BAD REQUEST / 500 SERVER INTERNAL ERROR
 * 		header :  content-type: json / accept : json
 * 		request body: * 			{
 * 				“name” : “Tom”,
 * 				“department_id” : 123
 * 			}
 * 		response body:
 * 			{
 * 				“id” :..
 * 			}
 *
 * 	3. get employee by id
 * 		api / endpoint : /employee/{id}  @path variable
 * 		http method : get
 * 		status code : 	200 OK / 400 BAD REQUEST / 404 NOT FOUND / 500 SERVER INTERNAL ERROR
 * 		header..
 * 		response body :
 * 			{
 * 				..
 * 			}
 * 	4. get all employee
 * 		api / endpoint : /employee?age=50…..
 * 		http method : get
 * 		status code : ..
 * 		header..
 * 		response body :
 * 			pagination
 * 			{
 * 					“pageCount” : ..
 * 					“pageNumber” : ..
 * 					“totalCount” : ..
 * 					“users”: [
 *                        {
 * 							“userId”: 123
 * 							..
 *                        },
 *                        {
 * 							“userId”: 234
 * 							..
 *                        }
 * 					]
 * 			}
 *
 *
 * *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 * MVC
 * 	model  (db + repository/dao)
 * 	controller (controller + service)
 * 	view (json / html / angular / user interface)
 * Spring MVC
 * 	request -> tomcat -> dispatcherServlet -> handler mapping -> Controller
 * 							 |
 * 				view resolver / http message converter (default Jackson)							|
 * 						 jsp  / json or xml
 *
 *
 * @RestController = @Controller + @ResponseBody
 * public class EmployeeController {
 * 	private final EmployeeService es;
 *
 * 	@Autow    ed
 * 	public EmployeeController(EmployeeService es) {
 * 		this.es =    s;
 * 	}
 *
 * 	@GetMapping(“/employ    ”)
 * 	public ResponseEntity<List<EmployeeDTO>> getAllEmplloyee(@RequestParam..) {
 * 		return new ResponseEntity<>(es.getAllEmployee(..), HttpStatus.    );
 * 	}
 *
 * 	@GetMapping(“/employee/{i    ”)
 * 	public ResponseEntity<EmployeeDTO> getEmplloyeeById(@PathVariable String id) {
 * 		return new ResponseEntity<>(es.getEmployeeById(id), HttpStatus.    );
 * 	}
 *
 * 	@PostMapping(“/employ    ”)
 * 	public ResponseEntity<?> createEmployee(@RequestBody Employee e) {
 * 		return new ResponseEntity<>(es.save(e), HttpStatus.    );
 * 	}
 *
 * 	@ExceptionHandler(.cl    s)
 * 	public ResponseEntity<?> errorResponse() {
 *
 * 	}
 * }
 *
 *
 * @Data
 * class EmployeeResponseDTO {
 * 	private String id;
 * 	private String name;
 * 	private int age;
 * }
 *
 *
 * global exception / advice handler
 * @ControllerAdvice
 *
 *
 *
 *
 * homework
 * 	1. employee + department table
 * 	2. spring boot project + spring data jpa (entitymanager / @Query)
 * 	3. rest api many to many relation
 * 	    /employee
 * 	    /employee/{id}
 * 	    /department
 * 	    /department/{id}
 * 	4. postman
 *
 */