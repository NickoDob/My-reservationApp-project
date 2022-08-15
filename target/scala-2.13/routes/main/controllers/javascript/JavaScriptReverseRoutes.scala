// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:34
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseSignInController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def signOut: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SignInController.signOut",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/signOut"})
        }
      """
    )
  
    // @LINE:7
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SignInController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/signIn"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseEventController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def deleteEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.deleteEvent",
      """
        function(eventId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/events/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("eventId", eventId0))})
        }
      """
    )
  
    // @LINE:23
    def updateEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.updateEvent",
      """
        function(eventId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/events/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("eventId", eventId0))})
        }
      """
    )
  
    // @LINE:20
    def listAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.listAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/events"})
        }
      """
    )
  
    // @LINE:21
    def getEventByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.getEventByID",
      """
        function(eventId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/events/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("eventId", eventId0))})
        }
      """
    )
  
    // @LINE:22
    def createEvent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EventController.createEvent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/events"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def changeUserRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.changeUserRole",
      """
        function(userId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("userId", userId0)) + "/role"})
        }
      """
    )
  
    // @LINE:13
    def listAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.listAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users"})
        }
      """
    )
  
    // @LINE:14
    def getUserByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserByID",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:17
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.delete",
      """
        function(userId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseChangePasswordController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChangePasswordController.submit",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/password/change"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseItemController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def listAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.listAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/items"})
        }
      """
    )
  
    // @LINE:28
    def getItemByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.getItemByID",
      """
        function(itemId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/items/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
    // @LINE:29
    def saveItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.saveItem",
      """
        function(itemId0) {
        
          if (itemId0 == """ + implicitly[play.api.mvc.JavascriptLiteral[Long]].to(-1) + """) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/items"})
          }
        
          if (true) {
            return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/items/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
          }
        
        }
      """
    )
  
    // @LINE:31
    def deleteItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ItemController.deleteItem",
      """
        function(itemId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/items/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("itemId", itemId0))})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseSignUpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SignUpController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/signUp"})
        }
      """
    )
  
    // @LINE:15
    def submit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SignUpController.submit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users"})
        }
      """
    )
  
    // @LINE:16
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SignUpController.update",
      """
        function(userId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseFrontendController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
