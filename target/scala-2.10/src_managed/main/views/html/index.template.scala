
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "Web Ontology Classifier/Viewer")/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""
    
    <section class="jumbotron">
	<div class="container">
     <h2>The Bee Genus Plesianthidium Cameron</h2>
     

     <p>
     The southern African bee genus iPlesianthidium Cameron is revised. It comprises twelve species. 
     Two new species were described, namely Plesianthidium (Spinanthidium) richtersveldensis and 
     Plesianthidium (Spinanthidium) namaquaensis. Two species names have been removed from synonymy 
     with volkmanni; namely calvini and rufocaudatum that are here considered to be valid species. 
     Keys for the identification of the species of Plesianthidium is given.
	</p>
	

	<p id="keywords">
	<b>Key words:</b> Afrotropical, pollinator, pollen collector, southern Africa
     
    </p>  
         <br>
			    <div class="row">
				    <div class="col-md-12 col-md-offset-1">
		 			<img src=""""),_display_(Seq[Any](/*28.18*/routes/*28.24*/.Assets.at("images/im.jpg"))),format.raw/*28.51*/("""" alt="Bee Genus"  height="459" width="459">
		    	<!-- 	</div>
 					<div class="col-md-6"> -->
		 			<img src=""""),_display_(Seq[Any](/*31.18*/routes/*31.24*/.Assets.at("images/b.jpg"))),format.raw/*31.50*/("""" alt="Bee Genus" height="459" width="459">
		    		</div>

				</div>	
    
</div>
</section>

<section class="Using">
<div class="container">
    <h3>Using The Application:</h3>
    
   
   		<h3><i>"""),_display_(Seq[Any](/*44.14*/(message))),format.raw/*44.23*/("""</i></h3>
   
	   
	    <p>This application allows you to load and classify an ontology (subjected to our specific ontology modeling 'hooks')
	    and perform certain classification queries over the ontology.	    <br>
	        <br>
	  By clicking the link 'CLASSIFY and QUERY' in the menu bar, you will be directed to an upload page. Browse for your ontology 
	  and select it to upload. <br> <br> 
	  It will now classify the ontology or tell you that the file is of an incorrect format if not a .owl file. <br>
	  *Please be patient as some large ontologies may take a few minutes to classify.
	  <br>
	 <br>
	 Once classified a page will load with the ontology data. The first column will consist of the Diagnostic Features
	 and the right column will list the Elements which are associated with some diagnostic features.
	    <br> <br> 
	 Make a selection from one of the columns and click the respective Submit button to query the ontology.  
	   
	    
	    </p>
  

    <p><b>Disclaimer:</b> Please be aware that this application is still in its testing stages and can still be subject to errors.</P>
    
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
                    DATE: Sun Feb 25 11:58:23 CAT 2018
                    SOURCE: C:/Users/nish/Desktop/s/woc-master 2018/woc-master/app/views/index.scala.html
                    HASH: 29ffd386b9d5187ca438f98ca365c0250b4aa3f4
                    MATRIX: 774->1|901->18|929->37|965->39|1019->85|1058->87|1929->922|1944->928|1993->955|2144->1070|2159->1076|2207->1102|2445->1304|2476->1313
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|56->28|56->28|56->28|59->31|59->31|59->31|72->44|72->44
                    -- GENERATED --
                */
            