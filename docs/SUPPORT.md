# Domain Service - Support

## Table of Contents
1. [Deployment Status](#1-deployment-status)
2. [Health Statistics](#2-health-statistics)
3. [How to view Logs](#3-how-to-view-logs)
4. [FAQ](#4-faq)

## 1. Deployment Status
One of the ways to check Deployment status is via kubectl or CodeFresh .
Steps involved in Deploying an application in local docker-kubernetes environment
1. Package the code -> Go to the project location where project exist and open CLI:
         
```
mvn clean package
```
            
2. Build the docker image using below command:

```
 docker build -t fulfillment-domain-service:v1 -f Dockerfile-local .
```      

3. Install the application in kubernetes environment using helm install command:

```
helm install --name fulfillment-domain-service ./fulfillment-domain-service --values ./fulfillment-domain-service/values-local.yaml --namespace enterprise
```

4. Using below command developer can see the application status:

```         
$ kubectl get pods -A
```
   
   
## 2. Health Statistics
One of the way to view Health Statistics of your application is by adding Spring Boot Actuator module ,it helps you monitor and manage your Spring Boot application by providing production-ready features like health check-up, auditing, metrics gathering, HTTP tracing etc. Please check references for more information .[How to view Health statistics of a Microservice ](https://www.callicoder.com/spring-boot-actuator/)
  
## 3. How to view Logs
Developer can see the application logs using below commands:

```
kubectl logs fulfillment-domain-service-c5f5b7cfc-lwrmf -c fulfillment-domain-service -n enterprise
```

## 4. FAQ


### Question 1: How to check the istio gateway?


#### Answer to question 1:


```
kubectl -n istio-system get -l app=istio-ingressgateway --no-headers pods -o custom-columns=:metadata.name
```


### Question 2: How to expose the container port in local? 


#### Answer to question 2:

```
kubectl -n istio-system port-forward istio-ingressgateway-75d5967d8c-j4j9f 9080:80
```


### Question 3: How to find out the istio-ingressgateway container port, where it run the app in local? 


#### Answer to question 3:


```
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}') && echo $INGRESS_PORT
```
