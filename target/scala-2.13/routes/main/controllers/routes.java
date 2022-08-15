// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSignInController SignInController = new controllers.ReverseSignInController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseEventController EventController = new controllers.ReverseEventController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseChangePasswordController ChangePasswordController = new controllers.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseItemController ItemController = new controllers.ReverseItemController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSignUpController SignUpController = new controllers.ReverseSignUpController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFrontendController FrontendController = new controllers.ReverseFrontendController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSignInController SignInController = new controllers.javascript.ReverseSignInController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseEventController EventController = new controllers.javascript.ReverseEventController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseChangePasswordController ChangePasswordController = new controllers.javascript.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseItemController ItemController = new controllers.javascript.ReverseItemController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSignUpController SignUpController = new controllers.javascript.ReverseSignUpController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFrontendController FrontendController = new controllers.javascript.ReverseFrontendController(RoutesPrefix.byNamePrefix());
  }

}
