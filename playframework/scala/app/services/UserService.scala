package services

import com.google.inject.ImplementedBy

/**
  * Created by CHHAI CHIVON
  */
@ImplementedBy(classOf[UserRepos])
trait UserService {

  def select(id: String)(implicit ec: ExecutionContext): Future[Option[JsObject]]
  def update(id: String, update: User1)(implicit ec: ExecutionContext): Future[WriteResult]
  def remove(id: String)(implicit ec: ExecutionContext): Future[WriteResult]
  def save(document: User1)(implicit ec: ExecutionContext): Future[WriteResult]
  def findAll(pagination: Pagination, fiterData: FilterData)(implicit ec: ExecutionContext): Future[List[JsObject]]
  def count()(implicit ec: ExecutionContext): Future[Int]
  def findByEmail(email: String)(implicit ec: ExecutionContext): Future[Option[User1]]

}
