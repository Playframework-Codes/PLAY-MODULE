/**
  * Created by CHHAI CHIVON
  */

case class BSONObjectIDConverter(id: String) {
  val OId: Try[BSONObjectID] = BSONObjectID.parse(id)
  val selector = BSONDocument("_id" -> OId.get)
}
