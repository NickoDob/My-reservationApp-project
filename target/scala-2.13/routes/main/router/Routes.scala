// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  FrontendController_2: controllers.FrontendController,
  // @LINE:5
  SignInController_0: controllers.SignInController,
  // @LINE:8
  SignUpController_4: controllers.SignUpController,
  // @LINE:10
  ChangePasswordController_1: controllers.ChangePasswordController,
  // @LINE:11
  UserController_6: controllers.UserController,
  // @LINE:20
  EventController_3: controllers.EventController,
  // @LINE:27
  ItemController_5: controllers.ItemController,
  // @LINE:34
  Assets_7: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    FrontendController_2: controllers.FrontendController,
    // @LINE:5
    SignInController_0: controllers.SignInController,
    // @LINE:8
    SignUpController_4: controllers.SignUpController,
    // @LINE:10
    ChangePasswordController_1: controllers.ChangePasswordController,
    // @LINE:11
    UserController_6: controllers.UserController,
    // @LINE:20
    EventController_3: controllers.EventController,
    // @LINE:27
    ItemController_5: controllers.ItemController,
    // @LINE:34
    Assets_7: controllers.Assets
  ) = this(errorHandler, FrontendController_2, SignInController_0, SignUpController_4, ChangePasswordController_1, UserController_6, EventController_3, ItemController_5, Assets_7, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FrontendController_2, SignInController_0, SignUpController_4, ChangePasswordController_1, UserController_6, EventController_3, ItemController_5, Assets_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FrontendController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/signOut""", """controllers.SignInController.signOut()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/signIn""", """controllers.SignInController.submit"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/signUp""", """controllers.SignUpController.register"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/password/change""", """controllers.ChangePasswordController.submit"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """userId<[^/]+>/role""", """controllers.UserController.changeUserRole(userId:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users""", """controllers.UserController.listAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """userId<[^/]+>""", """controllers.UserController.getUserByID(userId:java.util.UUID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users""", """controllers.SignUpController.submit"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """userId<[^/]+>""", """controllers.SignUpController.update(userId:java.util.UUID)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """userId<[^/]+>""", """controllers.UserController.delete(userId:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/events""", """controllers.EventController.listAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/events/""" + "$" + """eventId<[^/]+>""", """controllers.EventController.getEventByID(eventId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/events""", """controllers.EventController.createEvent()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/events/""" + "$" + """eventId<[^/]+>""", """controllers.EventController.updateEvent(eventId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/events/""" + "$" + """eventId<[^/]+>""", """controllers.EventController.deleteEvent(eventId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/items""", """controllers.ItemController.listAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/items/""" + "$" + """itemId<[^/]+>""", """controllers.ItemController.getItemByID(itemId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/items""", """controllers.ItemController.saveItem(itemId:Long = -1)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/items/""" + "$" + """itemId<[^/]+>""", """controllers.ItemController.saveItem(itemId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/items/""" + "$" + """itemId<[^/]+>""", """controllers.ItemController.deleteItem(itemId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_FrontendController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FrontendController_index0_invoker = createInvoker(
    FrontendController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Маршруты""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_SignInController_signOut1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/signOut")))
  )
  private[this] lazy val controllers_SignInController_signOut1_invoker = createInvoker(
    SignInController_0.signOut(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "signOut",
      Nil,
      "GET",
      this.prefix + """api/signOut""",
      """ Пользователи""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_SignInController_submit2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/signIn")))
  )
  private[this] lazy val controllers_SignInController_submit2_invoker = createInvoker(
    SignInController_0.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignInController",
      "submit",
      Nil,
      "POST",
      this.prefix + """api/signIn""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_SignUpController_register3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/signUp")))
  )
  private[this] lazy val controllers_SignUpController_register3_invoker = createInvoker(
    SignUpController_4.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "register",
      Nil,
      "POST",
      this.prefix + """api/signUp""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_ChangePasswordController_submit4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/password/change")))
  )
  private[this] lazy val controllers_ChangePasswordController_submit4_invoker = createInvoker(
    ChangePasswordController_1.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChangePasswordController",
      "submit",
      Nil,
      "PUT",
      this.prefix + """api/password/change""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_changeUserRole5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/role")))
  )
  private[this] lazy val controllers_UserController_changeUserRole5_invoker = createInvoker(
    UserController_6.changeUserRole(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "changeUserRole",
      Seq(classOf[java.util.UUID]),
      "PUT",
      this.prefix + """api/users/""" + "$" + """userId<[^/]+>/role""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_listAll6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_UserController_listAll6_invoker = createInvoker(
    UserController_6.listAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "listAll",
      Nil,
      "GET",
      this.prefix + """api/users""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_getUserByID7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUserByID7_invoker = createInvoker(
    UserController_6.getUserByID(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserByID",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """api/users/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_SignUpController_submit8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_SignUpController_submit8_invoker = createInvoker(
    SignUpController_4.submit,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "submit",
      Nil,
      "POST",
      this.prefix + """api/users""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_SignUpController_update9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SignUpController_update9_invoker = createInvoker(
    SignUpController_4.update(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignUpController",
      "update",
      Seq(classOf[java.util.UUID]),
      "PUT",
      this.prefix + """api/users/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UserController_delete10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_delete10_invoker = createInvoker(
    UserController_6.delete(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "delete",
      Seq(classOf[java.util.UUID]),
      "DELETE",
      this.prefix + """api/users/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_EventController_listAll11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/events")))
  )
  private[this] lazy val controllers_EventController_listAll11_invoker = createInvoker(
    EventController_3.listAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "listAll",
      Nil,
      "GET",
      this.prefix + """api/events""",
      """ События""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_EventController_getEventByID12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/events/"), DynamicPart("eventId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EventController_getEventByID12_invoker = createInvoker(
    EventController_3.getEventByID(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "getEventByID",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/events/""" + "$" + """eventId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_EventController_createEvent13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/events")))
  )
  private[this] lazy val controllers_EventController_createEvent13_invoker = createInvoker(
    EventController_3.createEvent(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "createEvent",
      Nil,
      "POST",
      this.prefix + """api/events""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_EventController_updateEvent14_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/events/"), DynamicPart("eventId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EventController_updateEvent14_invoker = createInvoker(
    EventController_3.updateEvent(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "updateEvent",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """api/events/""" + "$" + """eventId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_EventController_deleteEvent15_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/events/"), DynamicPart("eventId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EventController_deleteEvent15_invoker = createInvoker(
    EventController_3.deleteEvent(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EventController",
      "deleteEvent",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """api/events/""" + "$" + """eventId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ItemController_listAll16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/items")))
  )
  private[this] lazy val controllers_ItemController_listAll16_invoker = createInvoker(
    ItemController_5.listAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "listAll",
      Nil,
      "GET",
      this.prefix + """api/items""",
      """ Объекты""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ItemController_getItemByID17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/items/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemController_getItemByID17_invoker = createInvoker(
    ItemController_5.getItemByID(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "getItemByID",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """api/items/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ItemController_saveItem18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/items")))
  )
  private[this] lazy val controllers_ItemController_saveItem18_invoker = createInvoker(
    ItemController_5.saveItem(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "saveItem",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """api/items""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_ItemController_saveItem19_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/items/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemController_saveItem19_invoker = createInvoker(
    ItemController_5.saveItem(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "saveItem",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """api/items/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_ItemController_deleteItem20_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/items/"), DynamicPart("itemId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ItemController_deleteItem20_invoker = createInvoker(
    ItemController_5.deleteItem(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ItemController",
      "deleteItem",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """api/items/""" + "$" + """itemId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_versioned21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned21_invoker = createInvoker(
    Assets_7.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_FrontendController_index0_route(params@_) =>
      call { 
        controllers_FrontendController_index0_invoker.call(FrontendController_2.index())
      }
  
    // @LINE:5
    case controllers_SignInController_signOut1_route(params@_) =>
      call { 
        controllers_SignInController_signOut1_invoker.call(SignInController_0.signOut())
      }
  
    // @LINE:7
    case controllers_SignInController_submit2_route(params@_) =>
      call { 
        controllers_SignInController_submit2_invoker.call(SignInController_0.submit)
      }
  
    // @LINE:8
    case controllers_SignUpController_register3_route(params@_) =>
      call { 
        controllers_SignUpController_register3_invoker.call(SignUpController_4.register)
      }
  
    // @LINE:10
    case controllers_ChangePasswordController_submit4_route(params@_) =>
      call { 
        controllers_ChangePasswordController_submit4_invoker.call(ChangePasswordController_1.submit)
      }
  
    // @LINE:11
    case controllers_UserController_changeUserRole5_route(params@_) =>
      call(params.fromPath[java.util.UUID]("userId", None)) { (userId) =>
        controllers_UserController_changeUserRole5_invoker.call(UserController_6.changeUserRole(userId))
      }
  
    // @LINE:13
    case controllers_UserController_listAll6_route(params@_) =>
      call { 
        controllers_UserController_listAll6_invoker.call(UserController_6.listAll())
      }
  
    // @LINE:14
    case controllers_UserController_getUserByID7_route(params@_) =>
      call(params.fromPath[java.util.UUID]("userId", None)) { (userId) =>
        controllers_UserController_getUserByID7_invoker.call(UserController_6.getUserByID(userId))
      }
  
    // @LINE:15
    case controllers_SignUpController_submit8_route(params@_) =>
      call { 
        controllers_SignUpController_submit8_invoker.call(SignUpController_4.submit)
      }
  
    // @LINE:16
    case controllers_SignUpController_update9_route(params@_) =>
      call(params.fromPath[java.util.UUID]("userId", None)) { (userId) =>
        controllers_SignUpController_update9_invoker.call(SignUpController_4.update(userId))
      }
  
    // @LINE:17
    case controllers_UserController_delete10_route(params@_) =>
      call(params.fromPath[java.util.UUID]("userId", None)) { (userId) =>
        controllers_UserController_delete10_invoker.call(UserController_6.delete(userId))
      }
  
    // @LINE:20
    case controllers_EventController_listAll11_route(params@_) =>
      call { 
        controllers_EventController_listAll11_invoker.call(EventController_3.listAll())
      }
  
    // @LINE:21
    case controllers_EventController_getEventByID12_route(params@_) =>
      call(params.fromPath[Long]("eventId", None)) { (eventId) =>
        controllers_EventController_getEventByID12_invoker.call(EventController_3.getEventByID(eventId))
      }
  
    // @LINE:22
    case controllers_EventController_createEvent13_route(params@_) =>
      call { 
        controllers_EventController_createEvent13_invoker.call(EventController_3.createEvent())
      }
  
    // @LINE:23
    case controllers_EventController_updateEvent14_route(params@_) =>
      call(params.fromPath[Long]("eventId", None)) { (eventId) =>
        controllers_EventController_updateEvent14_invoker.call(EventController_3.updateEvent(eventId))
      }
  
    // @LINE:24
    case controllers_EventController_deleteEvent15_route(params@_) =>
      call(params.fromPath[Long]("eventId", None)) { (eventId) =>
        controllers_EventController_deleteEvent15_invoker.call(EventController_3.deleteEvent(eventId))
      }
  
    // @LINE:27
    case controllers_ItemController_listAll16_route(params@_) =>
      call { 
        controllers_ItemController_listAll16_invoker.call(ItemController_5.listAll())
      }
  
    // @LINE:28
    case controllers_ItemController_getItemByID17_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ItemController_getItemByID17_invoker.call(ItemController_5.getItemByID(itemId))
      }
  
    // @LINE:29
    case controllers_ItemController_saveItem18_route(params@_) =>
      call(Param[Long]("itemId", Right(-1))) { (itemId) =>
        controllers_ItemController_saveItem18_invoker.call(ItemController_5.saveItem(itemId))
      }
  
    // @LINE:30
    case controllers_ItemController_saveItem19_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ItemController_saveItem19_invoker.call(ItemController_5.saveItem(itemId))
      }
  
    // @LINE:31
    case controllers_ItemController_deleteItem20_route(params@_) =>
      call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        controllers_ItemController_deleteItem20_invoker.call(ItemController_5.deleteItem(itemId))
      }
  
    // @LINE:34
    case controllers_Assets_versioned21_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned21_invoker.call(Assets_7.versioned(path, file))
      }
  }
}
