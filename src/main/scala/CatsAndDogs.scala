import org.apache.spark.sql.functions.upper
import org.apache.spark.sql.types.IntegerType

object CatsAndDogs {
  def main(args: Array[String]): Unit = {

    import org.apache.spark.sql.SparkSession
    val inputPath = "src/main/resources/json"

    val outputPath = if (args.length > 0) args(0)
    else "hdfs://localhost:9000/exam"

    val spark = SparkSession
      .builder()
      .master("yarn")
      .getOrCreate()
    import spark.implicits._

    val input = spark
      .read
      .option("multiline", "true")
      .option("inferSchema", "true")
      .json(inputPath)
    input.printSchema()

    val newTable = input
      .withColumn("surname", upper($"surname"))
      .withColumn("animals", $"cats" + $"dogs")
      .drop($"cats")
      .drop($"dogs")
      .withColumn("animals", $"animals".cast(IntegerType))
    newTable.printSchema()
    newTable.show()

    val result = newTable
      .write
      .parquet(outputPath)
  }
}