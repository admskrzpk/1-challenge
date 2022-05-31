# Exercise: Developing Kafka Producer

## How to run (Windows)

- zookeeper:

````
    cd C:\kafka\bin\windows
    zookeeper-server-start.bat C:\kafka\config\zookeeper.properties
````

- kafka server:

````
    cd C:\kafka\bin\windows
    kafka-server-start.bat C:\kafka\config\server.properties
````

- read message:

 ````
    cd C:\kafka\bin\windows
    kafka-console-consumer.bat --topic output --from-beginning --bootstrap-server localhost:9092
 ````
- write message:

 ````
    cd C:\kafka\bin\windows
    kafka-console-producer.bat --topic input --bootstrap-server localhost:9092
 ````
## How to run (macOS)

````
    cd kafka
    ./bin/zookeeper-server-start.sh /Users/danielfiedosiuk/kafka/config/zookeeper.properties
````

- kafka server:

````
    cd kafka
    ./bin/kafka-server-start.sh /Users/danielfiedosiuk/kafka/config/server.properties
````

- read message:

 ````
    cd kafka
    ./bin/kafka-console-consumer.sh --topic output --from-beginning --bootstrap-server localhost:9092
 ````
- write message:

 ````
    cd kafka
    ./bin/kafka-console-producer.sh --topic input --bootstrap-server localhost:9092
 ````

