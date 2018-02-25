// @SOURCE:C:/Users/nish/Desktop/s/woc-master 2018/woc-master/conf/routes
// @HASH:91d11d0475402ebec91c10fcc03f6314f76ce135
// @DATE:Sat Feb 24 22:41:40 CAT 2018

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:45
// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:22
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers {

// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:30
// @LINE:28
// @LINE:18
// @LINE:10
class ReverseApplicationReverse {
    

// @LINE:30
// @LINE:28
def getResults(): Call = {
   () match {
// @LINE:28
case () if true => Call("POST", _prefix + { _defaultPrefix } + "viewResults")
                                                        
// @LINE:30
case () if true => Call("GET", _prefix + { _defaultPrefix } + "findresults")
                                                        
   }
}
                                                

// @LINE:18
def choosefile(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "choosefile")
}
                                                

// @LINE:10
def uploadFile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploadFileOnt")
}
                                                
    
}
                          

// @LINE:26
// @LINE:24
// @LINE:16
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def choose(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "results")
}
                                                

// @LINE:26
// @LINE:24
def getResults(): Call = {
   () match {
// @LINE:24
case () if true => Call("POST", _prefix + { _defaultPrefix } + "view")
                                                        
// @LINE:26
case () if true => Call("GET", _prefix + { _defaultPrefix } + "results")
                                                        
   }
}
                                                

// @LINE:6
def home(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def uploadFile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploadFile")
}
                                                
    
}
                          

// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:22
// @LINE:14
class ReverseApplicationBoth {
    

// @LINE:22
def chooseBoth(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "choosefileBoth")
}
                                                

// @LINE:38
// @LINE:36
def getResults(): Call = {
   () match {
// @LINE:36
case () if true => Call("POST", _prefix + { _defaultPrefix } + "viewBothResults")
                                                        
// @LINE:38
case () if true => Call("GET", _prefix + { _defaultPrefix } + "findBothresults")
                                                        
   }
}
                                                

// @LINE:14
def uploadFile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploadFileBoth")
}
                                                

// @LINE:42
// @LINE:40
def getResultsBoth(): Call = {
   () match {
// @LINE:40
case () if true => Call("POST", _prefix + { _defaultPrefix } + "viewBothFeatureResults")
                                                        
// @LINE:42
case () if true => Call("GET", _prefix + { _defaultPrefix } + "findBothFeatureresults")
                                                        
   }
}
                                                
    
}
                          

// @LINE:34
// @LINE:32
// @LINE:20
// @LINE:12
class ReverseApplicationCompare {
    

// @LINE:20
def choosefileCompare(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "choosefileCompare")
}
                                                

// @LINE:34
// @LINE:32
def getResults(): Call = {
   () match {
// @LINE:32
case () if true => Call("POST", _prefix + { _defaultPrefix } + "viewCompResults")
                                                        
// @LINE:34
case () if true => Call("GET", _prefix + { _defaultPrefix } + "findCompresults")
                                                        
   }
}
                                                

// @LINE:12
def uploadFile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "uploadFileComp")
}
                                                
    
}
                          
}
                  


// @LINE:45
// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:22
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:30
// @LINE:28
// @LINE:18
// @LINE:10
class ReverseApplicationReverse {
    

// @LINE:30
// @LINE:28
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationReverse.getResults",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "viewResults"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findresults"})
      }
      }
   """
)
                        

// @LINE:18
def choosefile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationReverse.choosefile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "choosefile"})
      }
   """
)
                        

// @LINE:10
def uploadFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationReverse.uploadFile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadFileOnt"})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:24
// @LINE:16
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def choose : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.choose",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results"})
      }
   """
)
                        

// @LINE:26
// @LINE:24
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getResults",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "view"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results"})
      }
      }
   """
)
                        

// @LINE:6
def home : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.home",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def uploadFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.uploadFile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadFile"})
      }
   """
)
                        
    
}
              

// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:22
// @LINE:14
class ReverseApplicationBoth {
    

// @LINE:22
def chooseBoth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationBoth.chooseBoth",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "choosefileBoth"})
      }
   """
)
                        

// @LINE:38
// @LINE:36
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationBoth.getResults",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "viewBothResults"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findBothresults"})
      }
      }
   """
)
                        

// @LINE:14
def uploadFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationBoth.uploadFile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadFileBoth"})
      }
   """
)
                        

