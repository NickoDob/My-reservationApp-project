// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:34
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:5
  class ReverseSignInController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def signOut(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/signOut")
    }
  
    // @LINE:7
    def submit: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/signIn")
    }
  
  }

  // @LINE:20
  class ReverseEventController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def deleteEvent(eventId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/events/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("eventId", eventId)))
    }
  
    // @LINE:23
    def updateEvent(eventId:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/events/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("eventId", eventId)))
    }
  
    // @LINE:20
    def listAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/events")
    }
  
    // @LINE:21
    def getEventByID(eventId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/events/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("eventId", eventId)))
    }
  
    // @LINE:22
    def createEvent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/events")
    }
  
  }

  // @LINE:11
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def changeUserRole(userId:java.util.UUID): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("userId", userId)) + "/role")
    }
  
    // @LINE:13
    def listAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/users")
    }
  
    // @LINE:14
    def getUserByID(userId:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("userId", userId)))
    }
  
    // @LINE:17
    def delete(userId:java.util.UUID): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("userId", userId)))
    }
  
  }

  // @LINE:10
  class ReverseChangePasswordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def submit: Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/password/change")
    }
  
  }

  // @LINE:27
  class ReverseItemController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def listAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/items")
    }
  
    // @LINE:28
    def getItemByID(itemId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/items/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
    // @LINE:29
    def saveItem(itemId:Long): Call = {
    
      (itemId: @unchecked) match {
      
        // @LINE:29
        case (itemId) if itemId == -1 =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("itemId", -1))); _rrc
          Call("POST", _prefix + { _defaultPrefix } + "api/items")
      
        // @LINE:30
        case (itemId)  =>
          
          Call("PUT", _prefix + { _defaultPrefix } + "api/items/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
      
      }
    
    }
  
    // @LINE:31
    def deleteItem(itemId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/items/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("itemId", itemId)))
    }
  
  }

  // @LINE:8
  class ReverseSignUpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def register: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/signUp")
    }
  
    // @LINE:15
    def submit: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/users")
    }
  
    // @LINE:16
    def update(userId:java.util.UUID): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("userId", userId)))
    }
  
  }

  // @LINE:2
  class ReverseFrontendController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
