/**
  * Created by CHHAI CHIVON
  */

case class FilterData(
                       sort: String
                     ) {
  var key: String = sort.toLowerCase()
  var value: Int = 1
  if (sort.contains('-')) {
    key = sort.trim.toLowerCase().split('-')(1)
    value = -1
  }
}