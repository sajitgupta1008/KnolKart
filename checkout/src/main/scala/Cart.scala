
class Cart {

//was not able to access Item class from inventory despite using dependsOn
  val itemList:List[Item] = Nil

  def addItem(item : Item):List[Item] = item::itemList

  def removeItem(item:Item):List[Item] = itemList.filter(i=> i!=item)

}
