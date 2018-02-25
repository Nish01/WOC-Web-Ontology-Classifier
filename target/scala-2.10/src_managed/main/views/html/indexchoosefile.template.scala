
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
object indexchoosefile extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <h1>Upload Ontology:</h1>
    
    """),_display_(Seq[Any](/*9.6*/form(action = routes.ApplicationReverse.uploadFile, 'enctype -> "multipart/form-data")/*9.92*/ {_display_(Seq[Any](format.raw/*9.94*/("""
   
   		<h3><i>"""),_display_(Seq[Any](/*11.14*/(message))),format.raw/*11.23*/("""</i></h3>
   
	    <input type="file" name="ontology">	    
	    
	    <p class="buttons">
	        <input type="submit">
	    </p>
	    
	""")))})),format.raw/*19.3*/("""
    
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Feb 24 22:41:42 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/indexchoosefile.scala.html
                    HASH: 23337a8eb01beada016265f614a8205d0bdc0dc3
                    MATRIX: 784->1|911->18|939->37|975->39|1029->85|1068->87|1148->133|1242->219|1281->221|1335->239|1366->248|1537->388
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|47->19
                    -- GENERATED --
                */
            