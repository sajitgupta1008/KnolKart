import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
class InventoryService {

  val category = "fashion"
  val photoSizeInBytes = 200
  val rating = 5
  val price = 2000
  val item1 = Item(category, "navy blue Lotto shoes", Photo("Havaii trip", photoSizeInBytes), "Flipkart",
    rating, price)
  val item2 = Item(category, "t-shirt", Photo("Paris trip", photoSizeInBytes), "Snapdeal", rating + 1,
    price + price)

  val itemMap: mutable.Map[String, List[Item]] = mutable.Map(category -> List(item1,item2))

  def searchBasedOnCategory(category: String):Future[Option[List[Item]]] ={ Future{
    itemMap.get(category)
  }}

  def sortItems(searchParameter: String): Future[List[Item]] = {
    Future {
      searchParameter match {
        case "price: high to low" => itemMap.values.toList.flatten.sortWith(_.price > _.price)
        case "price: low to high" => itemMap.values.toList.flatten.sortWith(_.price < _.price)
        case "rating: low to high" => itemMap.values.toList.flatten.sortWith(_.rating < _.rating)
        case _ => itemMap.values.toList.flatten.sortWith(_.rating > _.rating)
      }
    }
  }
}
