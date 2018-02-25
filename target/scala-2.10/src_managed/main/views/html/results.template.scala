
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object results extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[String],List[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(selected: List[String], results: List[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Viewer")/*5.37*/ {_display_(Seq[Any](format.raw/*5.39*/("""
    
    <h1>Selected Features:</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*13.4*/for(index <- 0 until selected.size()) yield /*13.41*/{_display_(Seq[Any](format.raw/*13.42*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*16.15*/selected(index))),format.raw/*16.30*/("""</span>
			</li>
		
		""")))})),format.raw/*19.4*/("""
		
		</ul>
		
		    <h1>Results:</h1>
      
 
      
		<ul>

		"""),_display_(Seq[Any](/*29.4*/for(index <- 0 until results.size()) yield /*29.40*/{_display_(Seq[Any](format.raw/*29.41*/("""
		    
		    <li>
		    	<span>"""),_display_(Seq[Any](/*32.15*/results(index))),format.raw/*32.29*/("""</span>
			</li>
		
		""")))})),format.raw/*35.4*/("""
		
		</ul>
        


""")))})))}
    }
    
    def render(selected:List[String],results:List[String]): play.api.templates.HtmlFormat.Appendable = apply(selected,results)
    
    def f:((List[String],List[String]) => play.api.templates.HtmlFormat.Appendable) = (selected,results) => apply(selected,results)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/results.scala.html
                    HASH: c9300de714607019c6dd56076df59ce95d597d87
                    MATRIX: 795->1|952->48|980->67|1016->69|1059->104|1098->106|1198->171|1251->208|1290->209|1359->242|1396->257|1450->280|1551->346|1603->382|1642->383|1711->416|1747->430|1801->453
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|41->13|41->13|41->13|44->16|44->16|47->19|57->29|57->29|57->29|60->32|60->32|63->35
                    -- GENERATED --
                */
            