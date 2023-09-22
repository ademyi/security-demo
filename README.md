# Spring Security Demo

Spring Boot 2.7.x or above, the **WebSecurityConfigurerAdapter** adapter class has been depreciated.

You will need to create the **SecurityFilterChain** bean instead of extending _WebSecurityConfigurerAdapter_.


### Request 1: Accessing Root Endpoint

the root endpoint at http://localhost:8080 was accessed, resulting in a 200 OK response. The response contains the text "Hello World!".

#### Request

```plaintext
http :8080
```

#### Response

HTTP/1.1 200 OK  
Cache-Control: no-cache, no-store, max-age=0, must-revalidate  
Connection: keep-alive  
Content-Length: 12  
Content-Type: text/plain;charset=UTF-8  
Date: Fri, 22 Sep 2023 12:40:20 GMT  
Expires: 0  
Keep-Alive: timeout=60  
Pragma: no-cache  
X-Content-Type-Options: nosniff  
X-Frame-Options: DENY  
X-XSS-Protection: 1; mode=block

---

### Request 2: Unauthorized Access to /user Endpoint

This request attempted to access the /user endpoint without proper authentication. The server responded with a 401 Unauthorized status code and provided a JSON response indicating the error.

#### Request

```plaintext
http :8080/user
```

#### Response

HTTP/1.1 401 Unauthorized  
Cache-Control: no-cache, no-store, max-age=0, must-revalidate  
Connection: keep-alive  
Content-Type: application/json  
Date: Fri, 22 Sep 2023 12:40:30 GMT  
Expires: 0  
Keep-Alive: timeout=60  
Pragma: no-cache  
Set-Cookie: JSESSIONID=E79CABBDCDA2219B6A60C8749E261712; Path=/; HttpOnly  
Transfer-Encoding: chunked  
WWW-Authenticate: Basic realm="Realm"  
X-Content-Type-Options: nosniff  
X-Frame-Options: DENY  
X-XSS-Protection: 1; mode=block

{  
"error": "Unauthorized",  
"path": "/user",  
"status": 401,  
"timestamp": "2023-09-22T12:40:30.072+00:00"  
}

---

### Request 3: Authorized Access to /user Endpoint

This request successfully accessed the /user endpoint with the username user and password password. The server responded with a 200 OK status code and provided a text response with the message "Hello, User!".

#### Request

```plaintext
http -a user:password :8080/user
```

#### Response

HTTP/1.1 200 OK  
Cache-Control: no-cache, no-store, max-age=0, must-revalidate  
Connection: keep-alive  
Content-Length: 12  
Content-Type: text/plain;charset=UTF-8  
Date: Fri, 22 Sep 2023 12:41:38 GMT  
Expires: 0  
Keep-Alive: timeout=60  
Pragma: no-cache  
Set-Cookie: JSESSIONID=5F8F7E055FB591DB715A9EF34ECFEF91; Path=/; HttpOnly  
X-Content-Type-Options: nosniff  
X-Frame-Options: DENY  
X-XSS-Protection: 1; mode=block

Hello, User!

---

### Request 4: Unauthorized Access to /admin Endpoint

In this request, an attempt was made to access the **/admin** endpoint with the username **user** and password **password**. However, the server responded with a **403 Forbidden** status code, indicating that access to this resource is not allowed for the provided credentials. The response includes a JSON object with details about the error.

#### Request

```plaintext
http -a user:password :8080/admin
```

#### Response

HTTP/1.1 403 Forbidden  
Cache-Control: no-cache, no-store, max-age=0, must-revalidate  
Connection: keep-alive  
Content-Type: application/json  
Date: Fri, 22 Sep 2023 12:41:46 GMT  
Expires: 0  
Keep-Alive: timeout=60  
Pragma: no-cache  
Set-Cookie: JSESSIONID=222303A3D94C349674AAAD80FF96503B; Path=/; HttpOnly  
Transfer-Encoding: chunked  
X-Content-Type-Options: nosniff  
X-Frame-Options: DENY  
X-XSS-Protection: 1; mode=block

{  
   "error": "Forbidden",  
   "path": "/admin",  
   "status": 403,  
   "timestamp": "2023-09-22T12:41:46.380+00:00"  
}  
 

---

### Request 5: Authorized Access to /admin Endpoint

In this request, access to the **/admin** endpoint was attempted with the username **admin** and password **password**. The server responded with a **200 OK** status code, indicating that the request was successful. The response contains a simple text message: "Hello, Admin!".

#### Request

```bash
http -a admin:password :8080/admin
```

#### Response

HTTP/1.1 200 OK  
Cache-Control: no-cache, no-store, max-age=0, must-revalidate  
Connection: keep-alive  
Content-Length: 13  
Content-Type: text/plain;charset=UTF-8  
Date: Fri, 22 Sep 2023 12:42:13 GMT  
Expires: 0  
Keep-Alive: timeout=60  
Pragma: no-cache  
Set-Cookie: JSESSIONID=F25CBD911A38424E58547AD311F5F24A; Path=/; HttpOnly  
X-Content-Type-Options: nosniff  
X-Frame-Options: DENY  
X-XSS-Protection: 1; mode=block

Hello, Admin!
```