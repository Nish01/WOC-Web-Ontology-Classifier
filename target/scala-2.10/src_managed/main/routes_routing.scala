// @SOURCE:C:/Users/nish/Desktop/s/woc-master 2018/woc-master/conf/routes
// @HASH:a7261b62b3cbae381401e610d1b78b2875091a87
// @DATE:Sun Mar 04 13:36:48 CAT 2018


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_home0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_uploadFile1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploadFile"))))
        

// @LINE:10
private[this] lazy val controllers_ApplicationReverse_uploadFile2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploadFileOnt"))))
        

// @LINE:12
private[this] lazy val controllers_ApplicationCompare_uploadFile3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploadFileComp"))))
        

// @LINE:14
private[this] lazy val controllers_ApplicationBoth_uploadFile4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("uploadFileBoth"))))
        

// @LINE:16
private[this] lazy val controllers_Application_choose5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results"))))
        

// @LINE:18
private[this] lazy val controllers_ApplicationReverse_choosefile6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("choosefile"))))
        

// @LINE:20
private[this] lazy val controllers_ApplicationCompare_choosefileCompare7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("choosefileCompare"))))
        

// @LINE:22
private[this] lazy val controllers_ApplicationBoth_chooseBoth8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("indexchooseboth"))))
        

// @LINE:24
private[this] lazy val controllers_Application_getResults9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("view"))))
        

// @LINE:26
private[this] lazy val controllers_Application_getResults10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results"))))
        

// @LINE:28
private[this] lazy val controllers_ApplicationReverse_getResults11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viewResults"))))
        

// @LINE:30
private[this] lazy val controllers_ApplicationReverse_getResults12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findresults"))))
        

// @LINE:32
private[this] lazy val controllers_ApplicationCompare_getResults13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viewCompResults"))))
        

// @LINE:34
private[this] lazy val controllers_ApplicationCompare_getResults14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findCompresults"))))
        

// @LINE:36
private[this] lazy val controllers_ApplicationBoth_getResults15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viewBothResults"))))
        

// @LINE:38
private[this] lazy val controllers_ApplicationBoth_getResults16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findBothresults"))))
        

// @LINE:40
private[this] lazy val controllers_ApplicationBoth_getResultsBoth17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("viewBothFeatureResults"))))
        

// @LINE:42
private[this] lazy val controllers_ApplicationBoth_getResultsBoth18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("findBothFeatureresults"))))
        

