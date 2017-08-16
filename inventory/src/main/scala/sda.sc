import scala.collection.mutable
val category = "fas"
val price = 2000
val rating = 5
val photoSizeInBytes= 444
val item1 = Item(category, "navy blue Lotto shoes", Photo("Havaii trip", photoSizeInBytes), "Flipkart",
  rating, price)
val item2 = Item(category, "t-shirt", Photo("Paris trip", photoSizeInBytes), "Snapdeal", rating + 1,
  price + price)

val itemMap: mutable.Map[String, Item] = mutable.Map(category -> item1,category->item2)

val s=itemMap.toList.sortWith(_._2.price > _._2.price).toMap
print(s)


