package models.daos

import com.google.inject.Inject

import play.api.db.slick.DatabaseConfigProvider

import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{ExecutionContext, Future}

import models.Item

class ItemDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends DatabaseDAO {

  /**
   * Извлекает список всех объектов из таблицы
   *
   * @return Список объектов
   */
  def getAll: Future[Seq[Item]] = {
    db.run(items.result)
  }

  /**
   * Производит выборку объекта по его ID
   *
   * @param itemID ID объектаб который необходимо получить
   * @return Найденный объект, иначе None
   */
  def getByID(itemID: Long): Future[Option[Item]] = {
    db.run(items.filter(_.id === itemID).result.headOption)
  }


  /**
   * Производит выборку объекта по его имени
   *
   * @param address, Имя объектаб который необходимо получить
   * @param heating Имя объектаб который необходимо получить
   * @param square Имя объектаб который необходимо получить
   * @param price Имя объектаб который необходимо получить
   * @return Найденный объект, иначе None
   */

  def getByAddress( address: String ): Future[Option[Item]] = {
    db.run(items.filter(_.address === address).result.headOption)
  }

  def getByHeating( heating: String ): Future[Option[Item]] = {
    db.run(items.filter(_.heating === heating).result.headOption)
  }

  def getBySquare( square: BigDecimal): Future[Option[Item]] = {
    db.run(items.filter(_.square === square).result.headOption)
  }

  def getByPrice( price: BigDecimal): Future[Option[Item]] = {
    db.run(items.filter(_.price === price).result.headOption)
  }

  /**
   * Добавление нового объекта
   *
   * @param item Объект для добавления
   * @return Объект, который был добавлен
   */
  def add(item: Item): Future[Item] =
    db.run(items += Item(item.id, item.address, item.heating, item.square, item.price)).map(_ => item)

  /**
   * Обновляет данные объекта
   *
   * @param item Объект для обновления
   * @return Объект, который был обновлен
   */
  def update(itemID: Long, item: Item): Future[Item] = {
    db.run(items.filter(_.id === itemID)
      .map(itm => (itm.address, itm.heating, itm.square, itm.price))
      .update((item.address, item.heating, item.square, item.price)).map(_ => item))
  }

  /**
   * Удаляет данные объекта
   *
   * @param itemID ID объекта
   * @return
   */
  def delete(itemID: Long): Future[Boolean] =
    db.run(items.filter(_.id === itemID).delete).map(_ > 0)
}
