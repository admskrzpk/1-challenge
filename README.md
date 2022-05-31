# Challenge: 1: Spark, Kafka, Hadoop
NOTE: app core is working, reading from local json file and writing to parquet file.
Result
```text
root
 |-- name: string (nullable = true)
 |-- surname: string (nullable = true)
 |-- animals: long (nullable = true)

+----+-------+-------+
|name|surname|animals|
+----+-------+-------+
|John|    DOE|      3|
+----+-------+-------+
```

## Task:
```text
Write a Spark application that reads records from a Kafka topic.
This application does the following transformations:

Writes records to Kafka in JSON format
JSON example:
{
    "name": "John",
    "surname": "Doe",
    "cats": 1,
    "dogs": 2
}
Reads the data from the topic
Parses the JSONs
Surname to upper case letters
Sum cats and dogs fields and write the result to the new field “animals”.
The result should be written as a parquet file in which every record consists of 3 columns: name (String), surname (String), animals (Integer).

How to parse JSON in Scala:
https://alvinalexander.com/scala/how-to-create-scala-object-instance-from-json-string/
https://sparkbyexamples.com/spark/spark-parse-json-from-text-file-string/

Choose the method which suits you best.

Expected results
The result should be saved to an HDFS location.
Deploy this Spark application to a YARN cluster.
Write tests.
Don’t forget about README with proper structure
Publish to a github repo

```

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

## Deploying on Yarn
In terminal go to the Spark directory and run command
```./bin/spark-submit --class <classname> --master yarn \ --<jarpath> args   ```

