
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
object indexchoosefilecompare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <h1>Upload Ontology:</h1>
    
    """),_display_(Seq[Any](/*9.6*/form(action = routes.ApplicationCompare.uploadFile, 'enctype -> "multipart/form-data")/*9.92*/ {_display_(Seq[Any](format.raw/*9.94*/("""
   
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
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/indexchoosefilecompare.scala.html
                    HASH: e58699970c1321f6dad60300e8f116d9f5531432
                    MATRIX: 791->1|918->18|946->37|982->39|1036->85|1075->87|1155->133|1249->219|1288->221|1342->239|1373->248|1544->388
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|39->11|39->11|47->19
                    -- GENERATED --
                */
            