/*
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.hadoop.shaded.com.fasterxml.jackson.databind.DeserializationFeature
import org.apache.hadoop.shaded.org.codehaus.jackson.JsonNode
import org.apache.hadoop.shaded.org.codehaus.jackson.map.ObjectMapper
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaProducer {
  def sendMessages(): Unit = {

    //define topic
    val topic = "spark-topic"

    //define producer properties
    val props = new java.util.Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "jsonTopic")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.connect.json.JsonSerializer")

    //create producer instance
    val kafkaProducer = new KafkaProducer[String, JsonNode](props)

    //create object mapper
    val mapper = new ObjectMapper with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    //mapper Json object to string
    def toJson(value: Any): String = {
      mapper.writeValueAsString(value)
    }

    //send producer message
    val jsonstring =
      s"""{
         | "id": "0001",
         | "name": "Peter"
         |}
         """.stripMargin

    val jsonNode: JsonNode = mapper.readTree(jsonstring)
    val rec = new ProducerRecord[String, JsonNode](topic, jsonNode)
    kafkaProducer.send(rec)
    //println(rec)
  }

}
*/