// @LINE:45
private[this] lazy val controllers_Assets_at19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.home()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploadFile""","""controllers.Application.uploadFile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploadFileOnt""","""controllers.ApplicationReverse.uploadFile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploadFileComp""","""controllers.ApplicationCompare.uploadFile()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """uploadFileBoth""","""controllers.ApplicationBoth.uploadFile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results""","""controllers.Application.choose()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """choosefile""","""controllers.ApplicationReverse.choosefile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """choosefileCompare""","""controllers.ApplicationCompare.choosefileCompare()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """indexchooseboth""","""controllers.ApplicationBoth.chooseBoth()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """view""","""controllers.Application.getResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results""","""controllers.Application.getResults()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viewResults""","""controllers.ApplicationReverse.getResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findresults""","""controllers.ApplicationReverse.getResults()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viewCompResults""","""controllers.ApplicationCompare.getResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findCompresults""","""controllers.ApplicationCompare.getResults()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viewBothResults""","""controllers.ApplicationBoth.getResults()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findBothresults""","""controllers.ApplicationBoth.getResults()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """viewBothFeatureResults""","""controllers.ApplicationBoth.getResultsBoth()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """findBothFeatureresults""","""controllers.ApplicationBoth.getResultsBoth()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_home0(params) => {
   call { 
        invokeHandler(controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_uploadFile1(params) => {
   call { 
        invokeHandler(controllers.Application.uploadFile(), HandlerDef(this, "controllers.Application", "uploadFile", Nil,"POST", """""", Routes.prefix + """uploadFile"""))
   }
}
        

// @LINE:10
case controllers_ApplicationReverse_uploadFile2(params) => {
   call { 
        invokeHandler(controllers.ApplicationReverse.uploadFile(), HandlerDef(this, "controllers.ApplicationReverse", "uploadFile", Nil,"POST", """""", Routes.prefix + """uploadFileOnt"""))
   }
}
        

// @LINE:12
case controllers_ApplicationCompare_uploadFile3(params) => {
   call { 
        invokeHandler(controllers.ApplicationCompare.uploadFile(), HandlerDef(this, "controllers.ApplicationCompare", "uploadFile", Nil,"POST", """""", Routes.prefix + """uploadFileComp"""))
   }
}
        

// @LINE:14
case controllers_ApplicationBoth_uploadFile4(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.uploadFile(), HandlerDef(this, "controllers.ApplicationBoth", "uploadFile", Nil,"POST", """""", Routes.prefix + """uploadFileBoth"""))
   }
}
        

// @LINE:16
case controllers_Application_choose5(params) => {
   call { 
        invokeHandler(controllers.Application.choose(), HandlerDef(this, "controllers.Application", "choose", Nil,"GET", """""", Routes.prefix + """results"""))
   }
}
        

// @LINE:18
case controllers_ApplicationReverse_choosefile6(params) => {
   call { 
        invokeHandler(controllers.ApplicationReverse.choosefile(), HandlerDef(this, "controllers.ApplicationReverse", "choosefile", Nil,"GET", """""", Routes.prefix + """choosefile"""))
   }
}
        

// @LINE:20
case controllers_ApplicationCompare_choosefileCompare7(params) => {
   call { 
        invokeHandler(controllers.ApplicationCompare.choosefileCompare(), HandlerDef(this, "controllers.ApplicationCompare", "choosefileCompare", Nil,"GET", """""", Routes.prefix + """choosefileCompare"""))
   }
}
        

// @LINE:22
case controllers_ApplicationBoth_chooseBoth8(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.chooseBoth(), HandlerDef(this, "controllers.ApplicationBoth", "chooseBoth", Nil,"GET", """""", Routes.prefix + """indexchooseboth"""))
   }
}
        

// @LINE:24
case controllers_Application_getResults9(params) => {
   call { 
        invokeHandler(controllers.Application.getResults(), HandlerDef(this, "controllers.Application", "getResults", Nil,"POST", """""", Routes.prefix + """view"""))
   }
}
        

// @LINE:26
case controllers_Application_getResults10(params) => {
   call { 
        invokeHandler(controllers.Application.getResults(), HandlerDef(this, "controllers.Application", "getResults", Nil,"GET", """""", Routes.prefix + """results"""))
   }
}
        

// @LINE:28
case controllers_ApplicationReverse_getResults11(params) => {
   call { 
        invokeHandler(controllers.ApplicationReverse.getResults(), HandlerDef(this, "controllers.ApplicationReverse", "getResults", Nil,"POST", """""", Routes.prefix + """viewResults"""))
   }
}
        

// @LINE:30
case controllers_ApplicationReverse_getResults12(params) => {
   call { 
        invokeHandler(controllers.ApplicationReverse.getResults(), HandlerDef(this, "controllers.ApplicationReverse", "getResults", Nil,"GET", """""", Routes.prefix + """findresults"""))
   }
}
        

// @LINE:32
case controllers_ApplicationCompare_getResults13(params) => {
   call { 
        invokeHandler(controllers.ApplicationCompare.getResults(), HandlerDef(this, "controllers.ApplicationCompare", "getResults", Nil,"POST", """""", Routes.prefix + """viewCompResults"""))
   }
}
        

// @LINE:34
case controllers_ApplicationCompare_getResults14(params) => {
   call { 
        invokeHandler(controllers.ApplicationCompare.getResults(), HandlerDef(this, "controllers.ApplicationCompare", "getResults", Nil,"GET", """""", Routes.prefix + """findCompresults"""))
   }
}
        

// @LINE:36
case controllers_ApplicationBoth_getResults15(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.getResults(), HandlerDef(this, "controllers.ApplicationBoth", "getResults", Nil,"POST", """""", Routes.prefix + """viewBothResults"""))
   }
}
        

// @LINE:38
case controllers_ApplicationBoth_getResults16(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.getResults(), HandlerDef(this, "controllers.ApplicationBoth", "getResults", Nil,"GET", """""", Routes.prefix + """findBothresults"""))
   }
}
        

// @LINE:40
case controllers_ApplicationBoth_getResultsBoth17(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.getResultsBoth(), HandlerDef(this, "controllers.ApplicationBoth", "getResultsBoth", Nil,"POST", """""", Routes.prefix + """viewBothFeatureResults"""))
   }
}
        

// @LINE:42
case controllers_ApplicationBoth_getResultsBoth18(params) => {
   call { 
        invokeHandler(controllers.ApplicationBoth.getResultsBoth(), HandlerDef(this, "controllers.ApplicationBoth", "getResultsBoth", Nil,"GET", """""", Routes.prefix + """findBothFeatureresults"""))
   }
}
        

// @LINE:45
case controllers_Assets_at19(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     