// @LINE:42
// @LINE:40
def getResultsBoth : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationBoth.getResultsBoth",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "viewBothFeatureResults"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findBothFeatureresults"})
      }
      }
   """
)
                        
    
}
              

// @LINE:34
// @LINE:32
// @LINE:20
// @LINE:12
class ReverseApplicationCompare {
    

// @LINE:20
def choosefileCompare : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationCompare.choosefileCompare",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "choosefileCompare"})
      }
   """
)
                        

// @LINE:34
// @LINE:32
def getResults : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationCompare.getResults",
   """
      function() {
      if (true) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "viewCompResults"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "findCompresults"})
      }
      }
   """
)
                        

// @LINE:12
def uploadFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ApplicationCompare.uploadFile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "uploadFileComp"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:45
// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:34
// @LINE:32
// @LINE:30
// @LINE:28
// @LINE:26
// @LINE:24
// @LINE:22
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:45
class ReverseAssets {
    

// @LINE:45
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:30
// @LINE:28
// @LINE:18
// @LINE:10
class ReverseApplicationReverse {
    

// @LINE:28
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationReverse.getResults(), HandlerDef(this, "controllers.ApplicationReverse", "getResults", Seq(), "POST", """""", _prefix + """viewResults""")
)
                      

// @LINE:18
def choosefile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationReverse.choosefile(), HandlerDef(this, "controllers.ApplicationReverse", "choosefile", Seq(), "GET", """""", _prefix + """choosefile""")
)
                      

// @LINE:10
def uploadFile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationReverse.uploadFile(), HandlerDef(this, "controllers.ApplicationReverse", "uploadFile", Seq(), "POST", """""", _prefix + """uploadFileOnt""")
)
                      
    
}
                          

// @LINE:26
// @LINE:24
// @LINE:16
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def choose(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.choose(), HandlerDef(this, "controllers.Application", "choose", Seq(), "GET", """""", _prefix + """results""")
)
                      

// @LINE:24
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getResults(), HandlerDef(this, "controllers.Application", "getResults", Seq(), "POST", """""", _prefix + """view""")
)
                      

// @LINE:6
def home(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.home(), HandlerDef(this, "controllers.Application", "home", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def uploadFile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.uploadFile(), HandlerDef(this, "controllers.Application", "uploadFile", Seq(), "POST", """""", _prefix + """uploadFile""")
)
                      
    
}
                          

// @LINE:42
// @LINE:40
// @LINE:38
// @LINE:36
// @LINE:22
// @LINE:14
class ReverseApplicationBoth {
    

// @LINE:22
def chooseBoth(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationBoth.chooseBoth(), HandlerDef(this, "controllers.ApplicationBoth", "chooseBoth", Seq(), "GET", """""", _prefix + """choosefileBoth""")
)
                      

// @LINE:36
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationBoth.getResults(), HandlerDef(this, "controllers.ApplicationBoth", "getResults", Seq(), "POST", """""", _prefix + """viewBothResults""")
)
                      

// @LINE:14
def uploadFile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationBoth.uploadFile(), HandlerDef(this, "controllers.ApplicationBoth", "uploadFile", Seq(), "POST", """""", _prefix + """uploadFileBoth""")
)
                      

// @LINE:40
def getResultsBoth(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationBoth.getResultsBoth(), HandlerDef(this, "controllers.ApplicationBoth", "getResultsBoth", Seq(), "POST", """""", _prefix + """viewBothFeatureResults""")
)
                      
    
}
                          

// @LINE:34
// @LINE:32
// @LINE:20
// @LINE:12
class ReverseApplicationCompare {
    

// @LINE:20
def choosefileCompare(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationCompare.choosefileCompare(), HandlerDef(this, "controllers.ApplicationCompare", "choosefileCompare", Seq(), "GET", """""", _prefix + """choosefileCompare""")
)
                      

// @LINE:32
def getResults(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationCompare.getResults(), HandlerDef(this, "controllers.ApplicationCompare", "getResults", Seq(), "POST", """""", _prefix + """viewCompResults""")
)
                      

// @LINE:12
def uploadFile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ApplicationCompare.uploadFile(), HandlerDef(this, "controllers.ApplicationCompare", "uploadFile", Seq(), "POST", """""", _prefix + """uploadFileComp""")
)
                      
    
}
                          
}
        
    