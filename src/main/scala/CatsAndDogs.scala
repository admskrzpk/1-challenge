import org.apache.spark.sql.functions.upper
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

object CatsAndDogs {

  def main(args: Array[String]): Unit = {
    import org.apache.spark.sql.SparkSession
    val path = if (args.length > 0) args(0)
    else "src/main/resources/json"

    val spark = SparkSession
      .builder()
      .master("local[*]")
      .getOrCreate()
    import spark.implicits._

    val input = spark
      .read
      .option("multiline", "true")
      .option("inferSchema", "true")
      .json(path)
    input.printSchema()

    val newTable = input
      .withColumn("surname", upper($"surname"))
      .withColumn("animals", $"cats" + $"dogs")
      .drop($"cats")
      .drop($"dogs")

    val result = newTable
      .write
      .parquet("C:\\exam\\challenge-first\\parquet")

    /*val djJSON = input.withColumn("value", from_json(col("value"), schema))
      .select("jsonData.*")


    */
    // Write back
    /* .write
    .
     .format("kafka")
     .option("kafka.bootstrap.servers", "localhost:9092")
     .option("subscribe", "outputTopic")
     .start()*/
  }
}