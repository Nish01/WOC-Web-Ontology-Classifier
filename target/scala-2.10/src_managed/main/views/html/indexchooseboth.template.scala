
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
object indexchooseboth extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <h1>Upload Ontology:</h1>
    
    """),_display_(Seq[Any](/*9.6*/form(action = routes.ApplicationBoth.uploadFile, 'enctype -> "multipart/form-data")/*9.89*/ {_display_(Seq[Any](format.raw/*9.91*/("""
   
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
                    DATE: Sat Feb 24 22:41:41 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/indexchooseboth.scala.html
                    HASH: 060048d650e4237571aaeb81e578884ce04023c1
                    MATRIX: 784->1|911->18|939->37|975->39|1029->85|1068->87|1148->133|1239->216|1278->218|1332->236|1363->245|1534->385
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|47->19
                    -- GENERATED --
                */
            