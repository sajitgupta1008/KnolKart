import org.scalatest.AsyncFunSuite

class InventoryServiceTest extends AsyncFunSuite {

  val inventoryService = new InventoryService()

  val category = "fashion"
  val photoSizeInBytes = 200
  val rating = 5
  val price = 2000
  val item1 = Item(category, "navy blue Lotto shoes", Photo("Havaii trip", photoSizeInBytes), "Flipkart",
    rating, price)
  val item2 = Item(category, "t-shirt", Photo("Paris trip", photoSizeInBytes), "Snapdeal", rating + 1,
    price + price)


  test("should search based onn given category with success") {
    inventoryService.searchBasedOnCategory("fashion").map(list => assert(list.get == List(item1, item2)))
  }

  test("test sort items with price low to high") {
    inventoryService.sortItems("price: low to high").map(list => assert(list == List(item1, item2)))
  }

  test("test sort items with rating low to high") {
    inventoryService.sortItems("rating: low to high").map(list => assert(list == List(item1, item2)))
  }
  test("test sort items with price high to low`") {
    inventoryService.sortItems("price: high to low").map(list => assert(list == List(item2, item1)))
  }

}
