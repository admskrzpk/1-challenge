import org.apache.spark.sql.SparkSession

object CatsAndDogs {
  def main(args: Array[String]):Unit = {
    import org.apache.spark.sql.SparkSession

    val path = if (args.length > 0) args(0)
    else "src/main/resources/input.json"

    println(s"loading files from: $path")

    implicit val spark = SparkSession
      .builder()
      .master("local[*]")
      .getOrCreate()

    val message = spark
      .readStream
      .format()
      .option("subscribe", "cats")
/*
      .option("kafka.bootstrap.servers", ":9092")
*/
      .option("includeHeaders", "true")
      .load
      .show()
    /*val result = message.toDF()
      .withColumn("")*/
    // val output = loadFilesFromPath(path)
  }

/*  val finalMessage = upperMessage
    .writeStream
    .format("kafka")
    .option("topic", "animals")
    .option("checkpointLocation", "checkpoint")
    .option("kafka.bootstrap.servers", ":9092")
    .start()
    .awaitTermination*/


  def loadFilesFromPath(path: String) (implicit spark: SparkSession) = {
    spark
      .read
      .text(path)
  }
}
