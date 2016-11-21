import javax.inject.Inject

/**
  * Created by CHHAI CHIVON
  */

class UserRepos @Inject()(reactiveMongoApi: ReactiveMongoApi) extends UserServices{

  def collection(implicit ec: ExecutionContext) = reactiveMongoApi.database.map(db => db.collection[JSONCollection]("users"))

  override def update(id: String, update: User1)(implicit ec: ExecutionContext): Future[WriteResult] = {
    collection.flatMap(_.update(BSONObjectIDConverter(id).selector, update))
  }
  override def remove(id: String)(implicit ec: ExecutionContext): Future[WriteResult] = {
    collection.flatMap(_.remove(BSONObjectIDConverter(id).selector))
  }
  override def select(id: String)(implicit ec: ExecutionContext): Future[Option[JsObject]] = {
    collection.flatMap(_.find(BSONObjectIDConverter(id).selector).one[JsObject])
  }
  override def save(document: User1)(implicit ec: ExecutionContext): Future[WriteResult] = {
    collection.flatMap(_.insert(document))
  }
  override def findAll(pagination: Pagination, filterData: FilterData)(implicit ec: ExecutionContext): Future[List[JsObject]] = {
    val genericQueryBuilder = collection.map(_.find(Json.obj()).options(QueryOpts(pagination.skip)))
    val cursor = genericQueryBuilder.map(_.cursor[JsObject](ReadPreference.Primary))
    cursor.flatMap(_.collect[List](pagination.Size))
  }
  def count()(implicit ec: ExecutionContext): Future[Int] = {
    collection.flatMap(_.count())
  }
  override def findByEmail(email: String)(implicit ec: ExecutionContext): Future[Option[User1]] = {
    collection.flatMap(_.find(Json.obj("email" -> email)).one[User1])
  }
}