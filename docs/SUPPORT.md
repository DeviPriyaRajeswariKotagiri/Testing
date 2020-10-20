# Component- Support

## Table of Contents
1. [Deployment Status](#1-deployment-status)
2. [Health Statistics](#2-health-statistics)
3. [How to view Logs](#3-how-to-view-logs)
4. [FAQ](#4-faq)

## 1. Deployment Status
One of the ways to check Deployment status is via CodeFresh. You can use Codefresh to deploy docker images directly to the Kubernetes cluster. You can watch the status of the deployment right from the Codefresh UI.

   
   
## 2. Health Statistics


To check health 
```
~ curl http://localhost:<port>/api/commerce/buildinstruction/actuator/health
```
To check info
```
~ curl http://localhost:<port>/api/commerce/buildinstruction/actuator/info
```

  
## 3. How to view Logs
Logs:
```
kubectl logs orch-build-instruction-service-97bccf6-hjsxj -n commerce -c orch-build-instruction-service -f
```
To check the istio gateway:
```
kubectl -n istio-system get -l app=istio-ingressgateway --no-headers pods -o custom-columns=:metadata.name
```
Port setting local:
```
kubectl -n istio-system port-forward istio-ingressgateway-75d5967d8c-j4j9f 9080:80
```
or
Port checking local:
```
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}') && echo $INGRESS_PORT

```
   
## 4. FAQ

### Question 1
Answer to question 1

### Question 2
Answer to question 2
