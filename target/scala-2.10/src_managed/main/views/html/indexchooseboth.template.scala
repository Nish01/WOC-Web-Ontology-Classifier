
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
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier")/*5.41*/ {_display_(Seq[Any](format.raw/*5.43*/("""
    <section class="Using">
		<div class="container">

    <h3><b>Upload Ontology:</b></h3>
    
    """),_display_(Seq[Any](/*11.6*/form(action = routes.ApplicationBoth.uploadFile, 'enctype -> "multipart/form-data")/*11.89*/ {_display_(Seq[Any](format.raw/*11.91*/("""
   
   		<h3><i>"""),_display_(Seq[Any](/*13.14*/(message))),format.raw/*13.23*/("""</i></h3>   
	  <!--   <input type="file" name="ontology">	    
	    <p class="buttons">
	        <input type="submit">
	    </p> -->
 				<div class="row">
				    <div class="col-md-4">
		 			 <input class="btn btn-primary" type="file" name="ontology">
		    	 	</div>
 					<div class="col-md-1"> 
		 			<input class="btn btn-primary" type="submit" value="Submit" onclick="return loading();" />
		    		</div>

				</div>	
				
				<div id="loading" class="bs-example-bg-classes" hidden>
				<p class="bg-info">Classifying and Loading Ontology... (This may take a few seconds)</p>
				</div>	
	""")))})),format.raw/*31.3*/("""
    	</div>

	</section>

	
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 04 14:03:51 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/indexchooseboth.scala.html
                    HASH: a3d731c5319fd7a9d7aa6e540f1875388461c0a2
                    MATRIX: 784->1|911->18|939->37|975->39|1022->78|1061->80|1199->183|1291->266|1331->268|1385->286|1416->295|2045->893
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|39->11|41->13|41->13|59->31
                    -- GENERATED --
                */
            