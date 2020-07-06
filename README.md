
<?xml version='1.0' encoding='utf-8' ?><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/><base href="file:/C:/Users/B008760/log/test2/spring-boot-security-jwt/"/><title>README</title><style type="text/css">* {
	 font-family:  Arial, Helvetica, sans-serif;
}

h1 {
	font-size: 120%;
	font-weight: bold;
	color: #172f47;
}

h2 {
	font-size: 110%;
	font-weight: bold;
	color: #172f47;
}

h3 {
	font-size: 105%;
	font-weight: bold;
	color: #172f47;
}

h4 {
	font-weight: bold;
	color: #172f47;
}

h5 {
	font-size: 90%;
	font-weight: bold;
	color: #172f47;
}

h6 {
	font-size: 80%;
	font-weight: bold;
	color: #172f47;
}

b {
	font-weight: bold;
}

strong {
	font-weight: bold;
}

i {
	font-style: italic;
}

cite {
	font-style: italic;
}

em {
	font-style: italic;
}

mark {
	background-color:yellow;
}

var {
	font-style: italic;
}

dfn {
	font-style: italic;
}

code {
	font-family: monospace;
	color:#4444CC;
}

pre {
	font-family: monospace;
}

/* Java stack traces
pre.javaStackTrace {
	font-family: monospace;
}
*/

/* sections beginning with -- Error Details --
pre.eclipseErrorDetails {
	font-family: monospace;
}
*/
 
ins {
	text-decoration: underline;
}

del {
	text-decoration: line-through;
}

sup {
	font-size: smaller;
	vertical-align: super;
}

a {
	text-decoration: underline;
	color: blue;
}

sup a {
	text-decoration: none;
}

sub {
	font-size: smaller;
	vertical-align: sub;
}

dt {
	font-weight: bold;
}

blockquote {
	color: rgb(38, 86, 145);
}

tt {
	font-family: monospace;	
}

q {
	color: rgb(38, 86, 145);
}

h1.editorPreview, h2.editorPreview, h3.editorPreview, h4.editorPreview {
  padding-bottom: 0.3em;
  font-size: 1.75em;
  border-bottom: 1px solid #eee;
}

pre.editorPreview {
  padding: 16px;
  overflow: auto;
  line-height: 1.45;
  background-color: #f7f7f7;
  border-radius: 3px;
}
  
table.editorPreview {
  border-collapse: collapse;
  border-spacing: 0;
  border-color: grey;
}
  
tr.editorPreview td.editorPreview {
  border:1px solid #ddd;
  padding: 6px 13px;
}

tr.editorPreview th.editorPreview {
  border:1px solid #ddd;
  padding: 6px 13px;
  background-color: #f0f0f0;
}</style></head><body><h1 id="spring-boot-security-jwt" class="editorPreview">Spring-Boot-Security-Jwt</h1><p class="editorPreview">Project using Spring Boot + Security + JWT for REST endpoints authentication / authorization.</p><h2 id="about-the-example" class="editorPreview">About the example</h2><ul class="editorPreview"><li class="editorPreview">Spring Boot 1.5.4.RELEASE</li><li class="editorPreview">Sprign Framework 4.3.9.RELEASE</li><li class="editorPreview">Spring Security 4.2.3.RELEASE</li><li class="editorPreview">Tomcat Embed 8.5.15</li><li class="editorPreview">Joda DateTime 2.9.9</li></ul><h2 id="login" class="editorPreview">Login</h2><p class="editorPreview">You can login using two ways:</p><p class="editorPreview">1 - Calling the endpoint /login in LoginController<br/>
    Format: JSON
<code>`</code> 
{ 
  "username" : "user"
  "password" : "test123"
}
<code>`</code>
2 - Calling the endpoint /loginForm that SpringSecurity offers and we config in WebSecurityConfig class.<br/> 
    Format: x-www-form-urlencoded (Form submit, for example)</p><p class="editorPreview">The success response is the following:
<code>`</code>
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaHIiLCJyb2xlIjoiQURNSU4iLCJleHAiOjE1MDcxMDg3MjJ9.-fkoAQ-u8zHQBE4OgayRtJOpSTaEEyaL1bbPRt-bRNUy<em>qarcA8zs</em>BQ4aIh8n4FcQ3eZbK8HzOHZ5JzX08Yhg<br/>
<code>`</code><br/>
In case of any error during authentication:
<code>`</code>
401 Unauthorized
<code>`</code></p><h2 id="authenticated-url-s" class="editorPreview">Authenticated URL's</h2><p class="editorPreview">This URL's can only be reached if the user is authenticated (token is valid in the HEADER)</p><p class="editorPreview">Header:
<code>`</code>
  Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiaHIiLCJyb2xlIjoiQURNSU4iLCJleHAiOjE1MDcxMDg3MjJ9.-fkoAQ-u8zHQBE4OgayRtJOpSTaEEyaL1bbPRt-bRNUy<em>qarcA8zs</em>BQ4aIh8n4FcQ3eZbK8HzOHZ5JzX08Yhg
<code>`</code></p><p class="editorPreview">Endpoints Available:</p><p class="editorPreview"><code>http://localhost:8080/api/hello/admin</code> (GET) <br/>
<code>http://localhost:8080/api/hello/user</code> (GET) <br/>
<code>http://localhost:8080/api/me</code> (POST) <br/>
<code>http://localhost:8080/api/user</code> (POST) <br/></p><h2 id="running-the-example" class="editorPreview">Running the Example</h2><p class="editorPreview">This project contains an Embedded maven. 
In a terminal, navigate to the project folder and run:</p><p class="editorPreview">On Linux:
<code>`</code>
./mvnw clean spring-boot:run
<code>`</code>
On Windows
<code>`</code>
mvnw.cmd clean spring-boot:run
<code>`</code></p><p class="editorPreview">Then, you can login:</p><p class="editorPreview"><code>http://localhost:8080/login</code><br/>
<code>http://localhost:8080/loginForm</code></p><p class="editorPreview">Try any of the combinations:</p><ul class="editorPreview"><li class="editorPreview">User role: user/test123</li><li class="editorPreview">Admin role: admin/test123</li></ul><p class="editorPreview">They are configured in WebSecurityConfig.java:</p><pre class="editorPreview"><code class="editorPreview">    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        //Default users to grant access
        authenticationManagerBuilder
            .inMemoryAuthentication()
            .withUser("user").password("test123").authorities("USER").and()
            .withUser("admin").password("test123").authorities("ADMIN");

        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
    }</code></pre></body></html>
